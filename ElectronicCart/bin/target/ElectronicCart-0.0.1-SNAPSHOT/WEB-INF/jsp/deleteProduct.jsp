<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@include file="userDetails.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Delete Product</title>
</head>
<body>
	<form:form id="submitForm" action="productDeletion.html" method="post">
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
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${productDetails}">
						<tr>
							<th><c:out value="${product.category}"></c:out></th>
							<th><c:out value="${product.productType}"></c:out></th>
							<th><c:out value="${product.productSubType}"></c:out></th>
							<th><c:out value="${product.productDescription}"></c:out></th>
							<th><button id="${product.productId}"
									value="${product.productId}" onclick='deleteProduct(this)'>Delete</button></th>
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
		function deleteProduct(userValue) {
			var tempVar = userValue.value;
			document.getElementById("userSelection").value = tempVar;
		}
	</script>
</body>
</html>