<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container pt-4">
	
		<div class="row">
			
			<div class="col-5">
				
				<h3>Member Sign Up</h3>
				
				<sf:form action="/signup" modelAttribute="dto">
					<div class="mb-3">
						<label for="name">Name</label>
						<sf:input path="name" placeholder="Enter Name" class="form-control"/>
						<sf:errors path="name" ></sf:errors>
					</div>

					<div class="mb-3">
						<label for="loginId">Login Id</label>
						<sf:input path="loginId" placeholder="Enter Login Id" class="form-control"/>
						<sf:errors path="loginId"></sf:errors>
					</div>
					
					<div class="mb-3">
						<label for="password">Password</label>
						<sf:password path="password" placeholder="Enter Password" class="form-control" />
						<sf:errors path="password"></sf:errors>
					</div>
					
					<div>
						
						<button type="submit" class="btn btn-primary">Sign Up</button>
						
						<a href="/" class="btn btn-secondary">Home</a>
					
					</div>				
				</sf:form>

				
			</div>
		
		</div>
		
	</div>

</body>
</html>