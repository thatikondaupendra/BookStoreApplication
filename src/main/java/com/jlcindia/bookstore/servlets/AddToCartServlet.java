package com.jlcindia.bookstore.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jlcindia.bookstore.dao.BookDAO;
import com.jlcindia.bookstore.service.UserService;
import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.Cart;
import com.jlcindia.bookstore.to.UserTO;

@WebServlet("/addtocart")
public class AddToCartServlet extends JLCBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
    	System.out.println("addtocart - servlet");
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("Role");
        System.out.println(role);
        // Get cart from session (create new if not exists)

          UserTO userTO=(UserTO) session.getAttribute("MyUserInfo");
          System.out.println(userTO.getFullName());
        // Get book details from request
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        
        session.setAttribute("bookname", bookName);
        
        BookDAO dao = new BookDAO();
        List<Cart> cart = dao.getcartBooks((String)userTO.getFullName());
        if (cart == null) {
            cart = new ArrayList<>();
        }
        session.setAttribute("cart", cart);
        
        // Check if book already exists in cart
        boolean found = false;
        for (int i=0;i<cart.size();i++) {
        	String bookname=cart.get(i).getAuthor();
        	System.out.println(bookname+"BookName");
        	System.out.println(cart.get(i).getBookName()+"bookname");
        	System.out.println(cart.get(i).getBookName().equals(bookName)+"isittrue");
            if (cart.get(i).getBookName().equals(bookName)) {
            	cart.get(i).setQuantity(cart.get(i).getQuantity() + 1);
                int x = userService.cartEffect(cart.get(i).getAuthor(),cart.get(i).getBookName());   
                int y = dao.updatecart((String)userTO.getFullName(),bookName,cart.get(i).getCartid());
                found = true;
                break;
            }
        }

        if (!found) {
            dao.addtocart((String)userTO.getFullName(),bookName, author, price, 1);
        }

        // Save cart back to session
        session.setAttribute("cart", cart);
        session.setAttribute("books", dao.getAllBooks());
        session.setAttribute("addedtocart", "Book is added to the cart successfully");

        // Redirect to cart.jsp
        response.sendRedirect("showbooks");
    }
}
