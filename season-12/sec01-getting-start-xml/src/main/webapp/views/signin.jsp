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
		
		<h1>Customer Login</h1>
		
		<c:url value="/login" var="loginUrl"></c:url>
		<sf:form action="${loginUrl}" method="post" cssClass="w-50">
			
			<div class="mb-3">
				<label class="form-label">Email</label>
				<input type="text" name="username" placeholder="Enter Login Email" class="form-control" />
			</div>
		
			<div class="mb-3">
				<label class="form-label">Password</label>
				<input type="password" name="password" placeholder="Enter Password" class="form-control" />
			</div>
			
			<div class="mb-3">
				<input type="checkbox" name="remember-me" id="rememberMe" class="form-check-input" />
				<label for="rememberMe" class="form-check-label">Remember Me</label>
			</div>
			
			<div>
				<button type="submit" class="btn btn-primary">Login</button>				
				<a href="/signup" class="btn btn-primary">Sign Up</a>
				<a href="/" class="btn btn-primary">Public Home</a>
			</div>

		</sf:form>
				
	</div>
	
</body>
</html>