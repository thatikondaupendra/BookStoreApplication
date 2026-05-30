<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="en"> 
<head>
<meta charset="UTF-8">
<title>Update Profile</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
<style>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}

body {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, #667eea, #764ba2);
  padding: 20px;
}

header {
  background: rgba(45, 52, 54, 0.9);
  padding: 18px;
  text-align: center;
  color: #fff;
  letter-spacing: 1.5px;
  font-size: 28px;
  font-weight: bold;
  width: 100%;
  border-radius: 10px;
  margin-bottom: 20px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
  animation: slideDown 0.8s ease-out;
}

h2 {
  color: #2d3436;
  margin-bottom: 15px;
  font-size: 26px;
  font-weight: 600;
  text-align: center;
}

.login-container {
  background: #ffffff;
  padding: 35px 30px;
  border-radius: 15px;
  box-shadow: 0px 8px 25px rgba(0, 0, 0, 0.25);
  width: 380px;
  animation: fadeIn 1s ease-in-out;
  margin: 20px auto;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.login-container:hover {
  transform: translateY(-5px);
  box-shadow: 0px 12px 30px rgba(0, 0, 0, 0.3);
}

table {
  width: 100%;
}

td {
  padding: 10px 0;
  font-size: 15px;
  font-weight: 500;
  color: #333;
}

.login-container input[type="text"],
.login-container input[type="email"],
.login-container input[type="password"] {
  width: 100%;
  padding: 10px 14px;
  margin-top: 5px;
  border: 1px solid #ddd;
  border-radius: 8px;
  outline: none;
  font-size: 14px;
  background-color: #f9f9f9;
  transition: 0.3s ease;
}

.login-container input[type="text"]:focus,
.login-container input[type="password"]:focus {
  border-color: #667eea;
  box-shadow: 0 0 8px rgba(102, 126, 234, 0.5);
  background-color: #fff;
}

input[type="submit"] {
  background: linear-gradient(135deg, #667eea, #764ba2);
  color: white;
  padding: 12px;
  border: none;
  border-radius: 8px;
  font-size: 16px;
  font-weight: bold;
  cursor: pointer;
  margin-top: 15px;
  width: 100%;
  box-shadow: 0px 4px 12px rgba(102, 126, 234, 0.4);
  transition: background 0.3s ease, transform 0.2s ease;
}

input[type="submit"]:hover {
  background: linear-gradient(135deg, #5a67d8, #6b46c1);
  transform: scale(1.03);
}

input[type="submit"]:active {
  transform: scale(0.97);
}

font[color="red"] {
  display: block;
  text-align: center;
  margin-bottom: 15px;
  font-weight: 600;
  animation: shake 0.4s ease-in-out;
}

/* Animations */
@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(-20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes slideDown {
  from { transform: translateY(-30px); opacity: 0; }
  to { transform: translateY(0); opacity: 1; }
}

@keyframes shake {
  0% { transform: translateX(0); }
  25% { transform: translateX(-3px); }
  50% { transform: translateX(3px); }
  75% { transform: translateX(-3px); }
  100% { transform: translateX(0); }
}

footer {
  margin-top: 25px;
  background: rgba(45, 52, 54, 0.9);
  color: #dfe6e9;
  text-align: center;
  padding: 10px;
  font-size: 14px;
  border-radius: 10px;
}

</style>
</head>
<body> 

<header>📚 JLC Bookstore – Spice Up Your Reading!</header>
<h2>Update Profile Form</h2> 
<font color="red" size="5">${UpdateMsg}</font> 

<div class="login-container">
<form action="updateProfile.jlc" method="post"> 
<table> 
<tr> 
<td>UserId</td> 
<td>${MyUserInfo.userId} <input type="hidden" name="userId" value="${MyUserInfo.userId}" /> </td> 
</tr> 
<tr> 
<td>Full Name</td> 
<td><input type="text" name="fullName" value="${MyUserInfo.fullName}" pattern="[A-Za-z ]+" required /></td> 
</tr> 
<tr> 
<td>Email</td> 
<td><input type="email" name="email" value="${MyUserInfo.email}" required pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" /></td> 
</tr> 
<tr> 
<td>Phone</td> 
<td><input type="text" name="phone" value="${MyUserInfo.phone}" pattern="[0-9]{10}" required/></td> 
</tr> 
<%
String role=(String) session.getAttribute("Role");
System.out.println(role);
if(role.equals("user")){ %>
<tr>
<td>Date of Birth</td> 
<td><input type="text" name="dob" value="${MyUserInfo.dob}" readonly="readonly" /></td> 
</tr> 
<tr>
<td>Gender</td> 
<td><input type="text" name="gender" value="${MyUserInfo.gender}" readonly="readonly"/> </td> 
</tr> 
<%} %>
<tr> 
<td>Username</td> 
<td><input type="text" name="username" value="${MyUserInfo.username}" readonly="readonly"/> </td> 
</tr> 
<tr> 
<td>Password</td> 
<td><input type="password" name="password" value="${MyUserInfo.password}" readonly="readonly" /></td> 
</tr> 
<tr> 
<td colspan="2" align="center">
<input type="submit" value="Update My Profile" />
</td> 
</tr> 
</table> 
</form> 
</div>

<footer>© 2025 JLC Bookstore | All Rights Reserved</footer>

</body> 
</html> 
