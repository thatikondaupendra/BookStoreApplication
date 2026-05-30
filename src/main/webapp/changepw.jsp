<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
<link rel="stylesheet" type="text/css" href="logincss.css">
<style>
    /* Full-page gradient background */
    body {
        font-family: 'Poppins', sans-serif;
        margin: 0;
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        background: radial-gradient(circle at top left, #ff9a9e, #fad0c4, #fad0c4, #fbc2eb, #a18cd1);
        animation: backgroundShift 10s infinite alternate ease-in-out;
    }

    /* Animated background gradient */
    @keyframes backgroundShift {
        0% { background-position: 0% 50%; }
        100% { background-position: 100% 50%; }
    }

    /* Floating Card Effect */
    .login-container {
        background: rgba(255, 255, 255, 0.9);
        border-radius: 20px;
        padding: 40px 35px;
        width: 380px;
        box-shadow: 0 15px 35px rgba(0, 0, 0, 0.3);
        animation: floatUp 0.8s ease-out;
        transform: perspective(1000px) rotateX(0deg);
    }

    @keyframes floatUp {
        from { opacity: 0; transform: translateY(40px) scale(0.95); }
        to { opacity: 1; transform: translateY(0) scale(1); }
    }

    /* Header */
    header {
        background: linear-gradient(135deg, #6a11cb, #2575fc);
        color: white;
        font-size: 26px;
        font-weight: bold;
        text-align: center;
        padding: 15px;
        border-radius: 12px;
        margin-bottom: 25px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
        letter-spacing: 1px;
    }

    /* Title */
    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
        font-size: 24px;
        font-weight: 700;
    }

    /* Table and Labels */
    table {
        width: 100%;
    }
    td {
        padding: 10px;
        font-size: 15px;
        font-weight: 500;
        color: #444;
    }

    /* Password fields */
    input[type="password"] {
        width: 100%;
        padding: 12px;
        border-radius: 12px;
        border: 2px solid #ddd;
        outline: none;
        font-size: 15px;
        transition: 0.3s ease;
        background: #f7f7f7;
    }

    input[type="password"]:focus {
        border-color: #6a11cb;
        box-shadow: 0 0 10px rgba(106, 17, 203, 0.5);
        background: white;
    }

    /* Submit Button - Glowing */
    input[type="submit"] {
        background: linear-gradient(135deg, #ff512f, #dd2476);
        color: white;
        padding: 14px 25px;
        border: none;
        border-radius: 30px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        width: 100%;
        margin-top: 15px;
        box-shadow: 0px 5px 15px rgba(221, 36, 118, 0.5);
        transition: 0.3s ease-in-out;
        animation: glowPulse 2s infinite alternate;
    }

    @keyframes glowPulse {
        from { box-shadow: 0 0 10px rgba(221, 36, 118, 0.4); }
        to { box-shadow: 0 0 25px rgba(221, 36, 118, 0.8); }
    }

    input[type="submit"]:hover {
        transform: scale(1.05);
        background: linear-gradient(135deg, #dd2476, #ff512f);
    }

    /* Error message */
    font[color="red"] {
        display: block;
        text-align: center;
        font-weight: bold;
        margin-bottom: 10px;
        color: #e74c3c;
        font-size: 16px;
    }
</style>
<body> 

<link rel="stylesheet" type="text/css" href="homecss.css">
<div class="center">
<header>📚 JLC Bookstore – Spice Up Your Reading!</header>
<h2>Password Change Form</h2> 
<div class="login-container">
<font color="red" size="5"> ${PwMsg} </font> 
<form action="changepw.jlc" method="post"> 
<table> 
<tr> 
<td>Current Password</td> 
<td><input type="password" name="currentpw" required/></td> 
</tr> 
<tr> 
<td>New Password</td> 
<td><input type="password" name="newpw" required/></td> 
</tr> 
<tr> 
<td>Confirm New Password</td> 
<td><input type="password" name="confirmpw" required/></td> 
</tr> 
<tr> 
<td>
<input type="submit" value="Change Now" />
</td> 
</tr> 
</table> 
</form> 
</div>
</div>
</body> </html>