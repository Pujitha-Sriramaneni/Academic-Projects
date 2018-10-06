<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<%@include file="userDetails.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Electronic Cart - Customer Home</title>
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
							<button onclick="goToCart.html" formaction="goToCart.html"
								style="color: blue; width: 5cm;">
								<h3>Go To Cart</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="shoppingPage.html"
								formaction="shoppingPage.html" style="color: blue; width: 5cm;">
								<h3>Shopping</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="goToOrders.html" formaction="goToOrders.html"
								style="color: blue; width: 5cm;">
								<h3>Go To Orders</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="orderHistory.html"
								formaction="orderHistory.html" style="color: blue; width: 5cm;">
								<h3>Orders History</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="ordersEligibleToCancel.html"
								formaction="ordersEligibleToCancel.html"
								style="color: blue; width: 5cm;">
								<h3>Cancel Order</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="messagesFromExecutive.html"
								formaction="messagesFromExecutive.html"
								style="color: blue; width: 5cm;">
								<h3>Messages</h3>
							</button>
						</th>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>