package com.jlcindia.bookstore.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.jlcindia.bookstore.dao.BookDAO;
import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.Cart;
import com.jlcindia.bookstore.to.UserTO;

@WebServlet("/mycart")
public class MyCartServlet extends JLCBaseServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
        UserTO userTO=(UserTO) session.getAttribute("MyUserInfo");
        
        BookDAO dao = new BookDAO();
        List<Cart> books = dao.getcartBooks((String)userTO.getFullName());
        System.out.println(books+"from mycart servlet");

        // Pass book list to JSP
        session.setAttribute("cart", books);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}
