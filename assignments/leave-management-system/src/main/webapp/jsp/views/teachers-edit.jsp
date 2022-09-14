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
		<c:param name="view" value="teachers"></c:param>
	</c:import>


	<div class="container">
	
		<h3 class="my-4">${ empty param.id ? 'Add New' : 'Edit' } Teacher</h3>
		
		<div class="row">
			<c:url value="/teachers" var="save"></c:url>
			<sf:form method="post" action="${ save }" modelAttribute="form" cssClass="col-lg-6 col-md-9 col-sm-12" >
				
				<sf:hidden path="id" />
				
				<div class="mb-3">
					<label class="form-label">Name</label>
					<sf:input path="name" placeholder="Enter Teacher Name" cssClass="form-control"/>
					<sf:errors path="name" cssClass="text-secondary"></sf:errors>
				</div>
			
				<div class="mb-3">
					<label class="form-label">Phone</label>
					<sf:input type="tel" path="phone" placeholder="Enter Phone Number" cssClass="form-control"/>
					<sf:errors path="phone" cssClass="text-secondary"></sf:errors>
				</div>
				
				<div class="mb-3 ${ empty param.id ? '' : 'd-none'}">
					<label class="form-label">Email</label>
					<sf:input type="email" path="email" placeholder="Enter Email Address" cssClass="form-control"/>
					<sf:errors path="email" cssClass="text-secondary"></sf:errors>
				</div>

				<div class="mb-3">
					<label class="form-label">Assign Date</label>
					<sf:input path="assignDate" type="date" cssClass="form-control"/>
					<sf:errors path="assignDate" cssClass="text-secondary"></sf:errors>
				</div>
				
				<div>
					<button class="btn btn-outline-danger" type="submit">
						<i class="bi bi-save"></i> Save
					</button>
				</div>
			</sf:form>
		
		</div>
		
	</div>

</body>
</html>