<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Success</title>
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
<h1>Dear Customer,</h1><br/>
<h2>Your balance is</h2><%=session.getAttribute("balance") %>
</body>
</html>