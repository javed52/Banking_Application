<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Change Password Page</title>
</head>
<body>
<h2>New Password and Confirm new password does not match. Please try again...!</h2><br/>
<form action="ChangePassword">
<table>
<tr><td>New Password : </td>
<td><input type="text"  name="npwd" placeholder="Enter the new password" required="required" /></td>
</tr>
<tr><td>Confirm New Password :</td>
<td><input type="password"  name="cnpwd" placeholder="Enter the new password" required="required" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit"  value="Change" /></td>
</tr>
</table>
</form>
</body>
</html>