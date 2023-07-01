<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security Demo</title>

<link rel="stylesheet" href="../resources/css/bootstrap.min.css" />
<script src="../resources/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<div class="container mt-4">
		
		<h1>Customer Home</h1>
		
		<p>${loginUser}</p>
		
		<div>
			<ul>
			<c:forEach items="${authorities}" var="authority">
				<li>${authority}</li>
			</c:forEach>	
			</ul>
		</div>
		
		<div>
			<a href="/" class="btn btn-primary">Public Home</a>
			<sf:form class="d-inline-block" action="/logout" method="post">
				<button type="submit" class="btn btn-danger">Logout</button>
			</sf:form>
		</div>
		
		<div class="mt-4">
			<h4>My Addresses</h4>
			
			<c:choose>
				<c:when test="${not empty addresses}">
				
				<table class="table table-strpied">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Building</th>
							<th>Street</th>
							<th>Township</th>
							<th>Division</th>
						</tr>
					</thead>
					
					<tbody>
					
						<c:forEach items="${addresses}" var="dto">
						<tr>
							<td>${dto.id}</td>
							<td>${dto.name}</td>
							<td>${dto.building}</td>
							<td>${dto.street}</td>
							<td>${dto.township}</td>
							<td>${dto.division}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</c:when>
				
				<c:otherwise>
					<div class="alert alert-info">There is no data.</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

</body>
</html>