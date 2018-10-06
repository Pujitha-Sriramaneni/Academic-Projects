<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ECART - Login Page</title>
</head>
<body>
	<form name="login" action="userLogin.html" method="post">
		<center>
			<h3 style="color: blue;">Please Enter your credentials to Login</h3>
			<h4 style="color: orange;">
				User Name <input type="text" name="userName">
			</h4>
			<h4 style="color: orange;">
				Password <input type="password" name="password">
			</h4>
			<br>
			<c:if test="${not empty message}">
				<h4 style="color: red;">
					<c:out value="${message}"></c:out>
				</h4>
			</c:if>
			<input type="submit" name="login" value="login" style="color: blue;">
		</center>
	</form>

</body>
</html>