<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Transfer Amount Page</title>
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
<form action="Transfer">
<table>
<tr><td>RECEIVER ACCOUNT : </td>
<td><input type="text"  name="racn" placeholder="Enter the Receiver Account Number" required="required" /></td>
</tr>
<tr><td>AMOUNT :</td>
<td><input type="text"  name="amt" placeholder="Enter the Amount" required="required" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" style="background-color:blue;color:white;width:150px;height:40px;" value="Transfer" /></td>
</tr>
</table>
</form>
<h3> <a href ="Logout">Click here to Logout </a></h3>
</body>
</html>