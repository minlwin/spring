<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:url var="home" value="/home" />
<c:url var="teachers" value="/teachers" />
<c:url var="classes" value="/classes" />
<c:url var="students" value="/students" />
<c:url var="leaves" value="/leaves" />
<c:url var="signout" value="/signout" />
    
<nav class="navbar navbar-expand-lg bg-success navbar-dark ">

	<div class="container">
		<a href="${ home }" class="navbar-brand">Leave Management System</a>

		<ul class="navbar-nav">
			<li class="nav-item">
				<a href="${ teachers }" class="nav-link ${ param.view eq 'teachers' ? 'active' : '' }">Teachers</a>
			</li>
			<li class="nav-item">
				<a href="${ classes }" class="nav-link ${ param.view eq 'classes' ? 'active' : '' }">Classes</a>
			</li>
			<li class="nav-item">
				<a href="${ students }" class="nav-link ${ param.view eq 'students' ? 'active' : '' }">Students</a>
			</li>
			<li class="nav-item">
				<a href="${ leaves }" class="nav-link ${ param.view eq 'leaves' ? 'active' : '' }">Leaves</a>
			</li>
			<li class="nav-item">
				<a href="${ signout }" class="nav-link">Sign Out</a>
			</li>
		</ul>

	</div>
	
</nav>
   