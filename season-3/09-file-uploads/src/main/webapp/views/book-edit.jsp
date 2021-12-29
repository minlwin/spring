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
	
		<h1 class="mt-4">
			<sp:message code="app.title"></sp:message>
		</h1>
		
		<div class="card">
			<div class="card-header">Edit Book</div>
			
	
			<form:form cssClass="card-body"></form:form>
		</div>
		
	
	</div>



</body>
</html>