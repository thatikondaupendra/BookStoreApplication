<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f9;
            padding: 20px;
        }
        form {
            background: white;
            padding: 20px;
            max-width: 400px;
            margin: auto;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        button {
            width: 100%;
            padding: 12px;
            background: #0077cc;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
                .btn {
            border-radius: 6px;
            padding: 8px 15px;
            margin-top: 10px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            text-align: center;
            width:25%;
            transition: background 0.3s ease;
        }
        button:hover {
            background: #005fa3;
        }
        header{
            background: #2d3436;
            padding: 20px;
            text-align: center;
            color: #fff;
            letter-spacing: 2px;
            font-size: 28px;
            font-weight: bold;
        }
                .home-btn {
            background: #6c63ff;
            color: white;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="homecss.css">
</head>
<body>
<header>📚 JLC Bookstore – Spice Up Your Reading!</header>

    <h2 style="text-align:center;">Add a New Book</h2>
    <form action="addbook" method="post">
        <input type="text" name="bookName" placeholder="Book Name" required>
        <input type="text" name="author" placeholder="Author" required>
        <input type="number" name="price" placeholder="Price" required>
        <input type="number" name="quantity" placeholder="Quantity" required>
        <button type="submit">Add Book</button>

    </form>
            <section class="cart-section">
<a class="btn home-btn" href="home.jsp">🏠 Back to Home</a>
</section>
</body>
</html>
