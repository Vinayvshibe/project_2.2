<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment done </title>
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
		<div class="sec1">	
		<h2>Dear 
		<%=session.getAttribute("name")%>
		 your booking of 
		 <%=session.getAttribute("seats")%>
		  seats is successfully done ticket and flight details are send to registered email  
		  <%=session.getAttribute("email")%></h2> 
		<h2>Your journey will start from 
		<%=session.getAttribute("start")%> Airport
		 on 
		 <%=session.getAttribute("date")%>
		  at 
		  <%=session.getAttribute("time")%>
		   O'clock via 
		   <%=session.getAttribute("source")%>
		    and ends to 
		    <%=session.getAttribute("destination")%></h2>
		<h2>Thank you for choosing Flyaway
		<%
			session.removeAttribute("name");
		session.removeAttribute("email");
		session.removeAttribute("seats");
		session.removeAttribute("start");
		session.removeAttribute("source");
		session.removeAttribute("destination");
		session.removeAttribute("date");
		session.removeAttribute("time");
		session.removeAttribute("amount");
		session.removeAttribute("price");
		%></h2>
		 <a style="text-decoration: underline;"href="entry.html">Back to main menu</a>	
		</div>
	</div>
</body>
</html>