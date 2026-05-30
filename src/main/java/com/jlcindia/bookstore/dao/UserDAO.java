package com.jlcindia.bookstore.dao;

import java.util.List;

import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.UserTO; 

public interface UserDAO { 
public int registerUser(UserTO userTO); 
public int registerasadmin(UserTO userTO); 
public UserTO verifyUser(String username,String password); 
public UserTO verifyAdmin(String username,String password); 
public String getPassword(String email); 
public int changePassword(int userId,String newPassword,String role); 
public UserTO getUserByUserId(int userId) ; 
public int updateProfile(UserTO userTO);
public int addbook(Book book);
public int cartEffect(String author, String bookname);
public List<Book> searchbook(String bookname);
public UserTO getAdminByUserId(int userId); 
}

