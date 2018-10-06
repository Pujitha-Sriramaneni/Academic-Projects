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
<title>Customer - Orders</title>
</head>
<body>
	<form:form name="orderReceivedForm" action="orderReceived.html"
		method="post">
		<input id="loggedInAs" value="${userDetail.loginUserName}"
			name="loggedInAs" type="hidden">
		<input id="loggedUserType" value="${userDetail.userType}"
			name="loggedUserType" type="hidden">
		<center>
			<table border="2" bordercolor="blue">
				<input type="hidden" name="userSelection" id="userSelection">
				<thead style="color: orange;">
					<tr>
						<th>Category</th>
						<th>Product Type</th>
						<th>Product SubType</th>
						<th>Product Description</th>
						<th>Product Brand Name</th>
						<th>Product Price(In USD)</th>
						<th>Retailer</th>
						<th>Quantity</th>
						<th>Total Amount</th>
						<th>Receive</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="custCart" items="${customerCarts}">
						<tr>
							<th><c:out
									value="${custCart.retailerProduct.product.category}"></c:out></th>
							<th><c:out
									value="${custCart.retailerProduct.product.productType}"></c:out></th>
							<th><c:out
									value="${custCart.retailerProduct.product.productSubType}"></c:out></th>
							<th><c:out
									value="${custCart.retailerProduct.product.productDescription}"></c:out></th>
							<th><c:out
									value="${custCart.retailerProduct.productBrandName}"></c:out></th>
							<th><c:out value="${custCart.retailerProduct.productPrice}"></c:out></th>
							<th><c:out value="${custCart.retailerProduct.retailerId}"></c:out></th>
							<th><c:out value="${custCart.quantity}"></c:out></th>
							<th><c:out value="${custCart.totalValue}"></c:out></th>
							<th><c:if test="${custCart.isDispatched eq 'N'}">
									<c:out value="Waiting for Retailer to Dispatch"></c:out>
								</c:if> <c:if test="${custCart.isDispatched eq 'Y'}">
									<button id="${custCart.customerCartId}"
										value="${custCart.customerCartId}"
										onclick='receivedFunc(this)' style="color: purple;">Received</button>
								</c:if></th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<c:if test="${not empty message}">
				<c:if test="${fn:contains(message, 'Successfull')}">
					<h4 style="color: blue;">
						<c:out value="${message}"></c:out>
					</h4>
				</c:if>
				<c:if test="${not fn:contains(message, 'Successfull')}">
					<h4 style="color: red;">
						<c:out value="${message}"></c:out>
					</h4>
				</c:if>
			</c:if>
		</center>
	</form:form>
	<script type="text/javascript">
		function receivedFunc(userValue) {
			var temp = userValue.value;
			document.getElementById("userSelection").value = temp;
		}
	</script>
	<form:form>
		<input id="loggedInAs" value="${userDetail.loginUserName}"
			name="loggedInAs" type="hidden">
		<input id="loggedUserType" value="${userDetail.userType}"
			name="loggedUserType" type="hidden">
		<center>
			<button onclick="shoppingPage.html" formaction="shoppingPage.html"
				style="color: blue; width: 5cm;">
				<h4>Go To Search</h4>
			</button>
		</center>
	</form:form>
</body>
</html>