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
	
	
	<h1>Async Result</h1>
	
	
	<p>${message}</p>
	
	<c:url value="/" var="home"></c:url>
	<a href="${home}">Home</a>
	
	
</body>
</html>