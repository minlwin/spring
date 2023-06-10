<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security Demo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container pt-4">
		
		<h1>Web Security</h1>
		
		<div class="mb-3">
			
			<a href="/" class="btn btn-primary">Home</a>
			<a href="/admin" class="btn btn-success">Admin Home</a>
			<a href="/member" class="btn btn-danger">Member Home</a>
	
			<sec:authorize access="isAuthenticated()">
				<a href="/logout" class="btn btn-secondary">Logout</a>
			</sec:authorize>
		
		</div>
		
		<c:if test="${ not empty title }">

			<div class="card">
				<h5 class="card-header">${ title }</h5>
				
				<div class="card-body">${ message }</div>
			</div>
		
		</c:if>
		
	
	</div>

</body>
</html>