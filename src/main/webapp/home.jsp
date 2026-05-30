<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JLC Bookstore</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #f6f8fa, #dfe6e9);
            margin: 0;
            padding: 0;
            color: #2d3436;
        }

        header {
            position: sticky;
    top: 0; /* sticks to the top of the page */
   
            background: linear-gradient(90deg, #2d3436, #000000);
            padding: 25px;
            text-align: center;
            color: white;
            font-size: 30px;
            font-weight: 700;
            letter-spacing: 1.5px;
                z-index: 1000; /* keeps it above other elements */
             text-transform: uppercase;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.3);
        }
        
          header {
background-color: #fff; /* add a background so content doesn't overlap */
    padding: 10px;
    font-size: 1.5rem;
    font-weight: bold;
    text-align: center;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1); /* subtle shadow */
    z-index: 1000; /* keeps it above other elements */
  }

        .container {
            max-width: 1000px;
            margin: 40px auto;
            padding: 10px;
        }

        h1 {
            font-size: 28px;
            text-align: center;
            color: #2d3436;
            margin-bottom: 30px;
        }

        .section-card {
            background: white;
            border-radius: 18px;
            padding: 25px;
            margin-bottom: 25px;
            box-shadow: 0px 6px 18px rgba(0, 0, 0, 0.1);
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .section-card:hover {
            transform: translateY(-5px);
            box-shadow: 0px 10px 25px rgba(0, 0, 0, 0.15);
        }

        .section-card h2 {
            font-size: 22px;
            margin-bottom: 10px;
            color: #1e272e;
        }

        .section-card p {
            font-size: 15px;
            color: #636e72;
            margin-bottom: 15px;
        }

        .btn {
            display: inline-block;
            background: linear-gradient(135deg, #ff6b6b, #ff4757);
            color: white;
            padding: 12px 22px;
            border-radius: 30px;
            font-size: 16px;
            font-weight: 600;
            text-decoration: none;
            box-shadow: 0px 5px 15px rgba(255, 71, 87, 0.4);
            transition: all 0.3s ease-in-out;
        }

        .btn:hover {
            background: linear-gradient(135deg, #1dd1a1, #10ac84);
            transform: translateY(-3px) scale(1.05);
            box-shadow: 0px 8px 20px rgba(16, 172, 132, 0.5);
        }

        footer {
            margin-top: 40px;
            background: #2d3436;
            color: white;
            text-align: center;
            padding: 12px;
            font-size: 14px;
            letter-spacing: 1px;
        }
    </style>
</head>
<body>
<header>📚 JLC Bookstore – Spice Up Your Reading!</header>

<div class="container">
    <h1>👋 Welcome, ${MyUserInfo.fullName}</h1>

    <!-- Section 1: Profile Management -->
    <div class="section-card">
        <h2>👤 Manage Your Profile</h2>
        <p>Keep your profile details up to date so we can personalize your experience.  
        You can also change your password anytime for security.</p>
        <a href="editProfile.jlc" class="btn">✏️ Update Profile</a>
        <a href="changepw.jsp" class="btn">🔑 Change Password</a>
        <a href="mylogout.jlc" class="btn">🚪 Logout</a>
    </div>

    <% String role = (String) session.getAttribute("Role"); %>

    <!-- Section 2: Admin Features -->
    <% if ("admin".equals(role)) { %>
    <div class="section-card">
        <h2>🛠 Admin Tools</h2>
        <p>As an admin, you can manage the store by adding new books and monitoring customers.</p>
        <a href="addbooks.jsp" class="btn">➕ Add New Books</a>
        <a href="showcustomers" class="btn">👥 Show Customers</a>
        <a href = "AllOrdersServlet" class = "btn"> All orders</a>
            <a href="showbooks" class="btn">📖 Our Store</a>
   </div>
    <% } %>

    <!-- Section 3: Explore Books -->
    <% if ("user".equals(role)) { %>
    <div class="section-card">
        <h2>📚 Explore Our Collection</h2>
        <p>Browse through a wide variety of books carefully curated to expand your knowledge and imagination.</p>
        <a href="showbooks" class="btn">📖 Browse Books</a>
    </div>

    <!-- Section 4: My Cart -->
    <div class="section-card">
        <h2>🛒 Your Cart</h2>
        <p>Review the books you’ve selected, update quantities, or remove items before checking out.</p>
        <a href="mycart" class="btn">Go to Cart</a>
        <a href = "OrdersServlet" class = "btn"> All orders</a>
  
    </div>
    <% } %>
</div>

<footer>© 2025 JLC Bookstore | All Rights Reserved</footer>
</body>
</html>
