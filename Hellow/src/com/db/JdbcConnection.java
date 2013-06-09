package com.db;
 
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
 
 import javax.naming.Context;
 import javax.naming.InitialContext;
 import javax.naming.NamingException;
 import javax.sql.DataSource;
 
 /**
 * ���ݿ����ӹ�����
 * @version 1.0
 */
 public class JdbcConnection {
     
     // �����̱߳��ر�����ÿ���̷߳����������ò�ͬ�Ķ���
 // ʹ��ThreadLocalʹһ�����Ӱ󶨵�һ���߳���
     private static ThreadLocal<Connection> currentConnection = new ThreadLocal<Connection>();
     private static String username=null;            //�û���
     private static String password=null;            //����
     private static String dbName=null;                //���ݿ�����
     private static String ip=null;                        //���ݿ������IP��ַ
     private static String resourceName=null;                                        //Ϊnullʱ��ʹ�����ӳأ� jdbc/mysql��jdbc/oracle��jdbc/derby
     private static String databaseType = "mysql";    
     
     private static void initParams(){
       username=DbConfig.getInstance().getDb_username();            
       password=DbConfig.getInstance().getDb_password();            
       dbName=DbConfig.getInstance().getDb_name();                
       ip=DbConfig.getInstance().getIp();                        
     }
     
     /**
      * 
      * @return �õ�һ�����ݿ�����
      * @throws SQLException
 */
     public static Connection getConnection() throws SQLException {
         Connection conn = currentConnection.get();
         if (conn == null) {
             if(null==resourceName){
                 if("mysql".equals(databaseType.toLowerCase())){
                     conn = getMySqlConnection();
                 }else if("oracle".equals(databaseType.toLowerCase())){
                     conn = getOracleConnection();
                 }else if("derby".equals(databaseType.toLowerCase())){
                     conn = getDerbyConnection();
                 }else{
                     System.out.println("�� JdbcConnection.java �����ݿ�����û������");
                     throw new SQLException("���ݿ�����δ����");
                 }
             }else{
                 conn = getConnectionByPool();
             }            
             currentConnection.set(conn);
         }
         return conn;
     }
     /**
      * �ر�Oracle���ݿ�����
      * @throws SQLException
 */
     public static void closeConnection() throws SQLException{
         Connection conn = currentConnection.get();
         conn.close();
         currentConnection.set(null);
     }
     //���Oracle���ݿ�����
     private static Connection getOracleConnection(){
         initParams();
         Connection conn = null;
         try {
             Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();    //��������
             conn= DriverManager.getConnection("jdbc:oracle:thin:@"+ip+":1521:"+dbName,username,password);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
             System.out.println("Oracle����û�ҵ�");
         } catch (InstantiationException e) {
             e.printStackTrace();
         } catch (IllegalAccessException e) {
             e.printStackTrace();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return conn;
     }
     //���MySql���ݿ�����
     private static Connection getMySqlConnection(){
         initParams();
         Connection conn = null;
         try {
             Class.forName("com.mysql.jdbc.Driver").newInstance();    //��������
             String url = "jdbc:mysql://"+ip+":3306/"+dbName+"?useUnicode=true&characterEncoding=utf8";
             conn = DriverManager.getConnection(url, username, password);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
             System.out.println("MySql����û�ҵ�");
         } catch (SQLException e) {
             e.printStackTrace();
         } catch (InstantiationException e) {
             e.printStackTrace();
         } catch (IllegalAccessException e) {
             e.printStackTrace();
         }        
         return conn;
     }
     //��ȡDerby���ݿ�����
     private static Connection getDerbyConnection(){
         initParams();
         Connection conn = null;
         try {
             Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();    //��������
             String url = "jdbc:derby://"+ip+":1527/"+dbName+";create=true";
             conn = DriverManager.getConnection(url, username, password);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
             System.out.println("Derby����û�ҵ�");
         } catch (SQLException e) {
             e.printStackTrace();
         } catch (InstantiationException e) {
             e.printStackTrace();
         } catch (IllegalAccessException e) {
             e.printStackTrace();
         }        
         return conn;
     }
     //��ȡ���ӳ�����
     private static Connection getConnectionByPool(){        
         try {
             Context ctx = new InitialContext();
             Context subContext = (Context)ctx.lookup("java:comp/env");
             String dsName="";
             dsName = resourceName;
             
             DataSource dataSource = (DataSource)subContext.lookup(dsName);
             //����������Ժ�д���±����
 //ctx.lookup("java:comp/env/jdbc/oracle");// java:comp/env/ �涨����ǰ׺ָ����Դ
             return dataSource.getConnection();
         }
           catch (NamingException e) {e.printStackTrace();}
           catch (SQLException e) {e.printStackTrace();}
         return null;        
     }
 }