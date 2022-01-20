<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security | Member</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container pt-4">
	
		<h3>Member Home</h3>
		
		<div>
			<a href="/" class="btn btn-primary">Home</a>
			<a href="/logout" class="btn btn-secondary">Sign Out</a>
		</div>
		
		<app:access-info list="${accessList}"></app:access-info>
		
	</div>

</body>
</html>