<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Async MVC Demo</title>
</head>
<body>
	
	
	<h1>Async Demo</h1>
	
	<ul>
	
		<li>
			<c:url value="/async/callable" var="callableLink"></c:url>
			<a href="${callableLink}">Callable Async</a>
		</li>
		<li>
			<c:url value="/async/deferred" var="deferred"></c:url>
			<a href="${deferred}">Deferred Result Async</a>
		</li>
	</ul>
	
	
</body>
</html>