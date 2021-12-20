<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mutli Action</title>
</head>
<body>
	
	<h1>Multi Action Controller</h1>
	
	<h3>${ not empty message ? message : 'Default Action' }</h3>
	
	<ul>
		<li>
			<c:url value="/multi/action1" var="action1"></c:url>
			<a href="${action1}">Action 1</a>
		</li>
		<li>
			<c:url value="/multi/action1?id=10" var="action11"></c:url>
			<a href="${action11}">Action 1 with ID</a>
		</li>
		<li>
			<c:url value="/multi/action2" var="action2"></c:url>
			<a href="${action2}">Action 2</a>
		</li>
		<li>
			<c:url value="/multi/100" var="digit"></c:url>
			<a href="${digit}">Path with Digit</a>
		</li>
		<li>
			<c:url value="/multi/sdfsdfdsf" var="wild"></c:url>
			<a href="${wild}">Wild Card</a>
		</li>
		
	</ul>
</body>
</html>