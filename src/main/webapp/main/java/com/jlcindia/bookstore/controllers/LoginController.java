package com.jlcindia.bookstore.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import com.jlcindia.bookstore.service.UserService;
import com.jlcindia.bookstore.to.UserTO; 

public class LoginController extends JLCBaseController { 
 
public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
 System.out.println("LoginController-process()"); 
 
 // 1.Collect the Input 
 String username = req.getParameter("username"); 
 String password = req.getParameter("password"); 
 // 2.Process 
 UserTO userTO = userService.verifyUser(username, password); 
 // 3.Prepare to forward 
 String page = ""; 
 if (userTO != null) { 
 page = "home.jsp"; 
 HttpSession session = req.getSession(); 
 session.setAttribute("MyUserInfo", userTO); 
 } else { 
 page = "login.jsp"; 
 String loginMsg = "Invalid Username or Password"; 
 req.setAttribute("LoginMsg", loginMsg); 
 } 
 return page; 
 } 
}
