<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security Demo</title>

<c:url value="/resources/css/bootstrap.min.css" var="bootCss"></c:url>
<link rel="stylesheet" href="${bootCss}" />
<c:url value="/resources/js/bootstrap.bundle.min.js" var="bootJs"></c:url>
<script src="${bootJs}"></script>

</head>
<body>

	<div class="container mt-4">
		
		<h1>Member Home</h1>
		
		<div>
			<a href="/" class="btn btn-primary">Public Home</a>

			<a href="#" class="btn btn-primary" id="logoutBtn">Logout</a>
		</div>

		<c:url value="/resources/js/client-logout.js" var="clientLogoutJs"></c:url>
		<script src="${clientLogoutJs}"></script>
	</div>

</body>
</html>