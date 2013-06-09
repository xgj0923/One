package com.db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Rt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        java.sql.Connection conn = null;
		java.sql.Statement stmt;
		ResultSet rs;
		String sql = "select name  from test";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();    //加载驱动
            String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
            conn = DriverManager.getConnection(url, "root", "root");
            stmt = conn.createStatement();
            rs=(ResultSet) stmt.executeQuery(sql);
            while(rs.next()){
            	System.out.println(rs.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MySql驱动没找到");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }        
	}

}
