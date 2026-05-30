<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%> 
<!DOCTYPE html> 
<html> 
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
<body> 
<div align="center"> 
<h1>BookStore</h1> 
<h2>Registration Form</h2> 
<font color="red" size="5"> ${RegMsg} </font> 

<div class="login-container">
<form action="myreg.jlc" method="post"> 
<table> 
<tr> 
<td>Full Name</td> 
<td><input type="text" name="fullName" /></td> 
</tr> 
<tr> 
<td>Email</td>
<td><input type="text" name="email" /></td> 
</tr> 
<tr> 
<td>Phone</td> 
<td><input type="text" name="phone" /></td> 
</tr> 
<tr> 
<td>Date of Birth</td> 
<td><input type="text" name="dob" /></td> 
</tr> 
<tr> 
<td>Gender</td> 
<td><input type="radio" name="gender" value="Male" /> Male <input 
type="radio" name="gender" value="Female" /> Female</td> 
</tr> 
<tr> 
<td>Username</td> 
<td><input type="text" name="username" /></td> 
</tr> 
<tr> 
<td>Password</td> 
<td><input type="password" name="password" /></td> 
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