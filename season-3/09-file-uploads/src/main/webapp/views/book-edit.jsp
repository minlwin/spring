<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
		
		<div class="row">
			<div class="col-9">
				<div class="card">
					<div class="card-header">${ book.id eq 0 ? 'Add New' : 'Edit' } Book</div>
					
			
					<form:form action="/book" cssClass="card-body" modelAttribute="book">
					
						<form:hidden path="id"/>
						
						<div class="row mb-4">
						
							<div class="col">
								<label>Category</label>
								<form:select path="category" cssClass="form-select">
									<option value="">Select One</option>
									<form:options items="${categories}" itemValue="id" itemLabel="name"/> 
								</form:select>
								<form:errors path="category" cssClass="text-secondary"></form:errors>
							</div>
							<div class="col">
								<label>Book Title</label>
								<form:input path="title" cssClass="form-control" placeholder="Enter Book Title" />
								<form:errors path="title" cssClass="text-secondary"></form:errors>
							</div>
						
							<div class="col">
								<label>Author</label>
								<form:input path="author" cssClass="form-control" placeholder="Enter Book Title" />
								<form:errors path="author" cssClass="text-secondary"></form:errors>
							</div>
						</div>
						
						<div class="row mb-4">
							
							<div class="col-4">
								<label>Price</label>
								<form:input path="price" type="number" cssClass="form-control" placeholder="Enter Price"/>
								<form:errors path="price" cssClass="text-secondary"></form:errors>
							</div>
						
							<div class="col">
								<label>Remark</label>
								<form:input path="remark" cssClass="form-control" placeholder="Enter Remark"/>
							</div>
						</div>
						
						<div class="row">
							<div class="col">
								<button class="btn btn-primary">Save Book</button>
							</div>
						</div>
					
					</form:form>
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