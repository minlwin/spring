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

<c:url var="commonCss" value="/resources/application.css"></c:url>
<link rel="stylesheet" href="${commonCss}" />

</head>
<body>

	<c:import url="/jsp/include/navbar.jsp">
		<c:param name="view" value="teachers"></c:param>
	</c:import>
	
	<div class="container">
	
		<h3 class="my-4">Teachers Management</h3>
		
		<!-- Search Bar -->
		<form class="row mb-4">
			<div class="col-auto">
				<label class="form-label">Name</label>
				<input type="text" name="name" class="form-control" placeholder="Search Name" />
			</div>
			<div class="col-auto">
				<label class="form-label">Phone</label>
				<input type="tel" name="phone" class="form-control" placeholder="Search Phone" />
			</div>
			<div class="col-auto">
				<label class="form-label">Email</label>
				<input type="email" name="email" class="form-control" placeholder="Search Email" />
			</div>
			
			<div class="col btn-wrapper">
				<button class="btn btn-outline-success me-2">Search</button>
				
				<c:url var="addNew" value="/teachers/edit"></c:url>
				<a href="${ addNew }" class="btn btn-outline-danger">Add new</a>
			</div>
		</form>
		
		<!-- Table View -->
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Assign Date</th>
					<th>Classes</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td>1</td>
					<td>Min Lwin</td>
					<td>09782003098</td>
					<td>lwin.zawmin@gmail.com</td>
					<td>2022-09-01</td>
					<td>5</td>
					<td>
						<c:url var="edit" value="/teachers/edit">
							<c:param name="id" value="1"></c:param>
						</c:url>
						<a href="${ edit }">Edit</a>
					</td>
				</tr>
			</tbody>
		</table>
		
	</div>

</body>
</html>