<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./Stylesheets/Signuppage.css">
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
<div class="header">
<H2>Fill the form to Register!</H2>
</div>
<div class="error-text">
<%
if(session.getAttribute("match")=="false")
{
	out.print("Password didn't match");
	session.setAttribute("match", "true");
}
%>
<%
if(session.getAttribute("flag")=="false")
{
	out.print("Username already exist");
	session.setAttribute("flag", "true");
}
%>
</div>
<div class="container">
<form action="Signup" method="post">
Username: <input type="text" name="uname" class="input1" required><br>
Password: <input type="password" name="pass" class="input2" required><br>
Confirm Password: <input type="password" name="cpass" class="input3" required><br>
<input type="submit" value="SignUp">
<p>If you are already an existing user:</p>
<a href="LoginPage.jsp">Login</a>
</form>
</div>
</body>
</html>