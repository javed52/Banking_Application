<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
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
<h1 align ="center">Registration Page</h1>
<form action = "Registration">
<table >

<tr>
<td><strong>Name : </strong></td>
<td><input type="text" name="name" placeholder="Enter your name" required="required"  /></td>
</tr>
<tr>
<td><strong>Account No. : </strong></td>
<td><input type="text" name="acno" placeholder="Enter your account no." required="required"  /></td>
</tr>
<tr>
<td><strong>Balance : </strong></td>
<td><input type="text" name="balance" placeholder="Enter the balance" required="required"  /></td>
</tr>
<tr>
<td><strong>Customer Id : </strong></td>
<td><input type="text" name="cid" placeholder="Enter the customer id" required="required"  /></td>
</tr>
<tr>
<td><strong>Password : </strong></td>
<td><input type="text" name="pwd" placeholder="Enter the password" required="required"  /></td>
</tr>
<tr>
<td><strong>Email : </strong></td>
<td><input type="text" name="email" placeholder="Enter your email" required="required"  /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="submit" value="Register"   /></td>
</tr>

</table>
</form>
</body>
</html>