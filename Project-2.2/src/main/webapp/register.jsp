<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register here</title>
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
		<h2>Enter your personal details here</h2>
			<form action="register">
            <table>
                <tr>
                    <td> <label for="name">Name:</label></td>
                    <td><input type="text" placeholder="Enter Your Name" name="name"> </td>  
                </tr>
                <tr>
                   <td><label for="email">Email:</label></td>
                    <td><input type="email" placeholder="Enter Your email" name="email"></td>
                </tr>
                <tr>
                    <td><label for="gender">Gender:</label></td>
                    <td><select name="gender">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select></td>
                </tr>
                <tr>
                    <td><label for="nationality">Nationality:</label></td>
                    <td><select name="nationality">
                        <option value="Indian">Indian</option>
                        <option value="Foreign">foreign</option>
                    </select></td>
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