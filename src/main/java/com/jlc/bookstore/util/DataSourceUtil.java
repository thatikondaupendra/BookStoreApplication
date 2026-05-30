package com.jlc.bookstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.sql.Statement; 

public class DataSourceUtil{
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Upendra@545");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	} 
		public static void cleanUp(Statement st, Connection con) { 
		try { 
		if (st != null) 
		st.close(); 
		if (con != null) 
		con.close(); 
		} catch (Exception e) { 
		e.printStackTrace(); 
		} 
		} 
		public static void cleanUp(ResultSet rs, Statement st, Connection con) { 
		try { 
		if (rs != null) 
		rs.close(); 
		if (st != null) 
		st.close(); 
		if (con != null) 
		con.close(); 
		} catch (Exception e) {
			e.printStackTrace(); 
		} 
		} 
		}	