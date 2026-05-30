package com.jlcindia.bookstore.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*; 
import com.jlcindia.bookstore.service.UserService; 
import com.jlcindia.bookstore.service.UserServiceImpl; 

public abstract class JLCBaseController { 
static UserService userService; 
static { 
userService = new UserServiceImpl(); 
} 
public abstract String process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception; 
}

