<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>   
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security Demo</title>

<c:url value="/resources/css/bootstrap.min.css" var="bootCss"></c:url>
<link rel="stylesheet" href="${bootCss}" />
<c:url value="/resources/js/bootstrap.bundle.min.js" var="bootJs"></c:url>
<script src="${bootJs}"></script>

</head>
<body>

	<div class="container mt-4">
		
		<h1>${form.id == 0 ? 'Add New' : 'Edit'} Address</h1>
		
		<sf:form method="post" cssClass="w-75" modelAttribute="form">
			
			<sf:hidden path="id"/>
			<sf:hidden path="email"/>
			
			<app:formGroup label="Address Name">
				<sf:input path="name" cssClass="form-control" placeholder="Enter Address Name"/>
				<sf:errors path="name" cssClass="text-secondary"></sf:errors>
			</app:formGroup>
			
			<div class="row">
				<div class="col">
					<app:formGroup label="Building Address">
						<sf:input path="building" cssClass="form-control" placeholder="Enter Building Address"/>
						<sf:errors path="building" cssClass="text-secondary"></sf:errors>
					</app:formGroup>
				</div>
				<div class="col">
					<app:formGroup label="Street Address">
						<sf:input path="street" cssClass="form-control" placeholder="Enter Street Address"/>
						<sf:errors path="street" cssClass="text-secondary"></sf:errors>
					</app:formGroup>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<app:formGroup label="Township Name">
						<sf:input path="township" cssClass="form-control" placeholder="Enter Township Name"/>
						<sf:errors path="township" cssClass="text-secondary"></sf:errors>
					</app:formGroup>
				</div>
				<div class="col">
					<app:formGroup label="Division Name">
						<sf:input path="division" cssClass="form-control" placeholder="Enter Division Name"/>
						<sf:errors path="division" cssClass="text-secondary"></sf:errors>
					</app:formGroup>
				</div>
			</div>
			
			<div class="mb-4">
				<button type="submit" class="btn btn-primary">Save Address</button>
			</div>

		</sf:form>
				
		
		<div>
			
			<a href="/" class="btn btn-primary">Public Home</a>
			
			<sf:form class="d-inline-block" action="/logout" method="post">
				<button type="submit" class="btn btn-danger">Logout</button>
			</sf:form>
		</div>
	</div>

</body>
</html>