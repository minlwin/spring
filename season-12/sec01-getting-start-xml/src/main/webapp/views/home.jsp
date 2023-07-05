<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		
		<h1>Hello Spring Scurity</h1>
		
		<div>
			<a href="/admin" class="btn btn-primary">Admin Home</a>
			<a href="/member" class="btn btn-success">Member home</a>
			<a href="/customer" class="btn btn-success">Customer home</a>
			<a href="/customer/address/edit" class="btn btn-success">Customer Address Edit</a>
			<a href="/authentication" class="btn btn-info">Customer Login</a>
		</div>
	</div>

</body>
</html>