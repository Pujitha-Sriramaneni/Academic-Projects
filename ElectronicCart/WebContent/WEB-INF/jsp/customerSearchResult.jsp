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
<title>Customer Search Result</title>
</head>
<body>
	<form:form name="productAddToCart" action="productAddToCart.html"
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
						<th>Retailer</th>
						<th>Quantity</th>
						<th>Add To Cart</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="prd" items="${retailerProducts}">
						<tr>
							<input type="hidden" name="stock" value="${prd.productStock}"
								id="${prd.rtlPrdId}~Stock">
							<input type="hidden" name="cost" value="${prd.productPrice}"
								id="${prd.rtlPrdId}~Price">
							<input type="hidden" name="cost" value="${prd.retailerId}"
								id="${prd.rtlPrdId}~RetailerId">
							<th><c:out value="${prd.product.category}"></c:out></th>
							<th><c:out value="${prd.product.productType}"></c:out></th>
							<th><c:out value="${prd.product.productSubType}"></c:out></th>
							<th><c:out value="${prd.product.productDescription}"></c:out></th>
							<th><c:out value="${prd.productBrandName}"></c:out></th>
							<th><c:out value="${prd.productPrice}"></c:out></th>
							<th><c:out value="${prd.productStock}"></c:out></th>
							<th><c:out value="${prd.retailerId}"></c:out></th>
							<th><input type="text" id="${prd.rtlPrdId}~Quantity"></th>
							<th><button id="${prd.rtlPrdId}" value="${prd.rtlPrdId}"
									onclick='addToCart(this)' style="color: blue;">Add To
									Cart</button></th>
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
		function addToCart(userValue) {
			var temp = userValue.value
					+ '~'
					+ document.getElementById(userValue.value + '~Price').value
					+ '~'
					+ document.getElementById(userValue.value + '~Stock').value
					+ '~'
					+ document.getElementById(userValue.value + '~Quantity').value
					+ '~'
					+ document.getElementById(userValue.value + '~RetailerId').value;
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