<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<table class="table table-hover">
	
	<thead>
		<tr>
			<th>Id</th>
			<th>Registration Date</th>
			<th>Student</th>
			<th>Phone</th>
			<th></th>
		</tr>
	</thead>
	
	<tbody>
	
		<tr>
			<td>1</td>
			<td>2022-10-01</td>
			<td>Aung Aung</td>
			<td>0987789999</td>
			<td>
				<c:url var="edit" value="/classes/registration">
					<c:param name="id" value="1"></c:param>
				</c:url>
				<a href="${ edit }">Edit</a>			
			</td>
		</tr>
	</tbody>
</table>