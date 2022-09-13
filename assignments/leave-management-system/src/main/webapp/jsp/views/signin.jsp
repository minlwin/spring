<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leaves | Sign In</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<c:url var="commonCss" value="/resources/application.css"></c:url>
<link rel="stylesheet" href="${commonCss}" />

</head>
<body class="vh-100">


	<div class="d-flex vh-100 justify-content-center align-items-center">
	
		<div class="card login-form">
			
			<div class="card-header">
				<i class="bi bi-door-open"></i> Sign In
			</div>
			
			<div class="card-body">
			
				<c:url var="signin" value="/signin"></c:url>
				<sf:form action="${signin}" method="post">
				
					<c:if test="${ not empty param.error }">
						<div class="alert alert-warning">Login Error.</div>
					</c:if>
					
					<div class="mb-3">
						<label class="form-label">Email</label>
						<input type="email" name="username" placeholder="Enter Email Address" class="form-control" />
					</div>
					
					<div class="mb-3">
						<label for="" class="form-label">Password</label>
						<input type="password" name="password" placeholder="Enter Password" class="form-control" />
					</div>
					
					<div class="mb-3">
						<button type="submit" class="btn btn-outline-success">
							<i class="bi bi-door-open"></i> Sign In
						</button>
					</div>
				
				</sf:form>
			
			
			</div>
		
		</div>
	
	</div>


</body>
</html>