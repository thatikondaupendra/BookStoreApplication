
package com.jlcindia.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.service.UserService;

@WebServlet("/searchbook")
public class SearchBooksServlet extends JLCBaseServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("Searchbook - servlet");
        // Get form data
        String bookName = request.getParameter("bookname");

        List<Book> x= userService.searchbook(bookName);
        HttpSession session = request.getSession();
        session.setAttribute("searchbooks", x);
       
        // (Later you can save book into DB using DAO)
    RequestDispatcher rd = request.getRequestDispatcher("showbooks.jsp"); 
        rd.forward(request, response); 
    }
}
