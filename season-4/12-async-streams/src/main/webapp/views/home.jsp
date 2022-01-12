<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Streams Response</title>
</head>
<body>

	<h1>Streams Response</h1>
	
	
	<ul id="output">
	
	</ul>
	
	<div>
		<button id="streamTrigger">Load Stream</button>
		<button id="sseTrigger">Connect SSE Source</button>
	</div>
	
	<c:url value="/resources/js/client.js" var="clientJS"></c:url>
	<script type="text/javascript" src="${clientJS}"></script>
</body>
</html>