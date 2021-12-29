<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form</title>

<style type="text/css">
	
	.radios-box > span {
		margin-right: 16px;
	}
	
	.radios-box input {
		margin-right: 6px;
	}
	

</style>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container pt-4">
	
		<h3><sp:message code="app.title"></sp:message></h3>
		
		<c:if test="${ not empty allErrors }">
			
			<div class="alert alert-warning">
				
				<c:forEach var="e" items="${allErrors}" varStatus="sts">
					
					<span>${e}</span>
					
					<c:if test="${not sts.last}">
						<br/>
					</c:if>				
				</c:forEach>
			
			</div>
		
		</c:if>
		
		
		<sf:form modelAttribute="userInput">
							
			<sf:hidden path="id"/>
		
			<div class="row">
				<div class="col">
					<sf:label path="name">Student Name</sf:label>
					<sf:input path="name" cssClass="form-control" placeholder="Enter Student Name"/>
					<sf:errors path="name" cssClass="text-danger"></sf:errors>
				</div>
			
				<div class="col">
					<sf:label path="phone">Phone</sf:label>
					<sf:input type="tel" path="phone" cssClass="form-control" placeholder="Enter Phone Number"/>
					<sf:errors path="phone" cssClass="text-danger"></sf:errors>
				</div>
	
				<div class="col">
					<sf:label path="email">Email Address</sf:label>
					<sf:input type="email" path="email" cssClass="form-control" placeholder="Enter Email Address"/>
					<sf:errors path="email" cssClass="text-danger"></sf:errors>
				</div>
			
			</div>
			
			<div class="row mt-4">
				<div class="col">
					<sf:label path="password">Password</sf:label>
					<sf:password path="password" placeholder="Enter Password" cssClass="form-control"/>
				</div>

				<div class="col">
					<sf:label path="course">Select Course</sf:label>
					<sf:select path="course" cssClass="form-select">
						<sf:option value="">Select Course</sf:option>
						<sf:options items="${courses}" itemValue="id"  />
					</sf:select>
					<sf:errors path="course" cssClass="text-danger"></sf:errors>
				</div>

				<div class="col">
					<sf:label path="registration">Registration Date</sf:label>
					<sf:input path="registration" placeholder="Enter Registration Date" type="date" cssClass="form-control"/>
				</div>
				
			</div>
			
			<div class="row mt-4">
				
				<div class="col">
					<sf:label path="gender">Gender</sf:label>	
					<div class="radios-box">
						<sf:radiobuttons  path="gender" items="${genders}"/>
					</div>
				</div>
				
				<div class="col">
					<sf:label path="foundations">Knowledges</sf:label>
					<div class="radios-box">
						<sf:checkboxes items="${knowledges}" path="foundations"/>
					</div>
				</div>
				
				<div class="col">
					<sf:label path="agree">Agree Conditions</sf:label>
					<div class="radios-box">
						<sf:checkbox path="agree" label="Yes I Agree"/>
					</div>
				</div>
			
			</div>
			
			<div class="mt-4">
				
				<sf:label path="remark">Remark</sf:label>
				<sf:textarea path="remark" cssClass="form-control"/>
			
			</div>
			
			<div class="mt-4">
				<button type="submit" class="btn btn-primary">Send Data</button>
			</div>
		
		</sf:form>
		
		<h3 class="mt-4">Data List</h3>
		
		<table class="table">
			
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>				
					<th>Phone</th>				
					<th>Email</th>				
					<th>Gender</th>				
					<th>Registration</th>				
					<th>Course</th>				
					<th>Remark</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="d" items="${list}">
				
					<tr>
						<td>${d.id}</td>
						<td>${d.name}</td>
						<td>${d.phone}</td>
						<td>${d.email}</td>
						<td>${d.gender}</td>
						<td>${d.registration}</td>
						<td>${d.course.name}</td>
						<td>${d.remark}</td>
					</tr>
				
				</c:forEach>
			
			</tbody>
		
		</table>
	
	</div>

</body>
</html>