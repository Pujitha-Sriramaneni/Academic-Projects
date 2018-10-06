<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<%@include file="userDetails.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Electronic Cart - Admin Home</title>
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
							<button onclick="approveOrRejectRetailer.html"
								formaction="approveOrRejectRetailer.html"
								style="color: blue; width: 5cm;">
								<h3>Approve/Reject Retailer</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="deleteRetailer.html"
								formaction="deleteRetailer.html"
								style="color: blue; width: 5cm;">
								<h3>Delete Retailer</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="approveOrRejectExecutive.html"
								formaction="approveOrRejectExecutive.html"
								style="color: blue; width: 5cm;">
								<h3>Approve/Reject Executive</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="deleteExecutive.html"
								formaction="deleteExecutive.html"
								style="color: blue; width: 5cm;">
								<h3>Delete Executive</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="newProductAddition.html"
								formaction="newProductAddition.html"
								style="color: blue; width: 5cm;">
								<h3>Add New Product</h3>
							</button>
						</th>
					</tr>
					<tr>
						<th>
							<button onclick="deleteProduct.html"
								formaction="deleteProduct.html" style="color: blue; width: 5cm;">
								<h3>Delete Product Combination</h3>
							</button>
						</th>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>