package com.jlcindia.bookstore.dao;

import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.UserTO;

import jakarta.servlet.http.HttpSession;

import java.util.List;

import com.jlc.bookstore.util.JdbcTemplate; 
public class UserDAOImpl implements UserDAO{ 
@Override 
public int registerUser(UserTO userTO) { 
System.out.println("UserDAO - registerUser()"); 
String SQL="insert into myusers(fullName,email,phone,dob,city,gender,username,password,status,role) values(?,?,?,?,?,?,?,?,?,?)"; 
int x =JdbcTemplate.update(SQL,userTO.getFullName(),userTO.getEmail(),userTO.getPhone(),userTO.getDob(),userTO.getCity(),userTO.getGender(),userTO.getUsername(),userTO.getPassword(),userTO.getStatus(),userTO.getRole()); 
return x; 
} 
@Override 
public int registerasadmin(UserTO userTO) { 
System.out.println("UserDAO - registerasadmin()"); 
String SQL="insert into admins(fullName, email, phone, username, password,role) values(?,?,?,?,?,?)"; 
int x =JdbcTemplate.update(SQL,userTO.getFullName(),userTO.getEmail(),userTO.getPhone(),userTO.getUsername(),userTO.getPassword(),userTO.getRole()); 
return x; 
} 
@Override 
public UserTO verifyUser(String username, String password) { 
System.out.println("UserDAO - verifyUser()"); 
String SQL="SELECT adminid,fullname,email,phone,username,password,role FROM admins WHERE username=? AND password=? UNION SELECT userId,fullname,email,phone,username,password,role FROM myusers WHERE username=? AND password=?"; 
Object obj = JdbcTemplate.queryForObject(SQL, new UserRowMapper2(), username, password,username,password); 
System.out.println(obj);
UserTO userTO= (UserTO) obj; 
System.out.println(userTO); 
System.out.println(userTO.getRole());
String role = (String)userTO.getRole();
if(role.equals("user")) {
	String Sql="select * from myusers where username=? and password=?";
	Object obj1 = JdbcTemplate.queryForObject(Sql, new UserRowMapper(), username, password); 
	UserTO user=(UserTO) obj1;
	return user;
}

else {
	String Sql="select * from admins where username=? and password=?";
	Object obj1 = JdbcTemplate.queryForObject(Sql, new UserRowMapper2(), username, password); 
	UserTO admin=(UserTO) obj1;
	System.out.println("admin entered");
	return admin;
}
} 

public UserTO verifyAdmin(String username, String password) { 
System.out.println("UserDAO - verifyUser()"); 
String SQL="SELECT * FROM admins WHERE username=? AND password=? UNION SELECT * FROM myusers WHERE username=? AND password=?"; 
Object obj = JdbcTemplate.queryForObject(SQL, new UserRowMapper2(), username, password,username, password); 
System.out.println(obj);
UserTO userTO= (UserTO) obj; 
System.out.println(userTO); 
return userTO; 
} 
@Override 
public String getPassword(String email) { 
String SQL="select * from myusers where email=?"; 
UserTO userTO= (UserTO) JdbcTemplate.queryForObject(SQL, new UserRowMapper(), email);
if(userTO==null) {
	return null;
}
return userTO.getPassword(); 
} 
@Override 
public int changePassword(int userId, String newPassword, String role) { 
	if(role.equals("user")){
String SQL="update myusers set password=? where userId=?"; 
int x =JdbcTemplate.update(SQL,newPassword,userId); 
return x; 
} 
	else {
		String SQL="update admins set password=? where adminid=?"; 
		int x =JdbcTemplate.update(SQL,newPassword,userId); 
		return x; 
	}
}
@Override 
public UserTO getUserByUserId(int userId) {
String SQL="select * from myusers where userId=?"; 
UserTO userTO= (UserTO) JdbcTemplate.queryForObject(SQL, new UserRowMapper(), userId); 
return userTO; 
} 

@Override 
public UserTO getAdminByUserId(int userId) {
String SQL="select * from admins where adminid=?"; 
UserTO userTO= (UserTO) JdbcTemplate.queryForObject(SQL, new UserRowMapper2(), userId); 
return userTO; 
} 
@Override 
public int updateProfile(UserTO userTO) { 
	String role = userTO.getRole();
	System.out.println("Role from updateProfile-userDao"+role);
	if(role.equals("user")) {
String SQL="update myusers set fullName=?, email=?, phone=? where userId=?"; 
int x = JdbcTemplate.update(SQL,userTO.getFullName(),userTO.getEmail(),userTO.getPhone(),userTO.getUserId());
return x; 
	}
	else {
		String SQL="update admins set fullName=?, email=?, phone=? where adminid=?"; 
		int x = JdbcTemplate.update(SQL,userTO.getFullName(),userTO.getEmail(),userTO.getPhone(),userTO.getUserId());
		return x; 
	}
} 
@Override
public int addbook(Book book) {
	String SQL="Select * from books where bookname=? and author=?";
	System.out.println("counting");
	int x=JdbcTemplate.forcheck(SQL,book.bookName,book.author);
	System.out.println(x);
	if(x==1) {
		System.out.println("updating existing book");
		SQL = "update books set quantity=quantity+?, price=? where author=? and bookname=?";
		x=JdbcTemplate.update(SQL,book.quantity,(int)book.price,book.author,book.bookName);
		return x;
	}
	else {
		System.out.println("new book adding from dao update");
		SQL="insert into books (bookname,author,price,quantity) values (?,?,?,?)";
		x=JdbcTemplate.update(SQL, book.bookName,book.author,book.price,book.quantity);
		return x;
	}
}
@Override 
public int cartEffect(String author, String bookname) { 
String SQL="update books set quantity = quantity-1 where author=? and bookname=?"; 
int x = JdbcTemplate.update(SQL,author,bookname);
return x; 
}
@Override
public List<Book> searchbook(String bookname) {
	// TODO Auto-generated method stub
	String sql = "select * from books where bookname = ?";
	List<Book> books = JdbcTemplate.queryForList(sql, new UserRowmapper3(),bookname);
	return books;
} 


}

