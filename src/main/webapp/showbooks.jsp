<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jlcindia.bookstore.to.Book" %>

<html>
<head>
    <title>All Books</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f9;
            padding: 20px;
        }

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
            letter-spacing: 2px;
        }

        main {
            width: 85%;
            margin: 20px auto;
        }

        /* Book Grid */
        .book-list {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-top: 20px;
        }

        .book-card {
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            transition: transform 0.2s ease;
        }

        .book-card:hover {
            transform: translateY(-4px);
            box-shadow: 0 4px 14px rgba(0, 0, 0, 0.15);
        }

        .book-cover {
            width: 100px;
            height: 140px;
            object-fit: cover;
            border-radius: 8px;
            margin-bottom: 10px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
        }

        .book-card h3 {
            margin: 5px 0 10px;
            font-size: 1.2rem;
            color: #333;
        }

        .book-info p {
            margin: 4px 0;
            color: #555;
            font-size: 0.95rem;
        }

        .price {
            font-weight: bold;
            color: #1a73e8;
            margin: 5px 0;
            font-size: 1rem;
        }

        .btn {
            display: inline-block;
            background: #1a73e8;
            color: white;
            border: none;
            border-radius: 6px;
            padding: 8px 15px;
            margin-top: 10px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            text-align: center;
            transition: background 0.3s ease;
        }

        .btn:hover {
            background: #155acb;
        }

        .add-btn {
            background: #28a745;
        }

        .add-btn:hover {
            background: #218838;
        }

        .admin-btn {
            background: #fbbc05;
            color: black;
        }

        .cart-btn {
            background: #ff6f61;
        }

        .home-btn {
            background: #6c63ff;
        }

        .admin-section,
        .cart-section {
            text-align: center;
            margin-top: 20px;
        }

        .no-books {
            text-align: center;
            color: gray;
            font-size: 18px;
            margin-top: 20px;
        }
        
        input[type="text"],
input[type="password"] {
  width: 25%;
  padding: 12px 15px;
  margin: 12px 0;
  border: 1px solid #ddd;
  border-radius: 8px;
  outline: none;
  transition: all 0.3s ease;
}

input[type="text"]:focus,
input[type="password"]:focus {
  border-color: #667eea;
  box-shadow: 0px 0px 6px rgba(102, 126, 234, 0.6);
}
    </style>
</head>
<body>
<header>📚 JLC Bookstore – Spice Up Your Reading!</header>
<link rel="stylesheet" type="text/css" href="homecss.css">


<main>
   <%
   String addedtocart=(String)session.getAttribute("addedtocart");
   String bookname=(String)session.getAttribute("bookname");
System.out.println("ADD"+addedtocart);
   if((addedtocart!=null)){%>
            	    <h2><%=bookname%> <%=addedtocart %></h2>
            	    <%
            	    session.removeAttribute("addedtocart");
            	    } %>
   <%
   String deleted=(String)session.getAttribute("deleted");
   if((deleted!=null)){%>
            	    <h2><%=deleted%> </h2>
            	    <%
            	    session.removeAttribute("deleted");
            	    } %>
        <form action="searchbook" method="post">
            <input type="text" name="bookname" placeholder="Search for book here">
 <button class="btn add-btn" type="submit">Find Book</button>
        </form>
<%
if(session.getAttribute("searchbooks")!=null){
    List<Book> searchbooks = (List<Book>) session.getAttribute("searchbooks");
    if (searchbooks != null && !searchbooks.isEmpty()) {
%>
<h3>Search Results</h3>
<section class="book-list">

<%
    for (Book b : searchbooks) {
        // Since you don't have images in DB, we use a single placeholder image for all
        String imageUrl = "https://picsum.photos/200/300?random=" + b.getBookid(); 
%>
    <div class="book-card">
        <!-- Book Cover -->
        <img src="<%= imageUrl %>" alt="Book Cover" class="book-cover">

        <h3><%= b.getBookName() %></h3>
        <div class="book-info">
            <p><strong>Book ID:</strong> <%= b.getBookid() %></p>
            <p><strong>Author:</strong> <%= b.getAuthor() %></p>
            <p class="price">₹<%= b.getPrice() %></p>
            <p><strong>Available:</strong> <%= b.getQuantity() %></p>
        </div>
<%String role1 = (String) session.getAttribute("Role");
if ("user".equals(role1)) { %>
        <!-- Add to Cart Form -->
        <form action="addtocart" method="post">
            <input type="hidden" name="bookId" value="<%= b.getBookid() %>">
            <input type="hidden" name="bookName" value="<%= b.getBookName() %>">
            <input type="hidden" name="author" value="<%= b.getAuthor() %>">
            <input type="hidden" name="price" value="<%= b.getPrice() %>">
            <input type="hidden" name="quantity" value="<%= b.getQuantity() %>">
            <button class="btn add-btn" type="submit">➕ Add to Cart</button>
        </form>
        <%} %>
    </div>
    <%
        }
    %>
</section>
<%
    } else {
        out.print("<p class='no-books'>No books available.</p>");
    }
    %>
    <br></br>
    <hr></hr>
    <h3>All Books</h3>
    <%
}
session.removeAttribute("searchbooks");
%>


</main>




<main>
<%
if(session.getAttribute("books")!=null){
    List<Book> books = (List<Book>) session.getAttribute("books");
    if (books != null && !books.isEmpty()) {
%>

<section class="book-list">
<%
    for (Book b : books) {
        // Since you don't have images in DB, we use a single placeholder image for all
        String imageUrl = "https://picsum.photos/200/300?random=" + b.getBookid(); 
%>
    <div class="book-card">
        <!-- Book Cover -->
        <img src="<%= imageUrl %>" alt="Book Cover" class="book-cover">

        <h3><%= b.getBookName() %></h3>
        <div class="book-info">
            <p><strong>Book ID:</strong> <%= b.getBookid() %></p>
            <p><strong>Author:</strong> <%= b.getAuthor() %></p>
            <p class="price">₹<%= b.getPrice() %></p>
            <p><strong>Available:</strong> <%= b.getQuantity() %></p>
        </div>
<%String role = (String) session.getAttribute("Role");
if ("user".equals(role)) { %>
        <!-- Add to Cart Form -->
        <form action="addtocart" method="post">
            <input type="hidden" name="bookId" value="<%= b.getBookid() %>">
            <input type="hidden" name="bookName" value="<%= b.getBookName() %>">
            <input type="hidden" name="author" value="<%= b.getAuthor() %>">
            <input type="hidden" name="price" value="<%= b.getPrice() %>">
            <input type="hidden" name="quantity" value="<%= b.getQuantity() %>">
            <button class="btn add-btn" type="submit">➕ Add to Cart</button>
        </form>
        <%}
        else{%>
                            <form action="removefrombooks" method="post">
                        <input type="hidden" name="book" value="<%= b.getBookName() %>">
                        <input type = "hidden" name = "author" value="<%= b.getAuthor() %>">
                        <button type="submit" class="btn btn-remove">Remove</button>
                    </form><%} %>
    </div>
    <%
        }
    %>
</section>
<%
    } else {
        out.print("<p class='no-books'>No books available.</p>");
    }
}
String role = (String) session.getAttribute("Role");
if ("admin".equals(role)) {
%>
<section class="admin-section">
    <button class="btn admin-btn">
        <a href="addbooks.jsp" style="color:inherit;text-decoration:none;">➕ Add New Books</a>
    </button>
</section>
<%
}else{
%>

<section class="cart-section">
    <a class="btn cart-btn" href="mycart">🛒 My Cart</a>
    <%} %>
    <a class="btn home-btn" href="home.jsp">🏠 Back to Home</a>
</section>

</main>
</body>
</html>
