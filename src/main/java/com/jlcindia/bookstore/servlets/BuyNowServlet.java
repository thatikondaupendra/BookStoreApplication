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

@WebServlet("/buynow")
public class BuyNowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("buynow servlet");

        HttpSession session = request.getSession(false);
        UserTO userto=(UserTO) session.getAttribute("MyUserInfo");
        if (session == null || userto.getFullName() == null) {
        	System.out.println("failed as username in buynow servlet");
            response.sendRedirect("login.jsp");
            return;
        }

        String username = (String) userto.getFullName();
        String bookname= request.getParameter("bookname");
        String author = request.getParameter("author");
        

        try {
            // 1. Get cart items
            CartDAO cartDAO = new CartDAO();
            List<Cart> cartItems = cartDAO.getCartItems(username,bookname,author);

            if (cartItems == null || cartItems.isEmpty()) {
                response.sendRedirect("cart.jsp?msg=Cart is empty!");
                return;
            }
            
            // 2. Build Order object
            Order order = new Order();
            order.setUsername(username);
            order.setStatus("Placed");

            double totalAmount = 0.0;
            for (Cart c : cartItems) {
                OrderItem item = new OrderItem();
                item.setBookName(c.getBookName());
                item.setAuthor(c.getAuthor());
                item.setPrice(c.getPrice());
                item.setQuantity(c.getQuantity());
                item.setTotal(c.getPrice() * c.getQuantity());
                order.getItems().add(item);

                totalAmount += item.getTotal();
            }
            order.setTotalAmount(totalAmount);

            // 3. Save to DB
            OrderDAO orderDAO = new OrderDAO();
            int orderId = orderDAO.createOrder(order);

            if (orderId > 0) {
                // 4. Clear cart
                cartDAO.clearCart(username,bookname,author);
                
                session.setAttribute("success", "Your order is succefully completed Check your email for updates");
                // 5. Redirect to Orders Page
                response.sendRedirect("OrdersServlet");
            } else {
                response.sendRedirect("cart.jsp?msg=Order failed, try again!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("cart.jsp?msg=Error while placing order!");
        }
    }
}
