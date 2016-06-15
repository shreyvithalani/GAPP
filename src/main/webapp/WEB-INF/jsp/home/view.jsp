<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE = edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Welcome Admin</h2>

	<p>
		<a href="admin.html">Admin Home</a>
	</p>
	<div class="container">
	<p align="right"><a href="./logout.html">Logout</a></p>
		<h3>Welcome to ${department.dept_name} Department</h3>
		
		<p>
			<a href="editdepartment.html?id=${department.id}">Edit department
				name</a>
		</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Programs Offered</th>
					<th>Edit</th>
					<th>Remove</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${department.programs}" var="program">
					<tr>
						<td>${program.program}</td>

						<td><a href="editprogram.html?id=${program.id}&id2=${department.id}">Edit</a></td>
						<td><a href="removeprogram.html?id=${program.id}&id2=${department.id}">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Additional Requirements</th>
					<th>type</th>
					<th>Required</th>
					<th>Edit</th>
					<th>Remove</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${department.additional}" var="add">
					<tr>
						<td>${add.name}</td>
						<td>${add.type}</td>
						<td>${add.required}</td>
						<td><a href="editadditional.html?id=${add.id}&id2=${department.id}">Edit</a></td>
						<td><a href="removeadditional.html?id=${add.id}&id2=${department.id}">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody> 
		</table>


	</div>
</body>
</html>