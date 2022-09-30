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
		<c:param name="view" value="leaves"></c:param>
	</c:import>

	<div class="container">
		
		<h3 class="my-4">Leave Application</h3>

		<div class="row">
			<c:url value="/leaves" var="action"></c:url>
			<sf:form method="post" action="${ action }" modelAttribute="form" cssClass="col-6">
			
				<sf:hidden path="classId"/>
				<sf:hidden path="student"/>
				<sf:hidden path="applyDate"/>
				
				<div class="mb-3">
					<label class="form-label">Class</label>
					<span class="form-control">
						${ classInfo.description } (${ classInfo.startDate })
					</span>
				</div>
			
				<div class="mb-3">
					<label class="form-label">Teacher</label>
					<span class="form-control">
						${ classInfo.teacherName }
					</span>
				</div>

				<div class="mb-3">
					<label class="form-label">Student</label>
					<span class="form-control">
						${ studentInfo.name }
					</span>
				</div>

				<div class="mb-3 row">
					<div class="col-8">
						<label class="form-label">Leave Start Date</label>
						<sf:input path="startDate" type="date" placeholder="Enter Student Name" cssClass="form-control" />
						<sf:errors path="startDate" cssClass="text-secondary"></sf:errors>
					</div>
					<div class="col">
						<label class="form-label">Leave Days</label>
						<sf:input path="days" type="number" placeholder="Enter Student Name" cssClass="form-control" />
						<sf:errors path="days" cssClass="text-secondary"></sf:errors>
					</div>
				</div>

				<div class="mb-3">
					<label class="form-label">Reason</label>
					<sf:textarea path="reason" placeholder="Enter Reason of Leaves" cssClass="form-control" />
					<sf:errors path="reason" cssClass="text-secondary"></sf:errors>
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