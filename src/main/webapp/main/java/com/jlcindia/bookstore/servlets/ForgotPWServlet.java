package com.jlcindia.bookstore.servlets;

import java.io.IOException;

import com.jlcindia.bookstore.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 

@WebServlet(name = "mypassword", urlPatterns = "/mypassword.jlc") 
public class ForgotPWServlet extends JLCBaseServlet { 
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
System.out.println("ForgotPWServlet-service()");

//1.Collect the Input 
String email = req.getParameter("email"); 
System.out.println(email);
//2.Process 
String pw = userService.getPassword(email); 
System.out.println(pw);
//3.Prepare to forward 
String page = ""; 
if (pw == null) { 
page = "forgotpw.jsp"; 
String msg = "Invalid Email ID"; 
req.setAttribute("MyMsg", msg); 
} else { 
page = "passwordInfo.jsp"; 
req.setAttribute("MyPassword", pw); 
} 
RequestDispatcher rd = req.getRequestDispatcher(page); 
rd.forward(req, res); 
} 
}
//9618814101