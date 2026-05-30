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

@WebServlet("/showbooks")
public class ShowBooksServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BookDAO dao = new BookDAO();
        List<Book> books = dao.getAllBooks();

        // Pass book list to JSP
        HttpSession session = request.getSession();
        session.setAttribute("books", books);
        request.getRequestDispatcher("showbooks.jsp").forward(request, response);
    }
}
