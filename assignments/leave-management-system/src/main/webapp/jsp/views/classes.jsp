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
		<c:param name="view" value="classes"></c:param>
	</c:import>
	
	<div class="container">
		
		<h3 class="my-4">
			Classes Management
		</h3>
		
		<form class="row mb-4">
			
			<div class="col-auto">
				<label class="form-label">Name</label>
				<input type="text" name="teacher" placeholder="Search Teacher Name" class="form-control" />
			</div>
		
			<div class="col-auto">
				<label class="form-label">Date From</label>
				<input type="date" name="from" class="form-control" />
			</div>

			<div class="col-auto">
				<label class="form-label">Date To</label>
				<input type="date" name="to" class="form-control" />
			</div>
			
			<div class="col btn-wrapper">
				<button class="btn btn-outline-success me-2">Search</button>
				<c:url var="addNew" value="/classes/edit"></c:url>
				<a href="${ addNew }" class="btn btn-outline-danger">Add New</a>
			</div>

		</form>
		
		<table class="table table-hover">
		
			<thead>
				<tr>
					<th>Id</th>
					<th>Teacher</th>
					<th>Teacher Phone</th>
					<th>Start Date</th>
					<th>Months</th>
					<th>Students</th>
					<th>Description</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			
				<tr>
					<td>1</td>
					<td>Min Lwin</td>
					<td>09782003098</td>
					<td>2022-10-03</td>
					<td>6</td>
					<td>43</td>
					<td>One Stop Java Class</td>
					<td>
						<c:url var="edit" value="/classes/edit">
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