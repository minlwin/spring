<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello MVC</title>
</head>
<body>

	<h1>Hello Spring MVC</h1>
	
	<p>
		<c:out value="${message}"></c:out>
	</p>
	
	<ul>
		<li>
			<c:url value="/legacy" var="legacyLink"></c:url>
			<a href="${legacyLink}">Legacy Controller</a>
		</li>
		
		<li>
			<c:url value="/router-demo" var="routerDemo"></c:url>
			<a href="${routerDemo}">Router Function</a>
		</li>
	</ul>

</body>
</html>