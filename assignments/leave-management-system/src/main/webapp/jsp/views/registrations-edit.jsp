<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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
	
		<h3 class="my-4">
			${ empty param.id ? 'Add New' : 'Edit'} Registration
		</h3>
		
		<div class="row">
		
			<sf:form method="post" modelAttribute="registForm" cssClass="col-6">
			
				<sf:hidden path="studentId"/>
				<sf:hidden path="classId"/>
				<sf:hidden path="registDate"/>
				
				<div class="mb-3">
					<label class="form-label">Start Date</label>
					<span class="form-control">
						2022-10-03
					</span>
				</div>
			
				<div class="mb-3">
					<label class="form-label">Teacher</label>
					<span class="form-control">
						Min Lwin
					</span>
				</div>

				<div class="mb-3">
					<label class="form-label">Student Name</label>
					<sf:input path="studentName" placeholder="Enter Student Name" cssClass="form-control" />
					<sf:errors path="studentName" cssClass="text-secondary"></sf:errors>
				</div>

				<div class="mb-3">
					<label class="form-label">Email</label>
					<sf:input path="email" type="email" placeholder="Enter Email Address" cssClass="form-control" />
					<sf:errors path="email" cssClass="text-secondary"></sf:errors>
				</div>

				<div class="mb-3">
					<label class="form-label">Phone</label>
					<sf:input path="email" type="email" placeholder="Enter Email Address" cssClass="form-control" />
					<sf:errors path="Phone" cssClass="text-secondary"></sf:errors>
				</div>

				<div class="mb-3">
					<label class="form-label">Last Education</label>
					<sf:input path="education" placeholder="Enter Last Education" cssClass="form-control" />
				</div>
				
				<div>
					<button class="btn btn-outline-danger">
						<i class="bi bi-save"></i> Save
					</button>
				</div>
			</sf:form>
			
		
		</div>
	
	</div>


</body>
</html>