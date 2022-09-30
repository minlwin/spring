<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<table class="table table-hover">
	
	<thead>
		<tr>
			<th>Student</th>
			<th>Phone</th>
			<th>Apply Date</th>
			<th>Leave Start</th>
			<th>Leave Days</th>
			<th>Reason</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${ dto.leaves }" var="item">
			<tr>
				<td>${ item.student }</td>
				<td>${ item.studentPhone }</td>
				<td>${ item.applyDate }</td>
				<td>${ item.startDate }</td>
				<td>${ item.days } Days</td>
				<td>${ item.reason }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>