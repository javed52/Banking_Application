<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Error Page</title>
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
<form action = "ChangeNPwd">
<table>
<tr ><td>New Password : </td>
<td><input type="text"  name="npwd" placeholder="Enter the new password" required="required" /></td>
</tr>
<tr><td>Confirm New Password :</td>
<td><input type="password"  name="cnpwd" placeholder="Confirm new password" required="required" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit"  value="Submit" /></td>
</tr>
</table>
</form>
</body>
</html>