<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%> 
<!DOCTYPE html> 
<html> 
<head>
<title>
Login
</title>
<link rel="stylesheet" type="text/css" href="logincss.css">
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
</head>
<body> 
<div class="login-container">
<h1>BookStore</h1> 
<h2>Login Form</h2> 
<font color="green" size="5"> ${RegMsg} </font> 
<font color="red" size="5"> ${LoginMsg} </font> 
<font color="blue" size="5"> ${LogoutMsg} </font>
<form action="mylogin.jlc" method="post"> 
<table> 
<tr> 
<td>Username</td> 
<td><input type="text" name="username" /></td> 
</tr> 
<tr> 
<td>Password</td> 
<td><input type="password" name="password" /></td> 
</tr> 
<tr> 
<td>
<input type="submit" value="Login Now" />
</td> 
</tr> 
</table> 
</form> 

<h2> 
<a href="register.jsp"> New User Signup </a> || 
<a href="forgotpw.jsp"> Forgot My Password </a> 
</h2>
</div> 
</body> 
</html>