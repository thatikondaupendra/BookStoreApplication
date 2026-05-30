package com.jlcindia.bookstore.servlets;


import jakarta.servlet.http.HttpServlet; 
import com.jlcindia.bookstore.controllers.ChangePWController; 
import com.jlcindia.bookstore.controllers.ForgotPWController; 
import com.jlcindia.bookstore.controllers.LoginController; 
import com.jlcindia.bookstore.controllers.LogoutController; 
import com.jlcindia.bookstore.controllers.RegisterController; 
import com.jlcindia.bookstore.controllers.UpdateProfileController;
import com.jlcindia.bookstore.service.UserService;
import com.jlcindia.bookstore.service.UserServiceImpl; 

public abstract class JLCBaseServlet extends HttpServlet { 
 
 static LoginController loginController; 
 static RegisterController registerController; 
 static ChangePWController changePWController; 
 static ForgotPWController forgotPWController; 
 static UpdateProfileController updateProfileController; 
 static LogoutController logoutController; 
 
 static { 
 loginController = new LoginController(); 
 registerController = new RegisterController(); 
 changePWController = new ChangePWController(); 
 forgotPWController = new ForgotPWController(); 
 updateProfileController = new UpdateProfileController(); 
 logoutController = new LogoutController(); 
 } 
 public static UserService userService; 
 
 static { 
 userService = new UserServiceImpl(); 
 } 
}

