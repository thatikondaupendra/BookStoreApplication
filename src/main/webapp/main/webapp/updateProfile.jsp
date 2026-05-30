<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2>Update Profile Form</h2> 
<font color="red" size="5"> ${UpdateMsg} </font> 

<div class="login-container">
<form action="updateProfile.jlc" method="post"> 
<table> 
<tr> 
<td>UserId</td> 
<td>${MyUserInfo.userId} <input type="hidden" name="userId" value="${MyUserInfo.userId}" /> 
</td> 
</tr> 
<tr> <td>Full Name</td> 
<td><input type="text" name="fullName" 
value="${MyUserInfo.fullName}" /></td> 
</tr> 
<tr> 
<td>Email</td> 
<td><input type="text" name="email" value="${MyUserInfo.email}" /></td> 
</tr> 
<tr> 
<td>Phone</td> 
<td><input type="text" name="phone" value="${MyUserInfo.phone}" /></td> 
</tr> 
<tr>
<td>Date of Birth</td> 
<td><input type="text" name="dob" value="${MyUserInfo.dob}" readonly="readonly" /></td> 
</tr> 
<tr>
<td>Gender</td> 
<td> <input type="text" name="userId" value="${MyUserInfo.gender}" readonly="readonly"/> 
</td> 
</tr> 
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
</div> 
</body> 
</html> 

