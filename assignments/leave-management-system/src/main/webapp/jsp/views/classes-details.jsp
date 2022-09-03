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

</head>
<body>

	<c:import url="/jsp/include/navbar.jsp">
		<c:param name="view" value="classes"></c:param>
	</c:import>
	
	<div class="container">
	
		<h3 class="my-4">Class Details</h3>
	
		<div class="card mb-4">
			
			<div class="card-header">Class Information</div>
			
			<div class="card-body row mb-2">
				
				<div class="col">
					<label class="form-label">Teacher</label>
					<span class="form-control">Thidar</span>
				</div>
				
				<div class="col">
					<label class="form-label">Start Date</label>
					<span class="form-control">2022-10-01</span>
				</div>

				<div class="col">
					<label class="form-label">Durations</label>
					<span class="form-control">3 Months</span>
				</div>

				<div class="col">
					<label class="form-label">Description</label>
					<span class="form-control">One Stop Batch 4</span>
				</div>

			</div>
			
		
		</div>
		
		<div class="d-flex justify-content-between mb-4">
			<ul class="nav nav-pills">
				
				<li class="nav-item">
					<button class="nav-link active" data-bs-toggle="pill" data-bs-target="#registrations">Registrations</button>
				</li>
				
				<li class="nav-item">
					<button class="nav-link" data-bs-toggle="pill" data-bs-target="#leaves">Leave Applications</button>
				</li>
				
			</ul>	
			
			<div>
			
				<c:url var="editClass" value="/classes/edit">
					<c:param name="id" value="1" />
				</c:url>
			
				<a href="${ editClass }" class="btn btn-outline-danger">
					Edit Class
				</a>	
			
				<c:url var="addRegistration" value="/classes/registration">
					<c:param name="classId" value="1" />
				</c:url>

				<a href="${ addRegistration }" class="btn btn-outline-primary">
					Add New Registration
				</a>								
			</div>			
		</div>
		
		<div class="tab-content" id="contents">
		
			<div class="tab-pane fade show active" id="registrations">
				<!-- Class Registration -->
				<c:import url="/jsp/include/class-registration.jsp"></c:import>
			</div>
			
			<div class="tab-pane fade" id="leaves">
				<!-- Class Leaves -->
				<c:import url="/jsp/include/class-leaves.jsp"></c:import>
			</div>
		
		</div>
		
		
	
	</div>

</body>
</html>