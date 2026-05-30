
package com.jlcindia.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.service.UserService;

@WebServlet("/addbook")
public class AddbooksServlet extends JLCBaseServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("Addbook - servlet");
        // Get form data
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Create Book object
        Book book = new Book(bookName, author, price, quantity);
        int x=userService.addbook(book);
        if (x==1) {
        	System.out.println("Book Added successfully");
        }
        // (Later you can save book into DB using DAO)
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Book Added Successfully!</h2>");
        out.println("<p>" + book + "</p>");
        response.sendRedirect("showbooks");
        //RequestDispatcher rd = request.getRequestDispatcher("showbooks"); 
        //rd.forward(request, response); 
    }
}
