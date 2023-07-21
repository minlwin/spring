<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authentication Events</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container mt-4">
		
		<h3>Authentication Events</h3>
		
		<div class="mt-4">
			<c:url value="/member/access" var="memberAccess"></c:url>
			<a href="${memberAccess}" class="btn btn-outline-primary">Member Access</a>

			<c:url value="/admin/access" var="adminAccess"></c:url>
			<a href="${adminAccess}" class="btn btn-outline-primary">Admin Access</a>
		</div>
	
	</div>

</body>
</html>