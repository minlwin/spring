<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security Demo</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container mt-4">
	
		<h1>Member Login</h1>
		
		<form:form action="/login" method="post" cssClass="w-50">
		
			<c:if test="${null ne param.error}">
			<div class="alert alert-info">
				${param.error}
			</div>	
			</c:if>
			
			<div class="mb-3">
				<label class="form-label">Login ID</label>
				<input name="username" value="${param.username}" type="text" placeholder="Enter Login ID" class="form-control" />
			</div>
		
			<div class="mb-3">
				<label class="form-label">Password</label>
				<input name="password" type="password" placeholder="Enter Password" class="form-control" />
			</div>
			
			<button class="btn btn-primary">Login</button>

		</form:form>

	</div>

</body>
</html>