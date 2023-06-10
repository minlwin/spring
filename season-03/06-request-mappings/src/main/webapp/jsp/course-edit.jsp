<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Course</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container pt-4">
		
		<h1>${ empty course  or course.id eq 0 ? 'Add New' : 'Edit'} Course</h1>
	
		<div class="row">
			
			<div class="col-6">
				
				<c:url value="/course" var="saveUrl"></c:url>
				
				<form method="post" action="${saveUrl}">
					
					<c:if test="${not empty course}">
						<input type="hidden" name="id" value="${course.id}" />
					</c:if>
					
					<div class="mb-3">
						<label class="form-label mb-1" for="name">Course Name</label>
						<input id="name" name="name" value="${course.name}" type="text" placeholder="Enter Course Name" class="form-control" />
					</div>
				
					<div class="mb-3">
						<label class="form-label mb-1" for="level">Level</label>
						<select name="level" id="level" class="form-select">
							<option value="">Select One</option>
							
							<c:forEach var="item" items="${levels}">
							
								<c:choose>
									<c:when test="${course.level eq item}">
										<option selected="selected" value="${item}">${item}</option>
									</c:when>
									
									<c:otherwise>
											<option value="${item}">${item}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>

					<div class="mb-3">
						<label class="form-label mb-1" for="duration">Duration</label>
						<input id="duration" value="${course.duration}" name="duration" type="number" placeholder="Enter Course Duration" class="form-control" />
					</div>

					<div class="mb-3">
						<label class="form-label mb-1" for="fees">Course Fees</label>
						<input id="fees" value="${course.fees}" name="fees" type="number" placeholder="Enter Course Feess" class="form-control" />
					</div>
					
					<div>
						<button type="submit" class="btn btn-danger">Save Course</button>
					</div>
				</form>
			
			
			</div>
		
		</div>
	
	</div>



</body>
</html>