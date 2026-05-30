package com.jlcindia.bookstore.to;

import java.sql.Connection;

import com.jlc.bookstore.util.DataSourceUtil;

public class UserTO { 
	 
private int userId; 
private String fullName; 
private String email; 
private long phone; 
private String dob; 
private String gender; 
private String username; 
private String password; 
private String status; 
private String city;
//Constructors 
//Setters and Getters 
public Object getFullName() {
	// TODO Auto-generated method stub
	System.out.println(fullName);
	return fullName;
	
}
public Object getEmail() {
	// TODO Auto-generated method stub
	return email;
}
public Object getPhone() {
	// TODO Auto-generated method stub
	return phone;
}
public Object getDob() {
	// TODO Auto-generated method stub
	return dob;
}
public Object getGender() {
	// TODO Auto-generated method stub
	return gender;
}
public Object getUsername() {
	// TODO Auto-generated method stub
	return username;
}
public String getCity() {
	return city;
}
public String getPassword() {
	// TODO Auto-generated method stub
	return password;
}
public Object getStatus() {
	// TODO Auto-generated method stub
	return status;
}
public Object getUserId() {
	// TODO Auto-generated method stub
	return userId;
}
public void setUserId(int int1) {
	// TODO Auto-generated method stub
	userId=int1;
	
	
}
public void setStatus(String string) {
	// TODO Auto-generated method stub
	status=string;
}
public void setPassword(String string) {
	// TODO Auto-generated method stub
	password=string;
}
public void setcity(String string) {
	city=string;
}
public void setUsername(String string) {
	// TODO Auto-generated method stub
	username=string;
}
public void setGender(String string) {
	// TODO Auto-generated method stub
	System.out.println("setGenderMethod"+string);
	gender=string;
}
public void setDob(String string) {
	// TODO Auto-generated method stub
	dob=string;
}
public void setPhone(Long long1) {
	// TODO Auto-generated method stub
	phone=long1;
}
public void setEmail(String string) {
	// TODO Auto-generated method stub
	email=string;
}
public void setFullName(String string) {
	// TODO Auto-generated method stub
	fullName=string;
}
}
