<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
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
		<h2>Total payable amount for <%=session.getAttribute("seats")%> seats is <%=session.getAttribute("amount")%> rupees only</h2>
		<a style="text-decoration: underline;"href="succeed.jsp"><%=session.getAttribute("amount")%> Pay</a>
	    <a style="text-decoration: underline;"href="cancelpayment.html">Cancel</a>
		</div>
	</div>
</body>
</html>