<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ECart Home</title>
</head>
<body>
	<center>
		<h1 style="color: purple;">Welcome to Electronic Cart</h1>
		<br> <br>
	</center>
	<form>
		<center>
			<button onclick="signup.html" formaction="signup.html"
				style="color: blue;">
				<h3>New User</h3>
			</button>
			<br> <br>
			<button onclick="login.html" formaction="login.html"
				style="color: blue;">
				<h3>Existing User</h3>
			</button>
		</center>
	</form>
</body>
</html>