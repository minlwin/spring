<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authentication Events</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container mt-4">
		
		<h3>Access Logs</h3>
		
		<form class="row" action="#">
		
			<div class="col-auto">
				<label class="form-label">Date From</label>
				<input name="from" type="date" class="form-control"  />
			</div>

			<div class="col-auto">
				<label class="form-label">Date To</label>
				<input name="to" type="date" class="form-control"  />
			</div>
			
			<div class="col-auto">
				<label class="form-label">User Name</label>
				<input name="name" class="form-control" placeholder="Search Name"  />
			</div>
			
			<div class="col" style="padding-top: 2rem;">
				<button type="submit" class="btn btn-outline-primary">Search</button>
				<button type="button" class="btn btn-outline-secondary" id="logoutBtn">Logout</button>
			</div>
		</form>
		
		<sf:form action="/logout" method="post" class="d-none" id="logoutForm"></sf:form>
		
		<table class="table table-striped mt-4">
			<thead>
				<tr>
					<th>Access</th>
					<th>User Name</th>
					<th>Status</th>
					<th>Description</th>
				</tr>
			</thead>
		
		</table>
	</div>
	
	<script src="/resources/common.js"></script>
</body>
</html>