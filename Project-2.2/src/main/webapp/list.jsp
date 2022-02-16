<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available flights</title>
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
		<h2>
		<%
		session.getAttribute("start");
		session.getAttribute("destination");
		session.getAttribute("source");
		session.getAttribute("time");
		session.getAttribute("date");
		session.getAttribute("price");
		session.getAttribute("seats");
		session.getAttribute("amount");
		out.println("<h2>Dear customer, available flights from ");
		out.println(request.getAttribute("start")+" going to "+request.getAttribute("destination")+" by "+request.getAttribute("source")+" is at");
		out.println(request.getAttribute("time")+" O\' clock on "+request.getAttribute("date")+" </h2>");
		
			%>
		</h2>
		<h3 style="margin: 20px;">Price for 1 seat is <%=request.getAttribute("price")%></h3>
		<h3 style="margin: 20px;">you have booked <%=request.getAttribute("seats")%> seats </h3> 
		<h3 style="margin: 20px;">total payable amount is <%=request.getAttribute("amount")%></h3>
		
		<a style="text-decoration: underline;" href="register.jsp">Proceed further</a>
		 <a style="text-decoration: underline;"href="entry.html">Cancel</a>	
		</div>
	</div>
</body>
</html>