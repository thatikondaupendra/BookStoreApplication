package com.jlcindia.bookstore.servlets;

import java.io.IOException;

import com.jlcindia.bookstore.to.UserTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet("/buyform")
public class buyformServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	UserTO userto = (UserTO) session.getAttribute("MyUserInfo");
    	
        String username = (String) userto.getFullName();
        String bookname= request.getParameter("book");
        String author = request.getParameter("author");
        request.setAttribute("username",username);
        request.setAttribute("bookname", bookname);
        request.setAttribute("author", author);
    RequestDispatcher rd = request.getRequestDispatcher("paynow.jsp");
    rd.forward(request, response);
    }
}
