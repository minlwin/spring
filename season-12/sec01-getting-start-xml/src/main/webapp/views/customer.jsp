<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security Demo</title>

<link rel="stylesheet" href="../resources/css/bootstrap.min.css" />
<script src="../resources/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<div class="container mt-4">
		
		<h1>Customer Home</h1>
		
		<div>
			<a href="/" class="btn btn-primary">Public Home</a>
			<sf:form class="d-inline-block" action="/logout" method="post">
				<button type="submit" class="btn btn-danger">Logout</button>
			</sf:form>
		</div>
	</div>

</body>
</html>