<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leaves | Home</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

</head>
<body>

	<c:import url="/jsp/include/navbar.jsp">
		<c:param name="view" value="classes"></c:param>
	</c:import>

	<div class="container">
		
		<h3 class="my-4">Registration Details</h3>
		
		<div class="row">
			
			<div class="col">
				
				<div class="card">
					
					<div class="card-header">
						Student Information
					</div>
					
					<div class="card-body">
						
						<div class="mb-3">
							<label class="form-label">Student Name</label>
							<span class="form-control">Aung Aung</span>
						</div>
					
						<div class="mb-3">
							<label class="form-label">Phone</label>
							<span class="form-control">09887778887</span>
						</div>

						<div class="mb-3">
							<label class="form-label">Email</label>
							<span class="form-control">aung@gmail.com</span>
						</div>
						
						<div class="mb-3">
							<label class="form-label">Education</label>
							<span class="form-control">College</span>
						</div>
						
					</div>
				
				</div>
			
			</div>

			<div class="col">
				
				<div class="card">
					
					<div class="card-header">
						Class Information
					</div>
					
					<div class="card-body">
					
						<div class="mb-3">
							<label class="form-label">Teacher</label>
							<span class="form-control">Min Lwin</span>
						</div>

						<div class="mb-3">
							<label class="form-label">Start Date</label>
							<span class="form-control">2022-10-03</span>
						</div>

						<div class="mb-3">
							<label class="form-label">Duration</label>
							<span class="form-control">6 Months</span>
						</div>

						<div class="mb-3">
							<label class="form-label">Description</label>
							<span class="form-control">One Stop Java</span>
						</div>
					
					</div>
				
				</div>
			
			</div>
		

		</div>
		
		<div class="mt-4">
		
			<c:url var="edit" value="/classes/registration">
				<c:param name="registId" value="1"></c:param>
			</c:url>
			
			<a href="${ edit }" class="btn btn-outline-danger">
				<i class="bi bi-pencil"></i> Edit Registration
			</a>
		</div>
	
	</div>
</body>
</html>