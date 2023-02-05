<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Transfer Page</title>
<style type="text/css">
body
{
	margin: 0;
	padding: 0;
	background: url(/Banking/bkimg.jpg);
	background-size:cover;
	background-position:center;
	font-family:sans-serif;
}
</style>
</head>
<body>
<h2>Re.<%= session.getAttribute("amt") %> will be transferred to this Account Number <%= session.getAttribute("racn") %> </h2>
<h3> <a href ="Logout">Click here to Logout </a></h3>
</body>
</html>