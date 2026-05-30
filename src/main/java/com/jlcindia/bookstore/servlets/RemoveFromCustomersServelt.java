
package com.jlcindia.bookstore.servlets;

import com.jlcindia.bookstore.dao.BookDAO;
import com.jlcindia.bookstore.to.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/removefromcustomers")
public class RemoveFromCustomersServelt extends JLCBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("Removefrombooks = servlet");
        
        HttpSession session = request.getSession(false);

                String fullname = request.getParameter("fullname");
                String phone = request.getParameter("phone");
                String gender = request.getParameter("gender");

                BookDAO dao=new BookDAO();
               int res =dao.removefromcustomers(fullname,phone,gender);

                session.setAttribute("deleted", "book deleted successfully");
                System.out.println("removebooksservletlast");
                response.sendRedirect("showcustomers");
    }
}
