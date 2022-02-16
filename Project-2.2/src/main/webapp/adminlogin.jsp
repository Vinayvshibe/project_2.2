<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin login</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="top"> 
			<div class="cl1">
				<h3>FlyAway</h3>
			</div>
			<div class="cl9">
				<h3>FlyAway a safest way to fly across the Globe</h3>
			</div>
		</div>
		<div class="sec2">
		<h2>Admin Login</h2>
			<form action="login">
			<table>
				<tr>
                    <td> <label for="user">Username:</label></td>
                    <td><input type="text" placeholder="Enter username" name="user"> </td>    
                </tr>
                <tr>
                   <td><label for="pass">Password:</label></td>
                    <td><input type="password" placeholder="Enter password" name="pass"></td>
                </tr>
                <tr>
                    <td><button type="submit">Submit</button></td>
                    <td><button type="reset">Reset</button></td>
                </tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>