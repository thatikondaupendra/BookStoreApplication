
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
import com.jlcindia.bookstore.to.UserTO;

@WebServlet("/showcustomers")
public class ShowCustomersServlet extends JLCBaseServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BookDAO dao = new BookDAO();
        List<UserTO> customers = dao.getAllCustomers();

        // Pass book list to JSP
        HttpSession session = request.getSession();
        session.setAttribute("customers", customers);
        System.out.println("customers"+customers);
        request.getRequestDispatcher("showcustomers.jsp").forward(request, response);
    }
}
