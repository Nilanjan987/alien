<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body background="welcome.jpg">


<%String firstName=(String)session.getAttribute("fName");
String lastName=(String)session.getAttribute("lName");
%>
<center>
Welcome <%= firstName %> <%= lastName %>
</center>

</body>
</html>