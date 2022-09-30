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

	<c:import url="/jsp/include/navbar.jsp"></c:import>

	<div class="container">
		
		<h3 class="my-4">Teacher Home</h3>
		
		<form class="row mb-4">
			<div class="col-auto">
				<input type="date" name="targetDate" class="form-control" value="${ targetDate }" />
			</div>
			
			<div class="col-auto">
				<button class="btn btn-outline-success" type="submit">
					<i class="bi bi-search"></i> Search
				</button>
			</div>
		</form>
		
		<div class="row g-3">
			<c:forEach items="${ list }" var="item">
			
				<div class="col-4">
					<div class="card">
						<div class="card-body">
							
							<h4>${ item.teacher }</h4>
							<div class="text-secondary">${ item.details }</div>
							<span class="text-secondary">${ item.startDate }</span>
							
							<div class="row mt-4">
								<div class="col-4">
									<h5><i class="bi bi-people"></i> ${ item.students }</h5>
									<span class="text-secondary">Students</span>
								</div>
								<div class="col">
									<h5><i class="bi bi-people-fill"></i> ${ item.leaves }</h5>
									<span class="text-secondary">Leaves</span>
								</div>
							</div>
							
							<div class="row mt-4">
								<div class="col">
									<c:url var="details" value="/classes/${ item.classId }"></c:url>
									<a href="${ details }" class="btn btn-outline-success"><i class="bi bi-send"></i> Show Details</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>