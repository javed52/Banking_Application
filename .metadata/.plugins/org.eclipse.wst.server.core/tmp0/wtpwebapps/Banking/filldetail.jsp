<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Fill Detail</title>
</head>
<body>
<h1 align ="center">Welcome to <%=request.getParameter("loan") %> Page</h1>
<h2>Enter your details : </h2>


<form action="Loan">
<table>
<tr><td>First Name : </td>
<td><input type="text"  name="fname" placeholder="Enter the First Name" required="required" /></td>
</tr>


<tr><td>Last Name :</td>
<td><input type="text"  name="lname" placeholder="Enter the Last Name" required="required" /></td>
</tr>
<tr>
<td>Occupation :</td>
<td>
<select> 
<option ></option>
<option name = "j1" value="Student">Student</option>
<option name = "j1" value="Govt. Employee">Govt. Employee</option>
<option name = "j1" value="Business">Business</option>
<option name = "j1" value="Farmer">Farmer</option>
</select></td>
</tr>
<tr>
<td>Amount :</td>
<td><input type="text"  name="amt" placeholder="Enter the Amount" required="required" /></td>
</tr>

<tr>
<td>Year :</td>
<td><input type="text"  name="year" placeholder="Enter the time" required="required" /></td>
</tr>

<tr>
<td>Salary :</td>
<td><input type="text"  name="salary" placeholder="Enter your salary" required="required" /></td>
</tr>

<tr>
<td> Gender : </td>
<td><input type = "radio" name="g1" value="Male"/>Male <input type = "radio" name="g1" value="Female"/>Female</td>
</tr>

<tr>
<td>DOB :</td>
<td><input type="date"  /></td>
</tr>

<tr hidden>
<%
String loan=request.getParameter("loan");
session.setAttribute("loan", loan);


%></tr>

<tr>
<td hidden><input type="text" name="loantype" value= <%= session.getAttribute("loan") %> hidden></td>
</tr>

<tr>
<td></td>
<td><input type="submit"  value="Submit" /></td>
</tr>

</table>
</form>
</body>
</html>