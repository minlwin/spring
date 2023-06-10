<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
	<sp:message code="app.title"></sp:message>
</title>

<c:url value="/resources/css/bootstrap.min.css" var="bootStrapCss"></c:url>
<c:url value="/resources/js/bootstrap.bundle.min.js" var="bootStrapJs"></c:url>

<script type="text/javascript" src="${bootStrapJs}"></script>
<link rel="stylesheet" href="${bootStrapCss}" />

</head>
<body>

	<div class="container">
	
		<h1 class="mt-4 mb-4">
			<sp:message code="app.title"></sp:message>
		</h1>
		
		<c:url value="/views/imports/upload-result.jsp" var="uploadMessageJsp"></c:url>
		<c:import url="${uploadMessageJsp}"></c:import>

		
		<div class="row">
			
			<div class="col-9">
				
				<div class="card">

					<div class="card-header">Book List</div>

					<div class="card-body">
						<table class="table table-striped">
							
							<thead>
								
								<tr>
									<th>ID</th>
									<th>Title</th>
									<th>Author</th>
									<th>Category</th>
									<th>Price</th>
									<th>Remarks</th>
								</tr>
							
							</thead>
							
							<tbody>
							
							<c:forEach var="book" items="${ list }">
								<tr>
									 <td>${ book.id }</td>
									 <td>
									 	<c:url value="/book/edit" var="editLink">
									 		<c:param name="id" value="${ book.id }"></c:param>
									 	</c:url>
									 	<a href="${ editLink }">${ book.title }</a>
									 </td>
									 <td>${ book.author }</td>
									 <td>${ book.category.name }</td>
									 <td>${ book.price }</td>
									 <td>${ book.remark }</td>
								</tr>
							
							</c:forEach>	
							
							
							</tbody>
						
						</table>
					
					</div>
				</div>
							
			</div>
			

			<div class="col">
				<c:url value="/views/imports/left-bar.jsp" var="importJsp"></c:url>
				<c:import url="${importJsp}"></c:import>
			</div>
		
		</div>
	
	</div>

</body>
</html>