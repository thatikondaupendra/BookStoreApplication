package com.jlcindia.bookstore.dao;

import java.sql.*;
import java.util.*;
import com.jlcindia.bookstore.to.*;

public class OrderDAO {

    public List<Order> getOrdersByUser(String username) {
    	System.out.println("getorderbyuserdao");
        List<Order> orders = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Upendra@545");
		System.out.println("connected");
            // 1. Fetch orders for this user
            ps = con.prepareStatement("SELECT * FROM orders WHERE username=? ORDER BY orderDate DESC");
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            	System.out.println("yes");
                Order order = new Order();
                order.setOrderId(rs.getInt(1));
                order.setUsername(rs.getString(2));
                order.setOrderDate(rs.getString(3));
                order.setStatus(rs.getString(4));
                order.setTotalAmount(rs.getDouble(5));
                System.out.println(order.getOrderId());

                // 2. Fetch order items
                PreparedStatement ps2 = con.prepareStatement("SELECT * FROM order_items WHERE orderId=?");
                ps2.setInt(1, order.getOrderId());
                ResultSet rs2 = ps2.executeQuery();

                List<OrderItem> items = new ArrayList<>();
                while (rs2.next()) {
                    OrderItem item = new OrderItem();
                    item.setItemId(rs2.getInt(1));
                    item.setOrderId(rs2.getInt(2));
                    item.setBookName(rs2.getString(3));
                    item.setAuthor(rs2.getString(4));
                    item.setPrice(rs2.getDouble(5));
                    item.setQuantity(rs2.getInt(6));
                    item.setTotal(rs2.getDouble(7));
                    items.add(item);
                }
                System.out.println(items.get(0).getAuthor()+"items");
                order.setItems(items);

                orders.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
        return orders;
    }
    
    
    public List<Order> getAllOrders(String username) {
    	System.out.println("getorderbyuserdao");
        List<Order> orders = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Upendra@545");
		System.out.println("connected");
            // 1. Fetch orders for this user
            ps = con.prepareStatement("SELECT * FROM orders ORDER BY orderDate DESC");
            rs = ps.executeQuery();
            
            while (rs.next()) {
            	System.out.println("yes");
                Order order = new Order();
                order.setOrderId(rs.getInt(1));
                order.setUsername(rs.getString(2));
                order.setOrderDate(rs.getString(3));
                order.setStatus(rs.getString(4));
                order.setTotalAmount(rs.getDouble(5));
                System.out.println(order.getOrderId());

                // 2. Fetch order items
                PreparedStatement ps2 = con.prepareStatement("SELECT * FROM order_items WHERE orderId=?");
                ps2.setInt(1, order.getOrderId());
                ResultSet rs2 = ps2.executeQuery();

                List<OrderItem> items = new ArrayList<>();
                while (rs2.next()) {
                    OrderItem item = new OrderItem();
                    item.setItemId(rs2.getInt(1));
                    item.setOrderId(rs2.getInt(2));
                    item.setBookName(rs2.getString(3));
                    item.setAuthor(rs2.getString(4));
                    item.setPrice(rs2.getDouble(5));
                    item.setQuantity(rs2.getInt(6));
                    item.setTotal(rs2.getDouble(7));
                    items.add(item);
                }
                System.out.println(items.get(0).getAuthor()+"items");
                order.setItems(items);

                orders.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
        return orders;
    }
    
    
    
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


	public int delivere(String username, String orderdate) {
		Connection con = null;
        PreparedStatement psOrder = null;
        PreparedStatement psItem = null;
        ResultSet rsKeys = null;
        int x=-1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Upendra@545");
            con.setAutoCommit(false); // Transaction start

            // 1. Insert into orders
            String sqlOrder = "update orders set status = ? where username = ? and orderDate = ?";
            psOrder = con.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
            psOrder.setString(1, "delevered");
            psOrder.setString(2, username);
            psOrder.setString(3, orderdate);
            x=psOrder.executeUpdate();

            con.commit(); // Transaction success
            System.out.println("✅ Order delevered successfully ");

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
        return x;
	}
}
