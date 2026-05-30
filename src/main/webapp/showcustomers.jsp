<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jlcindia.bookstore.to.UserTO" %>

<html>
<head>
    <title>All Books</title>
    <style>
    header{
            background: #2d3436;
            padding: 20px;
            text-align: center;
            color: #fff;
            letter-spacing: 2px;
            font-size: 28px;
            font-weight: bold;
        }
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f9;
            padding: 20px;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto;
            background: white;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }
        th {
            background: #0077cc;
            color: white;
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
<body>
<header>📚 JLC Bookstore – Spice Up Your Reading!</header>
<link rel="stylesheet" type="text/css" href="homecss.css">
    <h2 style="text-align:center;">Available Users</h2>
    <%
        List<UserTO> users = (List<UserTO>) session.getAttribute("customers");
        if (users != null && !users.isEmpty()) {
    %>
    <table>
        <tr>
        <th>User Id</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Date of Birth</th>
            <th>City</th>
            <th>Gender</th>
            <th>UserName</th>
            <th>Remove User</th>
        </tr>
        <%
            for (UserTO b : users) {
        %>
        <tr>
                <td><%= b.getUserId()%></td>
            <td><%= b.getFullName() %></td>
            <td><%= b.getEmail() %></td>
            <td><%= b.getPhone()%></td>
            <td><%= b.getDob() %></td>
            <td><%= b.getCity() %></td>
            <td><%= b.getGender() %></td>
            <td><%= b.getUsername() %></td>
            <td>
                                        <form action="removefromcustomers" method="post">
                        <input type="hidden" name="phone" value="<%= b.getPhone() %>">
                        <input type = "hidden" name = "fullname" value="<%= b.getFullName() %>">
                        <input type="hidden" name="gender" value="<%= b.getGender() %>">
                        <button type="submit" class="btn btn-remove">Remove</button>
                    </form>
                    </td>

        </tr>
        <%
            }
        %>
    </table>
    <%
        } else {
            out.print("<p style='text-align:center;'>No books available.</p>");
        }
    %>
    
    <%
String role = (String) session.getAttribute("Role");
System.out.println(role);
if ("admin".equals(role)) {
	System.out.println("--------------------------");
    System.out.println("admin");
%>
<button style="color: blue; font-size: 18px; ">
<a href = "addbooks.jsp"style="text-decoration: None;">Add New Books</a></button>
   <button style="color: blue; font-size: 18px; text-decoration: None;">
    <a class="btn home-btn" href="home.jsp"style="text-decoration: None;">🏠 Back to Home</a></button>

<%
}
else{
	System.out.println("Not Admin"+role);
%>
<div class="section">
	<button style="color: blue; font-size: 18px; text-decoration: None;">
	<a href = "mycart"> Cart </a></button>
<%}
%>

</div>
</body>
</html>
