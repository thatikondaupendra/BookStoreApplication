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
    header{
            background: #2d3436;
            padding: 20px;
            text-align: center;
            color: #fff;
            letter-spacing: 2px;
            font-size: 28px;
            font-weight: bold;
        }
</style>
<link rel="stylesheet" type="text/css" href="logincss.css">
<body> 
<header>📚 JLC Bookstore – Spice Up Your Reading!</header>
<link rel="stylesheet" type="text/css" href="homecss.css">
<div align="center"> 

<h1>BookStore</h1> 
<h2>Registration Form</h2> 
<font color="red" size="5"> ${RegMsg} </font> 

<div class="login-container">
<form action="myreg.jlc" method="post"> 
<table> 
<tr> 
<td>Full Name</td> 
<td><input type="text" name="fullName" pattern="[A-Za-z ]+" required/></td> 
</tr> 
<tr> 
<td>Email</td>
<td><input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required /></td> 
</tr> 
<tr> 
<td>Phone</td> 
<td><input type="text" name="phone" pattern="[0-9]{10}" required/></td> 
</tr> 
<tr> 
<td>Date of Birth</td> 
<td><input type="text" name="dob" required /></td> 
</tr> 
<tr> 
<td>City</td> 
<td><input type="text" name="city" pattern="[A-Za-z ]+" required/></td> 
</tr> 
<tr> 
<td>Gender</td> 
<td><input type="radio" name="gender" value="Male" /> Male <input 
type="radio" name="gender" value="Female" /> Female</td> 
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