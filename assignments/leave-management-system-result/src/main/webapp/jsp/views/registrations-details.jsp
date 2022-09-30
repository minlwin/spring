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
							<span class="form-control">${ dto.student.name }</span>
						</div>
					
						<div class="mb-3">
							<label class="form-label">Phone</label>
							<span class="form-control">${ dto.student.phone }</span>
						</div>

						<div class="mb-3">
							<label class="form-label">Email</label>
							<span class="form-control">${ dto.student.email }</span>
						</div>
						
						<div class="mb-3">
							<label class="form-label">Registration Date</label>
							<span class="form-control">${ dto.registDate }</span>
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
							<span class="form-control">${ dto.classInfo.teacherName }</span>
						</div>

						<div class="mb-3">
							<label class="form-label">Start Date</label>
							<span class="form-control">${ dto.classInfo.startDate }</span>
						</div>

						<div class="mb-3">
							<label class="form-label">Duration</label>
							<span class="form-control">${ dto.classInfo.months } Months</span>
						</div>

						<div class="mb-3">
							<label class="form-label">Description</label>
							<span class="form-control">${ dto.classInfo.description }</span>
						</div>
					
					</div>
				
				</div>
			
			</div>
		

		</div>
		
		<div class="mt-4">
		
			<c:url var="classDetails" value="/classes/${ dto.classInfo.id }"></c:url>
			
			<a href="${ classDetails }" class="btn btn-outline-primary me-2">
				<i class="bi bi-mortarboard"></i> Class Details
			</a>

			<c:url var="edit" value="/classes/registration">
				<c:param name="classId" value="${ dto.classInfo.id }"></c:param>
				<c:param name="studentId" value="${ dto.student.id }"></c:param>
				<c:param name="teacherName" value="${ dto.classInfo.teacherName }"></c:param>
				<c:param name="startDate" value="${ dto.classInfo.startDate }"></c:param>
			</c:url>
			
			<a href="${ edit }" class="btn btn-outline-danger">
				<i class="bi bi-pencil"></i> Edit Registration
			</a>
			
		</div>
	
	</div>
</body>
</html>