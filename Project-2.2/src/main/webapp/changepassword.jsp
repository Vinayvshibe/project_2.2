<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change password</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
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
		<h2>Change Password</h2>
			<form action="setpassword">
			<table>
			<tr>
                    <td> <label for="username">Username:</label></td>
                    <td><input type="text" placeholder="Enter user name" name="username"> </td>
                    
                </tr>
                <tr>
                    <td> <label for="newpassword">New password:</label></td>
                    <td><input type="text" placeholder="Enter new password" name="newpassword"> </td>
                    
                </tr>
                <tr>
                    <td> <label for="conformpassword">Conform password:</label></td>
                    <td><input type="text" placeholder="Conform new password" name="conformpassword"> </td>
                    
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