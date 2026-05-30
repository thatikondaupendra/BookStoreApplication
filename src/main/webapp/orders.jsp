<%@ page import="java.util.*,com.jlcindia.bookstore.to.Order,com.jlcindia.bookstore.to.OrderItem" %>
<%
    // Get orders list from request attribute (set by OrdersServlet)
    List<Order> orders = (List<Order>) session.getAttribute("orders");
    String username = (String) session.getAttribute("username");
    System.out.println(username);

    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    
%>
<html>
<head>
    <title>My Orders</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f9f9f9;
        }
        
        h2 {
            color: #333;
            margin-bottom: 15px;
        }
        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background: #fff;
            box-shadow: 0px 2px 6px rgba(0,0,0,0.1);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        th {
            background: #007bff;
            color: #fff;
        }
        tr:nth-child(even) {
            background: #f2f2f2;
        }
        .btn {
            padding: 6px 10px;
            background: #28a745;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
        }
        .btn:hover {
            background: #218838;
        }
        button {
  padding: 12px 25px;
  border: none;
  border-radius: 8px;
  font-size: 16px;
  font-weight: bold;
  cursor: pointer;
  background: #ffd700;
  color: #333;
  transition: transform 0.3s ease, background 0.3s ease;
}

button:hover {
  background: #f4c430;
  transform: scale(1.05);
}
    </style>
</head>
<link rel="stylesheet" type="text/css" href="homecss.css">
<body>
<header>📚 JLC Bookstore – Spice Up Your Reading!</header>

    <% 
    String role = (String)session.getAttribute("Role");
    if ("admin".equals(role)) { %>

        <h2>🛠 Admin Tools</h2>
    <% } 
    else{%>
    <h2 align="center">Orders for <%= username %></h2>
   <%
   String suc=(String)session.getAttribute("success");

   if((suc!=null)){%>
            	    <h2><%=suc %></h2>
            	    <%
            	    session.removeAttribute("success");
            	    } %>


    <%
    }
        if (orders == null || orders.isEmpty()) {
    %>
        <p align="center">You have not placed any orders yet.</p>
    <%
        } else {
        	System.out.println();
        	%>
        	
<%
        
            for (Order order : orders) {
            	
    %>

        <table>
            <tr>
                <th colspan="6">Order #<%= order.getOrderId() %> | Date: <%= order.getOrderDate() %> | Status: <%= order.getStatus() %></th>
            </tr>
            <tr>
                <th>Book Name</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                                <%if("admin".equals(role)){
                	%>
                <th>Move to Delivere</th>
                <%} %>
            </tr>
            <%
                for (OrderItem item : order.getItems()) {
            %>
            <tr>
                <td><%= item.getBookName() %></td>
                <td><%= item.getAuthor() %></td>
                <td><%= item.getPrice() %></td>
                <td><%= item.getQuantity() %></td>
                <td><%= item.getTotal() %></td>
                <%if("admin".equals(role)){
                	%>
                	<td>
                	<h6>status:</h6>
                	<%String status=order.getStatus(); %>
                	<h5><%out.print(status); %></h5>
                    <form action="delivere" method="post">
                        <input type = "hidden" name = "username" value="<%= order.getUsername() %>">
                        <input type = "hidden" name = "orderdate" value="<%= order.getOrderDate()%>">
                        <%if(!status.equals("delevered")){ %>
                        <button type="submit" class="btn btn-buy" >Delivere</button>
                   <%}%>
                    </form>
                       	</td>
                	<%} %>
                
            </tr>
            <%
                }
            %>
            <tr>
                <td colspan="4" align="right"><b>Order Total:</b></td>
                <td colspan="2"><b><%= order.getTotalAmount() %></b></td>
            </tr>
        </table>
    <%
            }
        }
    %>
    <%if ("user".equals(role)){%>
        <div class="section">
<button style="color: blue; font-size: 18px; text-decoration: None;">
<a href = "showbooks">Want to buy (store)</a></button>

<button style="color: blue; font-size: 18px; text-decoration: None;">
<a href = "home.jsp">Lets move to Home</a></button>

<button style="color: blue; font-size: 18px; text-decoration: None;">
<a href = "mycart">Show cart</a></button>
</div>
<%}
    
    else{%>
    
    <button style="color: blue; font-size: 18px; text-decoration: None;">
<a href = "showbooks">Our Store</a></button>

<button style="color: blue; font-size: 18px; text-decoration: None;">
<a href = "home.jsp">Home</a></button>

</div>
<%} %>
</body>
</html>
