<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		
		<h3>Security Demo</h3>
		
		<div>
			
			<a href="/" class="btn btn-primary">Home</a>
			
			<sec:authorize access="hasAuthority('Admin')">
				<a href="/admin/home" class="btn btn-danger">Admin</a>
			</sec:authorize>
		
			<a href="/member/home" class="btn btn-info">Member</a>
			
			<sec:authorize access="isAnonymous()">
				<a href="/signup" class="btn btn-secondary">Sign Up</a>
			</sec:authorize>
			
			<sec:authorize access="isAuthenticated()">
				<a href="/logout" class="btn btn-secondary">Sign Out</a>
			</sec:authorize>
		</div>
	
		<div class="card mt-4">
			<img src="/resources/img/cover.png" alt="Cover Image" />
		</div>

	</div>
	

</body>
</html>