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
		
		<h1>Customer Sign Up</h1>
		
		<c:url value="/signup" var="signUpAction"></c:url>
		<sf:form action="${signUpAction}" method="post" modelAttribute="form" cssClass="w-50">
			
			<div class="mb-3">
				<label class="form-label">Name</label>
				<sf:input path="name" placeholder="Enter Customer Name" cssClass="form-control" />
				<sf:errors path="name" cssClass="text-secondary"></sf:errors>
			</div>

			<div class="mb-3">
				<label class="form-label">Email</label>
				<sf:input path="email" type="email" placeholder="Enter Login Email" cssClass="form-control"/>
				<sf:errors path="email" cssClass="text-secondary"></sf:errors>
			</div>
		
			<div class="mb-3">
				<label class="form-label">Password</label>
				<sf:input path="password" type="password" placeholder="Enter Password" cssClass="form-control"/>
				<sf:errors path="password" cssClass="text-secondary"></sf:errors>
			</div>
			
			<div>
				<button type="submit" class="btn btn-primary">Sign Up</button>				
				<a href="/" class="btn btn-primary">Public Home</a>
			</div>

		</sf:form>
				
	</div>
	
</body>
</html>