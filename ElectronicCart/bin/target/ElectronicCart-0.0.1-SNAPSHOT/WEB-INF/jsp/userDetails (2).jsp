<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<table align="right" border="1">
		<tbody align="left">
			<tr>
				<h5>
					<th style="color: orange;">User Name</th>
					<th style="color: green;"><c:out
							value="${userDetail.loginUserName}"></c:out></th>
				</h5>
			</tr>
			<tr>
				<h5>
					<th style="color: orange;">User Role</th>
					<th style="color: green;"><c:out
							value="${userDetail.userType}"></c:out></th>
				</h5>
			</tr>
		</tbody>
	</table>
	<br><br><br>
	<table align="right" border="1">
		<tbody>
			<tr>
				<form:form>
					<input id="loggedInAs" value="${userDetail.loginUserName}"
						name="loggedInAs" type="hidden">
					<input id="loggedUserType" value="${userDetail.userType}"
						name="loggedUserType" type="hidden">
					<th>
						<button onclick="userHome.html" formaction="userHome.html"
							style="color: blue; height: auto; width: auto;">HOME</button>
					</th>
					<th>
						<button onclick="logout.html" formaction="logout.html"
							style="color: blue; height: auto; width: auto;">Logout</button>
					</th>
				</form:form>
			</tr>
		</tbody>
	</table>
</body>
</html>