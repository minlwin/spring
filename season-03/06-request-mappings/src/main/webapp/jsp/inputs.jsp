<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Inputs</title>
</head>
<body>

	<h1>User Inputs</h1>
	
	<div>
		<c:if test="${ not empty type and not empty id }">
			<h3>${ type } / ${ id }</h3>	
		</c:if>
		
		<c:if test="${not empty date}">
			<h3>${ date }</h3>
		</c:if>
	</div>
	
	<ul>
		<li>
			<c:url value="/inputs/Path Type/search/10011" var="pathLink"></c:url>
			<a href="${pathLink}">Path Variable</a>
		</li>
		<li>
			<c:url value="/inputs/2021-12-20" var="dateLink"></c:url>
			<a href="${dateLink}">2021-12-20</a>
		</li>
		<li>
			<c:url value="/inputs/Basic" var="enumLink"></c:url>
			<a href="${enumLink}">Using Enum</a>
		</li>
		<li>
			<c:url value="/inputs/matrix/Western%20Shirt;s=L" var="matrixLink"></c:url>
			<a href="${matrixLink}">Using Matrix</a>
		</li>
		<li>
			<c:url value="/inputs/request?p=Jeans&w=34&l=29" var="requestLink"></c:url>
			<a href="${requestLink}">Request Parameters</a>
		</li>
	</ul>

</body>
</html>