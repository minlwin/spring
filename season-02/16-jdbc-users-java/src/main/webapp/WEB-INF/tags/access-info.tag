<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ attribute name="list" required="true" type="java.util.List" %>

<div class="card mt-4">
	<h5 class="card-header">Access Log</h5>
	
	<div class="card-body">
		
		<table class="table table-striped">
			
			<thead>
				<tr>
					<th>ID</th>
					<th>Login ID</th>
					<th>User Name</th>
					<th>Access Type</th>
					<th>Access At</th>
				</tr>
			</thead>
			
			<tbody>
				
				<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.id}</td>
					<td>${dto.loginId}</td>
					<td>${dto.userName}</td>
					<td>${dto.type}</td>
					<td>
						<app:dateTime value="${dto.accessTime}"></app:dateTime>
					</td>
				</tr>
				</c:forEach>
			
			</tbody>
		
		
		</table>
	
	</div>
</div>