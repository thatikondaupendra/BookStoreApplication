package com.jlcindia.bookstore.servlets;

import java.io.IOException;

import com.jlcindia.bookstore.service.UserService;
import com.jlcindia.bookstore.to.UserTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; 

@WebServlet(name = "updateProfile", 
 urlPatterns = { "/editProfile.jlc", "/updateProfile.jlc" }) 
public class UpdateProfileServlet extends JLCBaseServlet { 
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
System.out.println("UpdateProfileServlet-service()"); 
String URI = req.getRequestURI(); 
int updateStatus = 0; 
String page = ""; 
if (URI.endsWith("editProfile.jlc")) { 
HttpSession session = req.getSession(false); 
if (session == null) { 
String msg = "Session Expired. Login Again"; 
req.setAttribute("LoginMsg", msg); 
page = "login.jsp"; 
}
else { 
UserTO userTO = (UserTO) session.getAttribute("MyUserInfo"); 
int userId = (int) userTO.getUserId(); 
UserTO myuserTO = userService.getUserByUserId(userId); 
session.setAttribute("MyUserInfo", myuserTO); 
page = "updateProfile.jsp"; 
}
} else if (URI.endsWith("updateProfile.jlc")) { 
String userId = req.getParameter("userId"); 
String fullName = req.getParameter("fullName"); 
String email = req.getParameter("email"); 
String phone = req.getParameter("phone"); 
String username = req.getParameter("username"); 
UserTO userTO = new UserTO(); 
userTO.setUserId(Integer.parseInt(userId)); 
userTO.setFullName(fullName); 
userTO.setEmail(email); 
userTO.setPhone(Long.parseLong(phone)); 
userTO.setUsername(username); 
updateStatus = userService.updateProfile(userTO); 
if (updateStatus==1) { 
page = "updateProfileStatus.jsp"; 
String upMsg = "Your Profile is updated Successfully"; 
req.setAttribute("UpdateMsg", upMsg); 
} else { 
page = "updateProfile.jsp"; 
String upMsg = "Something Wrong, Try again"; 
req.setAttribute("UpdateMsg", upMsg); 
} 
} 
RequestDispatcher rd = req.getRequestDispatcher(page); 
rd.forward(req, res); 
} 
}
