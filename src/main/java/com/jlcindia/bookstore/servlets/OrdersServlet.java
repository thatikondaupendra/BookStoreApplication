package com.jlcindia.bookstore.servlets;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import com.jlcindia.bookstore.dao.OrderDAO;
import com.jlcindia.bookstore.to.Order;
import com.jlcindia.bookstore.to.UserTO;

@WebServlet("/OrdersServlet")
public class OrdersServlet extends JLCBaseServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	System.out.println("orderservlet - entered");       
    	HttpSession session = request.getSession(false);
        
    	UserTO userto = (UserTO) session.getAttribute("MyUserInfo");
    	System.out.println(userto.getFullName()+"userfullname in orderservlet");

        String username = (String) userto.getFullName();
        OrderDAO dao = new OrderDAO();
        List<Order> orders = dao.getOrdersByUser(username);
        
        session.setAttribute("username",username);
        session.setAttribute("orders", orders);
        
        System.out.println(session.getAttribute("success")+"+++++++++++++++");
        System.out.println(session.getAttribute("orders"));
        System.out.println("last of orderservlet");
        RequestDispatcher rd = request.getRequestDispatcher("orders.jsp");
        rd.forward(request, response);
    }}

