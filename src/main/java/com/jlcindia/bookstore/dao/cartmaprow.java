package com.jlcindia.bookstore.dao;


import java.sql.ResultSet; 
import java.sql.SQLException;

import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.Cart;
import com.jlcindia.bookstore.to.UserTO; 
import com.jlc.bookstore.util.RowMapper; 


public class cartmaprow implements RowMapper{ 
	 @Override 
	 public Object mapRow(ResultSet rs) throws SQLException { 
	 System.out.println("UserRowMapper - bookRow()"); 
	 Cart book=new Cart(); 
	 book.setCartid(rs.getInt(1));
	 book.setUserName(rs.getString(2));
	 book.setBookName(rs.getString(3)); 
	 book.setAuthor(rs.getString(4));
	 book.setPrice(rs.getInt(5)); 
	 book.setQuantity(rs.getInt(6));
	
	 
	 System.out.println(book.getAuthor()+book.getBookName());
	 return book; 
	 } 
	}

