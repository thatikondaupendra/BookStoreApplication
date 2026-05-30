<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%> 
<!DOCTYPE html> 
<html> 
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
input[type="submit"] {
    background-color: #0077cc;   /* blue background */
    color: white;                /* white text */
    padding: 10px 20px;          /* spacing */
    border: none;                /* no border */
    border-radius: 5px;          /* rounded corners */
    font-size: 16px;             /* text size */
    font-weight: bold;           /* bold text */
    cursor: pointer;             /* hand cursor */
    transition: background 0.3s ease, transform 0.2s ease; /* smooth hover */
}

input[type="submit"]:hover {
    background-color: #005fa3;   /* darker blue on hover */
    transform: scale(1.05);      /* slight zoom effect */
}

input[type="submit"]:active {
    background-color: #004680;   /* pressed effect */
    transform: scale(0.98);      /* slight shrink */
}
</style>
<link rel="stylesheet" type="text/css" href="logincss.css">
<body> 
<header>📚 JLC Bookstore – Spice Up Your Reading!</header>
<link rel="stylesheet" type="text/css" href="homecss.css">
<div align="center"> 
<h1>BookStore</h1> 
<h2>Registration Form for admin</h2> 
<font color="red" size="5"> ${RegMsg} </font> 

<div class="login-container">
<form action="regasadmin.jlc" method="post"> 
<table> 
<tr> 
<td>Full Name</td> 
<td><input type="text" name="fullName" required/></td> 
</tr> 
<tr> 
<td>Email</td>
<td><input type="text" name="email" required/></td> 
</tr> 
<tr> 
<td>Phone</td> 
<td><input type="text" name="phone" required/></td> 
</tr> 
<tr> 
<td>Username</td> 
<td><input type="text" name="username" required/></td> 
</tr> 
<tr> 
<td>Password</td> 
<td><input type="password" name="password" required/></td> 
</tr> 
<tr> 
<td colspan="2" align="center">
<input type="submit" 
value="Register Now" />
</td> 
</tr> 
</table> 
</form> 
</div>
</div> 
</body> 
</html>