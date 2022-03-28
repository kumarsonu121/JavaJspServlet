<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./Stylesheets/videospage.css">
<meta charset="ISO-8859-1">
<title>Videos</title>
</head>
<body style="">
 <%
 
 response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
 if(session.getAttribute("username")==null)
 {
	 response.sendRedirect("LoginPage.jsp");
 }
 
 %>
 <div class="Header">
 <h4>Welcome ${username}</h4>
 <form action="Logout" method="get">
 <input type="submit" value="Logout">
 </form>
</div>
<div class="body-container">
<iframe class="iframe1" width="560" height="315" src="https://www.youtube.com/embed/5yCoBIk4oPo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="560" height="315" src="https://www.youtube.com/embed/eTo8QIOvWbM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>
<div class="body-container">
<iframe class="iframe1" width="560" height="315" src="https://www.youtube.com/embed/ngvHz_yEvtw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="560" height="315" src="https://www.youtube.com/embed/tRzKICI62ks" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>
<div class="body-container">
<iframe class="iframe1" width="560" height="315" src="https://www.youtube.com/embed/K4QA-MvAKqk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="560" height="315" src="https://www.youtube.com/embed/gf3yQ_5HVnM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>
<div class="footer">
<ul>
<li class="item1">Contact: 9123456780</li>
<li><h5>All Rights are reserved!</h5></li>
<li class="item2">Email Us</li>
</ul>
</div>
</body>
</html>