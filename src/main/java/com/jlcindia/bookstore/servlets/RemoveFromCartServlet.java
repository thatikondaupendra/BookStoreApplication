package com.jlcindia.bookstore.servlets;

import com.jlcindia.bookstore.dao.BookDAO;
import com.jlcindia.bookstore.to.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/removefromcart")
public class RemoveFromCartServlet extends JLCBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session != null) {
            List<Cart> cart = (List<Cart>) session.getAttribute("cart");
            if (cart != null) {
                String bookName = request.getParameter("book");
                String username = request.getParameter("username");
                String author = request.getParameter("author");

                BookDAO dao=new BookDAO();
                List<Cart> returnedcart =dao.removecartBooks(username, bookName,author);
                

                session.setAttribute("cart", returnedcart);
            }
        }
        response.sendRedirect("cart.jsp");
    }
}
