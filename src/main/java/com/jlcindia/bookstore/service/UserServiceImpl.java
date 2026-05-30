package com.jlcindia.bookstore.service;

import java.util.List;

import com.jlcindia.bookstore.dao.DAOFactory; 
import com.jlcindia.bookstore.dao.UserDAO;
import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.UserTO; 

public class UserServiceImpl implements UserService{ 
 @Override 
 public int registerUser(UserTO userTO) { 
 System.out.println("UserService - registerUser()"); 
 UserDAO userDAO= DAOFactory.getUserDAO(); 
 return userDAO.registerUser(userTO); 
 } 
 
 @Override 
 public int registerasadmin(UserTO userTO) { 
 System.out.println("UserService - registerasadmin()"); 
 UserDAO userDAO= DAOFactory.getUserDAO(); 
 return userDAO.registerasadmin(userTO); 
 } 
 @Override 
 public UserTO verifyUser(String username, String password) { 
 System.out.println("UserService - verifyUser()"); 
 UserDAO userDAO= DAOFactory.getUserDAO();
 return userDAO.verifyUser(username, password); 
 } 
 @Override 
 public UserTO verifyAdmin(String username, String password) { 
 System.out.println("AdminService - verifyAdmin()"); 
 UserDAO userDAO= DAOFactory.getUserDAO();
 return userDAO.verifyAdmin(username, password); 
 } 
 @Override 
 public String getPassword(String email) { 
 UserDAO userDAO= DAOFactory.getUserDAO(); 
 return userDAO.getPassword(email); 
 } 
 @Override 
 public int changePassword(int userId, String newPassword,String role) { 
 UserDAO userDAO= DAOFactory.getUserDAO(); 
 return userDAO.changePassword(userId, newPassword,role); 
 } 
 @Override 
 public UserTO getUserByUserId(int userId) { 
 System.out.println("UserServiceImpl-getUserByUserId()"); 
 UserDAO userDAO=DAOFactory.getUserDAO(); 
 UserTO userTO=userDAO.getUserByUserId(userId); 
 return userTO; 
 } 
 @Override 
 public UserTO getAdminByUserId(int userId) { 
 System.out.println("UserServiceImpl-getAdminByUserId()"); 
 UserDAO userDAO=DAOFactory.getUserDAO(); 
 UserTO userTO=userDAO.getAdminByUserId(userId); 
 return userTO; 
 } 
 @Override 
 public int updateProfile(UserTO userTO) { 
 UserDAO userDAO= DAOFactory.getUserDAO(); 
 return userDAO.updateProfile(userTO); 
 }
 @Override 
 public int addbook(Book book) { 
	 System.out.println("addbookservice -entered");
 UserDAO userDAO= DAOFactory.getUserDAO(); 
 return userDAO.addbook(book); 
 } 
 @Override
 public int cartEffect(String author, String bookname) {
	 UserDAO userDAO = DAOFactory.getUserDAO();
	return userDAO.cartEffect(author,bookname);
	 
 }

 @Override
 public List<Book> searchbook(String bookname) {
	 UserDAO userDAO = DAOFactory.getUserDAO();
	return userDAO.searchbook(bookname);
	 
 }
}