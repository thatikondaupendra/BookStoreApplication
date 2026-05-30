package com.jlcindia.bookstore.dao;


import java.sql.ResultSet; 
import java.sql.SQLException;

import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.UserTO; 
import com.jlc.bookstore.util.RowMapper; 


public class UserRowmapper3 implements RowMapper{ 
	 @Override 
	 public Object mapRow(ResultSet rs) throws SQLException { 
	 System.out.println("UserRowMapper - bookRow()"); 
	 Book book = new Book(); 
	 book.setBookid(rs.getInt(1));
	 book.setBookName(rs.getString(2)); 
	 book.setAuthor(rs.getString(3));
	 book.setPrice(rs.getInt(4)); 
	 book.setQuantity(rs.getInt(5));
	 
	 return book; 
	 } 
	}

