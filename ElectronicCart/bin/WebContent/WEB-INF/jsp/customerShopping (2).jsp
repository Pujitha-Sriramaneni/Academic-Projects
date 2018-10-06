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
<title>Customer Shopping</title>
</head>
<body>
	<form:form id="customerSearchSubmitForm" action="searchResults.html"
		method="post">
		<input id="loggedInAs" value="${userDetail.loginUserName}"
			name="loggedInAs" type="hidden">
		<input id="loggedUserType" value="${userDetail.userType}"
			name="loggedUserType" type="hidden">
		<input type="hidden" name="userSelection" id="userSelection">
		<center>
			<h3 style="color: maroon;">
				Search With your key word <input type="text"
					style="width: 5cm; height: 1cm; color: blue;" id="userInput">
			</h3>
			<button id="search" onclick='searchKey()' style="color: blue;">Search</button>
		</center>
	</form:form>
	<script type="text/javascript">
		function searchKey() {
			var temp = document.getElementById("userInput").value;
			document.getElementById("userSelection").value = temp;
		}
	</script>
</body>
</html>