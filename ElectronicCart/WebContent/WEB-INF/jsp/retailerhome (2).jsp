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
<title>Electronic Cart - Retailer Home</title>
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
							<button onclick="productsList.html"
								formaction="productsList.html" style="color: blue; width: 5cm;">
								<h3>Add Product Brands</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="retailerProductModifyList.html"
								formaction="retailerProductModifyList.html"
								style="color: blue; width: 5cm;">
								<h3>Edit Product Brands</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="retailerProductDeleteList.html"
								formaction="retailerProductDeleteList.html"
								style="color: blue; width: 5cm;">
								<h3>Delete Product Brands</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="dispatchOrders.html"
								formaction="dispatchOrders.html"
								style="color: blue; width: 5cm;">
								<h3>Dispatch Orders</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="retailerMessagesFromExecutive.html"
								formaction="retailerMessagesFromExecutive.html"
								style="color: blue; width: 5cm;">
								<h3>Messages</h3>
							</button>
						</th>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
			<script type="text/javascript">
		window.history.forward();
		window.location.hash = " ";
		window.location.hash = " ";
		window.onhashchange = function() {
			window.location.hash = " ";
		}
	</script>
</body>
</html>