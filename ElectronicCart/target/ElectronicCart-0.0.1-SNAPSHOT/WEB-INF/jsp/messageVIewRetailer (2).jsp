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
<title>Insert title here</title>
</head>
<body>
	<form:form name="retailerReadMessageForm" action="retailerReadMessage.html" method="post">
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
						<th>Customer</th>
						<th>Quantity</th>
						<th>Total Amount</th>
						<th>Message</th>
						<th>Mark as Read</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="remMsg" items="${remainderMessages}">
						<tr>
							<th><c:out
									value="${remMsg.customerCart.retailerProduct.product.category}"></c:out></th>
							<th><c:out
									value="${remMsg.customerCart.retailerProduct.product.productType}"></c:out></th>
							<th><c:out
									value="${remMsg.customerCart.retailerProduct.product.productSubType}"></c:out></th>
							<th><c:out
									value="${remMsg.customerCart.retailerProduct.product.productDescription}"></c:out></th>
							<th><c:out
									value="${remMsg.customerCart.retailerProduct.productBrandName}"></c:out></th>
							<th><c:out
									value="${remMsg.customerCart.retailerProduct.productPrice}"></c:out></th>
							<th><c:out value="${remMsg.customerCart.customerId}"></c:out></th>
							<th><c:out value="${remMsg.customerCart.quantity}"></c:out></th>
							<th><c:out value="${remMsg.customerCart.totalValue}"></c:out></th>
							<th><c:out value="${remMsg.executiveMessage}"></c:out></th>
							<th><c:if test="${remMsg.isMessageViewed == 'N' }">
									<button id="${remMsg.messageId}" value="${remMsg.messageId}"
										onclick='messageFuncRetRead(this)' style="color: purple;">Read</button>
								</c:if> <c:if test="${remMsg.isMessageViewed == 'Y' }">
									<c:out value="Viewed Message"></c:out>
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
		function messageFuncRetRead(userValue) {
			var temp = userValue.value;
			document.getElementById("userSelection").value = temp;
		}
	</script>
</body>
</html>