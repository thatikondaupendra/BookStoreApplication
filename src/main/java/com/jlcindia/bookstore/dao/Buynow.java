package com.jlcindia.bookstore.dao;

import java.sql.*;
import com.jlcindia.bookstore.to.*;
import com.jlcindia.bookstore.dao.OrderDAO;

public class Buynow {

    // Existing getOrdersByUser() here ...
// ✅ Method to create a new order and insert into DB
    public int createOrder(Order order) {
        Connection con = null;
        PreparedStatement psOrder = null;
        PreparedStatement psItem = null;
        ResultSet rsKeys = null;
        int orderId = -1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Upendra@545");
            con.setAutoCommit(false); // Transaction start

            // 1. Insert into orders
            String sqlOrder = "INSERT INTO orders(username, orderDate, status, total) VALUES(?, NOW(), ?, ?)";
            psOrder = con.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
            psOrder.setString(1, order.getUsername());
            psOrder.setString(2, order.getStatus());
            psOrder.setDouble(3, order.getTotalAmount());
            psOrder.executeUpdate();

            // 2. Get generated orderId
            rsKeys = psOrder.getGeneratedKeys();
            if (rsKeys.next()) {
                orderId = rsKeys.getInt(1);
            }

            // 3. Insert order items
            String sqlItem = "INSERT INTO order_items(orderId, bookName, author, price, quantity, total) VALUES(?,?,?,?,?,?)";
            psItem = con.prepareStatement(sqlItem);

            for (OrderItem item : order.getItems()) {
                psItem.setInt(1, orderId);
                psItem.setString(2, item.getBookName());
                psItem.setString(3, item.getAuthor());
                psItem.setDouble(4, item.getPrice());
                psItem.setInt(5, item.getQuantity());
                psItem.setDouble(6, item.getTotal());
                psItem.addBatch();
            }
            psItem.executeBatch();

            con.commit(); // Transaction success
            System.out.println("✅ Order created successfully with ID: " + orderId);

        } catch (Exception e) {
            try {
                if (con != null) con.rollback(); // rollback if error
            } catch (Exception ex) { ex.printStackTrace(); }
            e.printStackTrace();
        } finally {
            try { if (rsKeys != null) rsKeys.close(); } catch (Exception e) {}
            try { if (psItem != null) psItem.close(); } catch (Exception e) {}
            try { if (psOrder != null) psOrder.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
        return orderId;
    }
}
