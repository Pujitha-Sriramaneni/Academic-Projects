<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@include file="userDetails.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ECART - Executive Home</title>
</head>
<body>
	<form method="post">
		<input id="loggedInAs" value="${userDetail.loginUserName}"
			name="loggedInAs" type="hidden"> <input id="loggedUserType"
			value="${userDetail.userType}" name="loggedUserType" type="hidden">
		<center>
			<table border="0">
				<tbody>
					<tr>
						<th>
							<button onclick="pendingOrdersFromCustomers.html"
								formaction="pendingOrdersFromCustomers.html"
								style="color: blue; width: 5cm;">
								<h3>Message Pending Customer Orders</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="pendingDispatchFromRetailer.html"
								formaction="pendingDispatchFromRetailer.html"
								style="color: blue; width: 5cm;">
								<h3>Message Pending Retailer Dispatches</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="pendingReceiveFromCustomer.html"
								formaction="pendingReceiveFromCustomer.html"
								style="color: blue; width: 5cm;">
								<h3>Message Pending Customer Receiving</h3>
							</button>
						</th>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>