<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./Stylesheets/Loginpage.css">
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<div class="Header">
<H2>Fill the form to Login!</H2>
</div>
<div class="error-text">
<%
if(session.getAttribute("flag")=="false")
{
	out.print("Invalid Credentials");
}
%>
</div>
<div class="container">
<form action="Login" method="post">
Username: <input type="text" name="uname" class= "input1" required><br>
Password: <input type="password" name="pass" class= "input2" required><br>
<input type="submit" value="Login">
<p>If you are a new user:</p>
<a href="SignupPage.jsp">Register</a>
</form>
</div>
</body>
</html>