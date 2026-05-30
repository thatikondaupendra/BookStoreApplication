package com.jlcindia.bookstore.dao;


import java.sql.ResultSet; 
import java.sql.SQLException; 
import com.jlcindia.bookstore.to.UserTO; 
import com.jlc.bookstore.util.RowMapper; 


public class UserRowMapper2 implements RowMapper{ 
	 @Override 
	 public Object mapRow(ResultSet rs) throws SQLException { 
	 System.out.println("UserRowMapper - mapRow()"); 
	 UserTO userTO = new UserTO(); 
	 userTO.setUserId(rs.getInt(1)); 
	 userTO.setFullName(rs.getString(2)); 
	 userTO.setEmail(rs.getString(3)); 
	 userTO.setPhone(new Long(rs.getString(4))); 
	 userTO.setUsername(rs.getString(5)); 
	 userTO.setPassword(rs.getString(6));
	 userTO.setRole(rs.getString(7));
	 
	 return userTO; 
	 } 
	}

