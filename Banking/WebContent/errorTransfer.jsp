<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Error Transfer Amount</title>
</head>
<body>
<strong>Please sending amount atleast Re. 01 </strong>
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
<td><input type="submit" style="background-color:grey;color:white;width:150px;height:40px;" value="Transfer" /></td>
</tr>
</table>
</form>
</body>
</html>