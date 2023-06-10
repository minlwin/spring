<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mappings</title>
</head>
<body>

	<h1>Mapping Demo</h1>
	
	<ul>
		<li>
			<c:url value='/multi' var="multi"></c:url>
			<a href="${multi}">Multi Actions</a>
		</li>
		<li>
			<c:url value='/inputs' var="inputs"></c:url>
			<a href="${inputs}">User Input</a>
		</li>
		<li>
			<c:url value='/course' var="course"></c:url>
			<a href="${course}">Return Type Demo</a>
		</li>
	</ul>


</body>
</html>