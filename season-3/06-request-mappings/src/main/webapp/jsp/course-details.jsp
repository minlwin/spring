<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Details</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container pt-4">
		
		<h1>Course Details</h1>
	
		<div class="row">
			
			<div class="col-6">
				
				<c:url value="/course" var="saveUrl"></c:url>
				
				<form method="post" action="${saveUrl}">
					
					<div class="mb-3">
						<label class="form-label mb-1" for="id">Course Id</label>
						<input id="id" name="id" type="text" value="${course.id}" readonly="readonly" class="form-control" />
					</div>

					<div class="mb-3">
						<label class="form-label mb-1" for="name">Course Name</label>
						<input id="name" name="name" type="text" value="${course.name}" readonly="readonly" class="form-control" />
					</div>
				
					<div class="mb-3">
						<label class="form-label mb-1" for="level">Course Level</label>
						<input id="level" name="level" type="text" value="${course.level}" readonly="readonly" class="form-control" />
					</div>

					<div class="mb-3">
						<label class="form-label mb-1" for="duration">Duration</label>
						<input id="duration" name="duration" type="number" value="${course.duration}" readonly="readonly" class="form-control" />
					</div>

					<div class="mb-3">
						<label class="form-label mb-1" for="fees">Course Fees</label>
						<input id="fees" name="fees" type="number" value="${course.fees}" readonly="readonly" class="form-control" />
					</div>
					
				</form>
			
			
			</div>
		
		</div>
	
	</div>



</body>
</html>