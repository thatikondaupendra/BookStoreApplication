<%@ page import="java.util.*,com.jlcindia.bookstore.to.Cart" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Your Cart</title>
    <style>
     /* Sticky Header */
header {
  position: sticky;
  top: 0;
  background: #1a73e8;
  color: white;
  text-align: center;
  font-size: 1.8rem;
  font-weight: bold;
  padding: 15px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
  z-index: 1000;
  margin-bottom: 20px;
}

/* Page Title */
h2 {
  text-align: center;
  color: #333;
  font-size: 1.5rem;
  margin-top: 10px;
  margin-bottom: 20px;
}

/* Cart Table */
table {
  width: 80%;
  margin: 0 auto;
  border-collapse: collapse;
  background: #fff;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  overflow: hidden;
}

th, td {
  text-align: center;
  padding: 12px;
  border-bottom: 1px solid #ddd;
}

th {
  background: #f4f4f4;
  font-weight: bold;
}

tr:hover {
  background: #fafafa;
}

/* Empty Cart Message */
p {
  text-align: center;
  font-size: 1.2rem;
  color: gray;
  margin-top: 30px;
}

/* Buttons */
.btn {
  background: #1a73e8;
  color: white;
  border: none;
  border-radius: 6px;
  padding: 8px 15px;
  margin: 5px;
  cursor: pointer;
  font-size: 16px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
  transition: 0.3s;
}

.btn:hover {
  background: #155acb;
}

.btn a {
  color: white;
  text-decoration: none;
}
button:hover {
  background: #f4c430;
  transform: scale(1.05);
}
.btn {
  background: #1a73e8;
  color: white;
  border: none;
  border-radius: 6px;
  padding: 6px 12px;
  cursor: pointer;
  font-size: 14px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
  transition: background 0.3s;
}

.btn:hover {
  background: #155acb;
}

.btn-remove {
  background: #ff4d4d;
}

.btn-remove:hover {
  background: #e60000;
}

.btn-buy {
  background: #28a745;
}

.btn-buy:hover {
  background: #218838;
}
/* Bottom Section Buttons */
.section {
  text-align: center;
  margin-top: 20px;
}

.section button {
  background: #6c63ff;
  color: white;
  border: none;
  border-radius: 6px;
  padding: 10px 16px;
  margin: 5px;
  cursor: pointer;
  font-size: 16px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);
  transition: background 0.3s;
}

.section button:hover {
  background: #574bff;
}

.section button a {
  color: white;
  text-decoration: none;
}

    </style>
</head>
<body>
<link rel="stylesheet" type="text/css" href="homecss.css">
<header>📚 JLC Bookstore – Spice Up Your Reading!</header>

    <h2>Your Shopping Cart</h2>
    <%
    List<Cart> car= (List<Cart>)session.getAttribute("cart");
    System.out.println(car);
        List<Cart> cart = (session != null) ? (List<Cart>) session.getAttribute("cart") : null;

        if (cart == null || cart.isEmpty()) {
    %>
        <p style="text-align:center;">Your cart is empty.</p>
    <%
        } else {
    %>
        <table>
            <tr>
                <th>Book</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Remove</th>
                <th>Buy Now</th>
            </tr>
            <%
                double grandTotal = 0;
                for (Cart item : cart) {
                    grandTotal += item.getTotal();
            %>
            <tr>
                <td><%= item.getBookName() %></td>
                <td><%= item.getAuthor() %></td>
                <td><%= item.getPrice() %></td>
                <td><%= item.getQuantity() %></td>
                <td><%= item.getTotal() %></td>
                <td>
                    <form action="removefromcart" method="post">
                        <input type="hidden" name="book" value="<%= item.getBookName() %>">
                        <input type = "hidden" name = "username" value="<%= item.getUserName() %>">
                        <input type = "hidden" name = "author" value="<%= item.getAuthor() %>">
                        <button type="submit" class="btn btn-remove">Remove</button>
                    </form>
                </td>
                <td>
                    <form action="buyform" method="post">
                        <input type="hidden" name="book" value="<%= item.getBookName() %>">
                        <input type = "hidden" name = "username" value="<%= item.getUserName() %>">
                        <input type = "hidden" name = "author" value="<%= item.getAuthor() %>">
                        <button type="submit" class="btn btn-buy">Buy Now</button>
                    </form>
                </td>
            </tr>
            <% } %>
            <tr>
                <td colspan="4"><b>Grand Total</b></td>
                <td><b><%= grandTotal %></b></td>
                <td colspan="2"></td>
            </tr>
        </table>
    <%
        }
    %>
<div class="section">
    <button><a href="showbooks">Go To Book Store</a></button>
    <button><a href="home.jsp">Go To Home</a></button>
</div>
</body>
</html>
