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
<title>Retailer - Add to Shop</title>
</head>
<body>
	<form:form name="retailerAddToShop" action="addToRetailerShop.html"
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
						<th>Product Stock</th>
						<th>Add</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="prd" items="${products}">
						<tr>
							<th><c:out value="${prd.category}"></c:out></th>
							<th><c:out value="${prd.productType}"></c:out></th>
							<th><c:out value="${prd.productSubType}"></c:out></th>
							<th><c:out value="${prd.productDescription}"></c:out></th>
							<th><input type="text" id="${prd.productId}~BrandName"></th>
							<th><input type="text" id="${prd.productId}~ProductPrice"></th>
							<th><input type="text" id="${prd.productId}~ProductStock"></th>
							<th><button id="${prd.productId}" value="${prd.productId}"
									onclick='addProductToShop(this)'>Add To Shop</button></th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
		function addProductToShop(userValue) {
			var temp = userValue.value
					+ '~'
					+ document.getElementById(userValue.value + '~BrandName').value
					+ '~'
					+ document
							.getElementById(userValue.value + '~ProductPrice').value
					+ '~'
					+ document
							.getElementById(userValue.value + '~ProductStock').value;
			document.getElementById("userSelection").value = temp;
		}
	</script>
</body>
</html>