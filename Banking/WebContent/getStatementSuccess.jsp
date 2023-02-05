<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statement Page</title>
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
<h1>Dear Customer, <%= session.getAttribute("name") %></h1><br>
<h2>Your transaction details are : </h2>
<h2>Money Credited are :</h2>
<ol>
<%
ArrayList<Integer> arrayList = (ArrayList<Integer>)session.getAttribute("arrayList");
for(Integer x : arrayList)
{
	if(x > 0)
		out.println("<li>"+"+"+x+"</li>");
}
%>
</ol>
<h2>Money Debited are :</h2>
<ol>
<%
arrayList = (ArrayList<Integer>)session.getAttribute("arrayList");
for(Integer x : arrayList)
{
	if(x<0)
		out.println("<li>"+x+"</li>");
}
%>
</ol>
<h3> <a href ="Logout">Click here to Logout </a></h3>
</body>
</html>