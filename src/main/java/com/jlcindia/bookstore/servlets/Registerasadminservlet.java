package com.jlcindia.bookstore.servlets;

import java.io.IOException;

import com.jlcindia.bookstore.service.UserService;
import com.jlcindia.bookstore.to.UserTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 

@WebServlet(name = "regasadmin", urlPatterns = "/regasadmin.jlc") 
public class Registerasadminservlet extends JLCBaseServlet { 
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
System.out.println("RegisterServlet-service()"); 
// 1.Collect the Input 
String fullName = req.getParameter("fullName"); 
String email = req.getParameter("email"); 
String phone = req.getParameter("phone");
String username = req.getParameter("username"); 
String password = req.getParameter("password"); 
// 2.Process 
UserTO userTO = new UserTO(); 
userTO.setFullName(fullName); 
userTO.setEmail(email); 
userTO.setPhone(Long.parseLong(phone)); 
userTO.setUsername(username); 
userTO.setPassword(password);
userTO.setRole("admin");
int x = userService.registerasadmin(userTO); 
// 3.Prepare to forward 
String page = ""; 
if (x == 1) { 
page = "login.jsp"; 
String regMsg = "Congrats, Login as admin first time"; 
req.setAttribute("RegMsg", regMsg); 
} else { 
page = "registerasadmin.jsp"; 
String regMsg = "Registration failed, Try again"; 
req.setAttribute("RegMsg", regMsg); 
} 
RequestDispatcher rd = req.getRequestDispatcher(page); 
rd.forward(req, res); 
} 
}


