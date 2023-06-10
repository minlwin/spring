<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Demo</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

</head>
<body>

	<div class="container pt-4">

		
		<div class="card">
			
			<h3 class="card-header">Using Session</h3>
			
			<div class="card-body">
				
				<div class="row">
				
					<c:url value="/add-item" var="action"></c:url>
					<form method="post" class="row" action="${action}">
						
						<div class="col-7">
							<input type="text" name="data" placeholder="Item Name" class="form-control" />
						</div>
						
						<div class="col-auto">
							<button type="submit" class="btn btn-primary mr-4">Add Item</button>
							
							<c:url value="/clear-session" var="clearCart"></c:url>
							<a href="${clearCart}" class="btn btn-danger">Clear Items</a>
						</div>
					
					</form>
				
				</div>
			
			</div>
			
		</div>		
		
		<div class="mt-4 list-group">
		
			<div class="list-group-item active">
				Items in Cart : ${sessionScope.cart.count}
			</div>
			
			<c:forEach var="item" items="${sessionScope.cart.list}">
				<div class="list-group-item">
					${item}
				</div>			
			</c:forEach>
		</div>
	
	</div>




</body>
</html>