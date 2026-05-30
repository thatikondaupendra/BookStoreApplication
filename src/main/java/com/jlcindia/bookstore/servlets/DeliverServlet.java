package com.jlcindia.bookstore.servlets;

import java.io.IOException;
import java.util.List;

import com.jlcindia.bookstore.dao.CartDAO;
import com.jlcindia.bookstore.dao.OrderDAO;
import com.jlcindia.bookstore.to.Cart;
import com.jlcindia.bookstore.to.Order;
import com.jlcindia.bookstore.to.OrderItem;
import com.jlcindia.bookstore.to.UserTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delivere")
public class DeliverServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("Delivere servlet");

        HttpSession session = request.getSession(false);
        UserTO userto=(UserTO) session.getAttribute("MyUserInfo");
        if (session == null || userto.getFullName() == null) {
        	System.out.println("failed as username in buynow servlet");
            response.sendRedirect("login.jsp");
            return;
        }

        String username = request.getParameter("username");
        String orderdate= request.getParameter("orderdate");

        try {

            OrderDAO orderDAO = new OrderDAO();
            int orderDelivere=orderDAO.delivere(username,orderdate);
            if (orderDelivere > 0) {

                session.setAttribute("delivered", "Your order is delevered successfully");
                // 5. Redirect to Orders Page
                response.sendRedirect("AllOrdersServlet");
            }

        } catch (Exception e) {
            e.printStackTrace();
}
    }
}
