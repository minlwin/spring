<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>    
<div class="card">
	<div class="card-header">Book Search</div>
	
	<c:url value="/book" var="searchUrl"></c:url>
	<form action="${ searchUrl }" class="card-body">
	
		<div class="mb-4">
			<label class="form-label" for="category">Category</label>
			<select id="category" name="category" class="form-select">
				<option value="">Search Category</option>
			</select>
		</div>
		
		<div class="mb-4">
			<label class="form-label" for="keyword">Keyword</label>
			<input type="text" class="form-control" name="keyword" id="keyword" placeholder="Search Keyword" />
		</div>		
		
		<c:url value="/book/edit" var="editUrl"></c:url>

		<div class="d-grid gap-2">
			
			<button class="btn btn-secondary">Search</button>
			
			<a href="#" class="btn btn-primary">Upload</a>
			
			<a href="${editUrl}" class="btn btn-danger">Add New</a>
		</div>
		
	</form>
</div>