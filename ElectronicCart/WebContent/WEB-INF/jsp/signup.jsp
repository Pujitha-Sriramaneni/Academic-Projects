<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Electronic Cart Sign Up</title>
</head>
<body>
	<form name="signup" action="userSignUp.html" method="post">
		<center>
			<h3 style="color: blue;">Please Enter the below details to Sign
				Up</h3>
			<table border="1">
				<tbody align="left" style="color: orange;">
					<tr>
						<h5>
							<th>First Name</th>
							<th><input type="text" name="firstName"
								value=<c:out value="${userDetails.firstName}"></c:out>></th>
						</h5>
					</tr>
					<tr>
						<h5>
							<th>Middle Name</th>
							<th><input type="text" name="middleName"
								value=<c:out value="${userDetails.middleName}"></c:out>></th>
						</h5>
					</tr>
					<tr>
						<h5>
							<th>Last Name</th>
							<th><input type="text" name="lastName"
								value=<c:out value="${userDetails.lastName}"></c:out>></th>
						</h5>
					</tr>
					<tr>
						<h5>
							<th>Contact Number</th>
							<th><input type="text" name="contactNumber"
								value=<c:out value="${userDetails.contactNumber}"></c:out>></th>
						</h5>
					</tr>
					<tr>
						<h5>
							<th>Email Id</th>
							<th><input type="text" name="emailId"
								value=<c:out value="${userDetails.emailId}"></c:out>></th>
						</h5>
					</tr>
					<tr>
						<h5>
							<th>Login User Name</th>
							<th><input type="text" name="loginUserName" maxlength="20"
								value=<c:out value="${userDetails.loginUserName}"></c:out>></th>
						</h5>
					</tr>
					<tr>
						<h5>
							<th>Password</th>
							<th><input type="password" name="password" maxlength="20"></th>
						</h5>
					</tr>
					<tr>
						<h5>
							<th>User Type</th>
							<th><select name="userType">
							<option value="Customer" selected="selected">Customer</option>
							<option value="Retailer">Retailer</option>
							<option value="Sales Executive">Sales Executive</option>
							</select></th>
						</h5>
					</tr>
				</tbody>
			</table>
			<br>
			<c:if test="${not empty message}">
				<h4 style="color: red;">
					<c:out value="${message}"></c:out>
				</h4>
			</c:if>
			<input type="submit" name="signup" value="Sign Up"
				style="color: blue;">
		</center>
	</form>
</body>
</html>