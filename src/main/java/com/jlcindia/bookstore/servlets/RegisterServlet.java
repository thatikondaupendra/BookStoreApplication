package com.jlcindia.bookstore.servlets;

import java.io.IOException;

import com.jlcindia.bookstore.service.UserService;
import com.jlcindia.bookstore.to.UserTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 

@WebServlet(name = "myreg", urlPatterns = "/myreg.jlc") 
public class RegisterServlet extends JLCBaseServlet { 
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
System.out.println("RegisterServlet-service()"); 
// 1.Collect the Input 
String fullName = req.getParameter("fullName"); 
String email = req.getParameter("email"); 
String phone = req.getParameter("phone");
String dob = req.getParameter("dob"); 
String city = req.getParameter("city"); 
String gender = req.getParameter("gender"); 
String username = req.getParameter("username"); 
String password = req.getParameter("password"); 
// 2.Process 
UserTO userTO = new UserTO(); 
userTO.setFullName(fullName); 
userTO.setEmail(email); 
userTO.setPhone(Long.parseLong(phone)); 
userTO.setDob(dob); 
userTO.setCity(city);
userTO.setGender(gender); 
userTO.setUsername(username); 
userTO.setPassword(password);
userTO.setStatus("Active"); 
userTO.setRole("user");
int x = userService.registerUser(userTO); 
// 3.Prepare to forward 
String page = ""; 
if (x == 1) { 
page = "login.jsp"; 
String regMsg = "Congrats, Login first time"; 
req.setAttribute("RegMsg", regMsg); 
} else { 
page = "register.jsp"; 
String regMsg = "Registration failed, Try again"; 
req.setAttribute("RegMsg", regMsg); 
} 
RequestDispatcher rd = req.getRequestDispatcher(page); 
rd.forward(req, res); 
} 
}

