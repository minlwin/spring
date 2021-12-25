<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope Demo</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

</head>
<body>

	<div class="container pt-4">

		<h1>Scope Demo</h1>

		<div class="row mt-4 mb-4">

			<div class="col">
				<div class="card">
					<div class="card-header">Request Scope</div>

					<div class="card-body">
						<h1 class="text-center">${requestCount}</h1>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card">
					<div class="card-header">Session Scope</div>

					<div class="card-body">
						<h1 class="text-center">${sessionCount}</h1>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card">
					<div class="card-header">Application Scope</div>

					<div class="card-body">
						<h1 class="text-center">${applicationCount}</h1>
					</div>
				</div>
			</div>
		</div>

		<h3>Access Scope Object</h3>

		<div class="row mb-4">

			<div class="col">
				<div class="card">
					<div class="card-header">Request Scope</div>

					<div class="card-body">
						<h1 class="text-center">${requestScope.counter.count}</h1>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card">
					<div class="card-header">Session Scope</div>

					<div class="card-body">
						<h1 class="text-center">${sessionScope.counter.count}</h1>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card">
					<div class="card-header">Application Scope</div>

					<div class="card-body">
						<h1 class="text-center">${applicationScope.counter.count}</h1>
					</div>
				</div>
			</div>
		</div>
		
		<div class="mb-4">
			<c:url value="/" var="home"></c:url>
			<a href="${home}" class="btn btn-primary">Load Home</a>

			<c:url value="/create-session" var="cart"></c:url>
			<a href="${cart}" class="btn btn-primary">Session Demo</a>
		</div>	
		
	
	</div>




</body>
</html>