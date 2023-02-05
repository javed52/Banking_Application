<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply Loan Page</title>
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
<form action = "filldetail.jsp">
<input type="radio" name="loan" value="Home Loan" />Home Loan<br>
<input type="radio" name="loan" value="Education Loan" />Education Loan<br>
<input type="radio" name="loan" value="Gold Loan" />Gold Loan<br>
<input type="radio" name="loan" value="Personal Loan" />Personal Loan<br>
<input type="radio" name="loan" value="Car Loan" />Car Loan<br>
<input type="radio" name="loan" value="Medical Loan" />Medical Loan<br>
<input type="submit" value="Submit" />
</form>

</body>
</html>