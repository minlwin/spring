<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<table class="table table-hover">
	
	<thead>
		<tr>
			<th>Registration Date</th>
			<th>Student</th>
			<th>Phone</th>
			<th></th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${ dto.registrations }" var="item">
			<tr>
				<td>${ item.registrationDate }</td>
				<td>${ item.student }</td>
				<td>${ item.studentPhone }</td>
				<td>
					<c:url var="edit" value="/classes/registration">
						<c:param name="classId" value="${ item.classId }"></c:param>
						<c:param name="studentId" value="${ item.studentId }"></c:param>
						<c:param name="teacherName" value="${ item.teacher }"></c:param>
						<c:param name="startDate" value="${ item.startDate }"></c:param>
					</c:url>
					<a href="${ edit }">
						<i class="bi bi-pencil me-2"></i>
					</a>			
	
					<c:url var="details" value="/classes/registration/${ item.classId }/${ item.studentId }"></c:url>
					<a href="${ details }">
						<i class="bi bi-cursor"></i>
					</a>			
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>