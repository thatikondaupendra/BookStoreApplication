<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
 <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Poppins", sans-serif;
        }

        body {
            background: linear-gradient(135deg, #667eea, #764ba2);
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            color: #fff;
        }

        header {
            background: #2d3436;
            padding: 20px;
            text-align: center;
            color: #fff;
            letter-spacing: 2px;
            font-size: 28px;
            font-weight: bold;
            width: 100%;
            box-shadow: 0px 4px 15px rgba(0,0,0,0.3);
        }

        h1 {
            font-size: 50px;
            margin: 30px 0;
            color: #fff;
            text-shadow: 2px 2px 8px rgba(0,0,0,0.3);
            animation: fadeIn 1s ease-in-out;
        }

        .section {
            display: flex;
            flex-direction: column;
            gap: 20px;
            background: rgba(255, 255, 255, 0.1);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0px 8px 25px rgba(0, 0, 0, 0.3);
            backdrop-filter: blur(6px);
            animation: slideUp 1s ease-in-out;
        }

        button {
            padding: 15px 30px;
            border: none;
            border-radius: 50px;
            background: linear-gradient(135deg, #ff7675, #d63031);
            color: white;
            font-size: 18px;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s ease;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.2);
        }

        button:hover {
            background: linear-gradient(135deg, #00b894, #0984e3);
            transform: scale(1.05);
        }

        button a {
            text-decoration: none;
            color: white;
            display: block;
            width: 100%;
            height: 100%;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        @keyframes slideUp {
            from { opacity: 0; transform: translateY(30px); }
            to { opacity: 1; transform: translateY(0); }
        }

        /* Message styling */
        font[color="blue"] {
            display: block;
            margin-bottom: 20px;
            font-weight: bold;
            text-align: center;
            text-shadow: 1px 1px 6px rgba(0,0,0,0.3);
        }
    </style>

<link rel="stylesheet" type="text/css" href="logincss.css">
<body> 
<header>📚 JLC Bookstore – Spice Up Your Reading!</header>
<link rel="stylesheet" type="text/css" href="homecss.css">
<h1>BookStore</h1> 
<font color="blue" size="9">${UpdateMsg} </font> 
<div class="section">
    <button><a href="showbooks">Go To Book Store</a></button>
    <button><a href="home.jsp">Go To Home</a></button>
</div>
</body> 
</html>