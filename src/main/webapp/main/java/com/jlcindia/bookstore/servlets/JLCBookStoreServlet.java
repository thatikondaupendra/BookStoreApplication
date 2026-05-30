package com.jlcindia.bookstore.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.jlcindia.bookstore.controllers.JLCBaseController; 
import com.jlcindia.bookstore.controllers.*;

@WebServlet(name="myControllerServlet",urlPatterns = "*.jlc",loadOnStartup = 1) 
public class JLCBookStoreServlet extends JLCBaseServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	String URI = request.getRequestURI(); 
	System.out.println(URI); 
	JLCBaseController mycontroller=null; 
	String page=""; 
	if(URI.endsWith("mylogin.jlc")) { 
	mycontroller = loginController; 
	} else if(URI.endsWith("myreg.jlc")) { 
	mycontroller = registerController; 
	} else if(URI.endsWith("changepw.jlc")) { 
	mycontroller = changePWController; 
	} else if(URI.endsWith("mypassword.jlc")) { 
	mycontroller = forgotPWController; 
	} else if(URI.endsWith("updateProfile.jlc")) { 
	mycontroller = updateProfileController; 
	} else if(URI.endsWith("editProfile.jlc")) { 
	mycontroller = updateProfileController; 
	}else if(URI.endsWith("mylogout.jlc")) { 
	mycontroller = logoutController; 
	} 
	try {
		page= mycontroller.process(request, response);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	RequestDispatcher rd=request.getRequestDispatcher(page); 
	rd.forward(request, response); 
	} 
	}