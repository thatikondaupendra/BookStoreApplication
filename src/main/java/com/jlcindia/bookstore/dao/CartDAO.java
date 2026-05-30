package com.jlcindia.bookstore.dao;

import java.sql.*;
import java.util.*;
import com.jlcindia.bookstore.to.Cart;

public class CartDAO {

    public List<Cart> getCartItems(String username,String bookname, String author) {
        List<Cart> items = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Upendra@545");
             PreparedStatement ps = con.prepareStatement("SELECT * FROM cart WHERE username=? and bookname=? and author=?")) {
            ps.setString(1, username);
            ps.setString(2, bookname);
            ps.setString(3, author);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cart item = new Cart();
                item.setCartid(rs.getInt("cartId"));
                item.setUserName(rs.getString("username"));
                item.setBookName(rs.getString("bookName"));
                item.setAuthor(rs.getString("author"));
                item.setPrice(rs.getDouble("price"));
                item.setQuantity(rs.getInt("quantity"));
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public void clearCart(String username, String bookname, String author) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Upendra@545");
             PreparedStatement ps = con.prepareStatement("DELETE FROM cart WHERE username=? and bookname=? and author=?")) {
            ps.setString(1, username);
            ps.setString(2, bookname);
            ps.setString(3, author);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
