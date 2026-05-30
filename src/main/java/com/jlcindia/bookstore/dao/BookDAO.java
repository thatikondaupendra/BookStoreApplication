package com.jlcindia.bookstore.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jlc.bookstore.util.JdbcTemplate;
import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.Cart;
import com.jlcindia.bookstore.to.UserTO;

public class BookDAO {

    public List<Book> getAllBooks() {
    	String SQL="select * from books"; 
    	@SuppressWarnings("unchecked")
		List<Book> book= JdbcTemplate.queryForList(SQL, new UserRowmapper3()); 
    	return book; 
    }
    
    public List<Cart> getcartBooks(String user) {
    	System.out.println("getcartbooks-dao");
    	String SQL="select * from cart where username=?"; 
    	@SuppressWarnings("unchecked")
		List<Cart> books = JdbcTemplate.queryForList(SQL, new cartmaprow(),user);
        return books; 
    }
    
    public List<Cart> removecartBooks(String user,String bookname,String author) {
    	System.out.println("removecartbook-dao");
    	String SQL1="select * from cart where username=? and bookname=?"; 
    	Cart quantityobj=(Cart) JdbcTemplate.queryForObject(SQL1, new cartmaprow(), user,bookname);
    	String sql2="update books set quantity = quantity+? where bookname=? and author=?";
    	@SuppressWarnings("unchecked")
		int book1= JdbcTemplate.update(sql2,quantityobj.getQuantity(),bookname,author); 
    	String sql3="delete from cart where bookname=? and author = ?";
    	int book2=JdbcTemplate.update(sql3,bookname,author); 
    	
    	
    	System.out.println(quantityobj.getQuantity());
		return getcartBooks(user);
    	
    }
    

    
    public int updatecart(String user,String bookname,int cartid) {
    	String sql1="select * from books where bookname=?";
    	Book book=(Book) JdbcTemplate.queryForObject(sql1, new UserRowmapper3(), bookname);
    	System.out.println(book.getAuthor()+"author from update dao");
    	String sql2="select * from cart where username = ? and bookname=?";
    	Cart cart=(Cart) JdbcTemplate.queryForObject(sql2, new cartmaprow(),user,bookname);
    	
    	if (book.getQuantity()>0 && cart.getQuantity()<book.getQuantity()-1) {

    	String SQL="UPDATE cart SET quantity = quantity + 1, total = price * (quantity)  where cartid=?";
    	
    	@SuppressWarnings("unchecked")
		int book1= JdbcTemplate.update(SQL,cartid); 
    	return book1; 
    	}
    	else {
    		return 0;
    	}
    }
    
	public int addtocart(String fn,String bn, String author,double price,int quantity) {
		// TODO Auto-generated method stub
		System.out.println("addtocartDAO");
    	String sql1="select * from books where author=? and bookname=?";
    	Book book=(Book) JdbcTemplate.queryForObject(sql1, new UserRowmapper3(),author,bn);
    	if(book.getQuantity()>0) {
    	String SQL="insert into cart (username,bookname,author,price,quantity,total) values (?,?,?,?,?,?)";
    	String SQL1="update books set quantity = quantity-1 where author=? and bookname=?"; 
    	int x = JdbcTemplate.update(SQL1,author,bn);
    	@SuppressWarnings("unchecked")
		int book1= JdbcTemplate.update(SQL,fn,bn,author,price,quantity,(int)(price*quantity)); 
    	return book1; 
	}
    	else {
    		return 0;
    	}
	}

	public List<UserTO> getAllCustomers() {
    	String SQL="select * from myusers"; 
    	@SuppressWarnings("unchecked")
		List<UserTO> customer= JdbcTemplate.queryForList(SQL, new UserRowMapper()); 
    	return customer; 
	}

	public int removefromstore(String bookName, String author) {
    	System.out.println("removefromstore-dao");
    	String SQL1="delete from books where author=? and bookname=?";
    	int res=JdbcTemplate.update(SQL1, author,bookName);
    	
		return res;
	}

	public int removefromcustomers(String fullname, String phone, String gender) {
    	System.out.println("removefromcustomers-dao");
    	String SQL1="delete from myusers where fullname=? and phone=? and gender=?";
    	int res=JdbcTemplate.update(SQL1, fullname,phone,gender);
    	
		return res;
	}

}

