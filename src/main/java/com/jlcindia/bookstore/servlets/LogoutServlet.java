package com.jlcindia.bookstore.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;  

@WebServlet(name = "mylogout", urlPatterns = "/mylogout.jlc") 
public class LogoutServlet extends JLCBaseServlet { 
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
System.out.println("LogoutServlet-service()"); 
String page = "login.jsp"; 
HttpSession session = req.getSession(false); 
if (session != null) 
session.invalidate(); 
String logoutMsg = "You have logged out Successfully"; 
req.setAttribute("LogoutMsg", logoutMsg); 
RequestDispatcher rd = req.getRequestDispatcher(page); 
rd.forward(req, res); 
} 
}
