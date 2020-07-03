<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" type="text/css" href="Register.css">
</head>
<body>

<div class="loginbox" >
	<img src="avatar.jpg" class="avatar">
	
<h1>Register Here</h1>

	<form action="Register" method="POST">
	
		<table>
			
				<p>First Name</p>
				<input type="text" name="First_Name">
				
				<p>Last name</p>
				<input type="text" name="Last_Name">
	       
				<p>Userame</p>
				<input type="text" name="User_Name">
				
				<p>Password</p>
				<input type="password" name="Password">
			
				<p>Email</p>
				<input type="text" name="Email">
			
				<p>Confirm Email</p>
				<input type="text" name="Confirm_Email">
			
				<p>Date of Birth</p>
				<input type="date" name="Date_Of_Birth">
			
				
			    <input type="submit" value="Register">
			
		</table>
		</div>
	</form>
</body>
</html>