package com.test;

import java.sql.SQLException;

import com.db.JdbcConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Love {
	public String love(){
		String str = "like2 you";
		String sql = "select cname  from course";
		JdbcConnection jc = new JdbcConnection();
		Connection con;
		Statement stmt;
		ResultSet rs;
		try {
			 con =  (Connection) jc.getConnection();
			 stmt=(Statement) con.createStatement();
			 rs=(ResultSet) stmt.executeQuery(sql);
			while(rs.next()){
				str = rs.getString("cname");
				System.out.println("mmm:"+str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}
}
