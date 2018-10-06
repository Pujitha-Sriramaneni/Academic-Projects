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
<title>Electronic Cart - Admin Approvals</title>
</head>
<body>
	<form:form id="submitForm" action="adminApprovalResponse.html"
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
						<th>Login User Name</th>
						<th>First Name</th>
						<th>Middle Name</th>
						<th>Last Name</th>
						<th>Contact Number</th>
						<th>Email ID</th>
						<th>User Type</th>
						<th>Approve</th>
						<th>Reject</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${userDetails}">
						<tr>
							<th><c:out value="${user.loginUserName}"></c:out></th>
							<th><c:out value="${user.firstName}"></c:out></th>
							<th><c:out value="${user.middleName}"></c:out></th>
							<th><c:out value="${user.lastName}"></c:out></th>
							<th><c:out value="${user.contactNumber}"></c:out></th>
							<th><c:out value="${user.emailId}"></c:out></th>
							<th><c:out value="${user.userType}"></c:out></th>
							<th><button id="${user.loginUserName}"
									value="${user.loginUserName}~${user.userType}"
									onclick='adminAcceptance(this)'>Accept</button></th>
							<th><button id="${user.loginUserName}"
									value="${user.loginUserName}~${user.userType}"
									onclick='adminRejectance(this)'>Reject</button></th>
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
		function adminAcceptance(userValue) {
			var tempValue = userValue.value;
			document.getElementById("userSelection").value = tempValue
					+ "~Accept";
		}
		function adminRejectance(userValue) {
			var tempValue = userValue.value;
			document.getElementById("userSelection").value = tempValue
					+ "~Reject";
		}
	</script>
</body>
</html>