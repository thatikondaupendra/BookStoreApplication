<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
<body> 
<style>

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
<header>📚 JLC Bookstore – Spice Up Your Reading!</header>
<link rel="stylesheet" type="text/css" href="homecss.css">
<h1>BookStore</h1> 
<h2>Password Assistance Form</h2> 
<font color="red" size="5"> ${MyMsg} </font> 

<div class="login-container">
<form action="mypassword.jlc" method="post"> 
<table> 
<tr> 
<td>Enter Email</td> 
</tr> 
<tr> 
<td><input type="text" name="email" required/></td> 
</tr> 
<tr> 
<td>
<input type="submit" value="Submit" />
</td> 
</tr> 
</table> 
</form> 
</div>
</body> 
</html>