<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE = edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>Student</title>
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
	<h2>Welcome Student</h2>
	<div class="container">
		<p align="right">
			<a href="./logout.html">Logout</a>
		</p>
		<p align="left">
			<a href="student.html">Student home</a>
		</p>
		<hr>
		<div class="col-md-12">
			<div class="col-md-12">
				<h3 class="col-md-6">Basic Information</h3>
				<c:if
					test="${application.applicationstatus[0].status != 'Submitted'}">
					<p class="col-md-3" style="padding-top: 25px;">
						<a href="editbasicinfo.html?id=${application.id}">Edit basic
							info</a>
					</p>
				</c:if>
			</div>
			<div class="col-md-9">


				<ul>
					<li>Firstname - &nbsp;${application.firstname }</li>
					<li>Lastname - &nbsp;${application.lastname }</li>
					<li>CIN - &nbsp;${application.CIN }</li>
					<li>phone - &nbsp;${application.phone }</li>
					<li>gender - &nbsp;${application.gender }</li>
					<li>citizenship - &nbsp;${application.citizenship }</li>
					<li>email - &nbsp;${application.email }</li>
					<li>date of birth - &nbsp;<fmt:formatDate type="date"
							pattern="yyyy" value="${application.dob}" /></li>
				</ul>
			</div>
		</div>
		<hr>
		<div class="col-md-12">
			<div class="col-md-12">
				<h3 class="col-md-6">Application Details</h3>
				<c:if
					test="${application.applicationstatus[0].status != 'Submitted'}">
					<p class="col-md-3" style="padding-top: 25px;">
						<a href="editdetails.html?id=${application.id}">Edit Details</a>
					</p>
				</c:if>
			</div>
			<div class="col-md-9">
				<ul>
					<li>Department name -
						&nbsp;${application.department.dept_name}</li>
					<li>Program applied - &nbsp;${application.program.program}</li>
					<li>Term applied - &nbsp;${application.term}</li>
				</ul>
			</div>
		</div>
		<hr>
		<div class="col-md-12">
			<div class="col-md-12">

				<h3 class="col-md-6">Educational Background</h3>
				<p class="col-md-3" style="padding-top: 25px;">
					<a href="editedu.html?id=${application.id}">Add educational
						background</a>
				</p>
			</div>
			<div class="col-md-9">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Degree</th>
							<th>University name</th>
							<th>Major</th>
							<th>Starting year</th>
							<th>Ending year</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${application.degrees}" var="deg">
							<tr>
								<td>${deg.degree}</td>
								<td>${deg.univname}</td>
								<td>${deg.major}</td>
								<td><fmt:formatDate type="date" pattern="yyyy"
										value="${deg.start_year}" /></td>
								<td><fmt:formatDate type="date" pattern="yyyy"
										value="${deg.end_year}" /></td>
								<td><a
									href="removedegree.html?id=${deg.id}&id2=${application.id}">Remove
										degree </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<hr>
		<div class="col-md-12">
			<div class="col-md-12">
				<h3 class="col-md-6">Academic Records</h3>
				<c:if
					test="${application.applicationstatus[0].status != 'Submitted'}">
					<p class="col-md-3" style="padding-top: 25px;">
						<a href="editacademic.html?id=${application.id}">Edit Academic
							records</a>
					</p>
				</c:if>
				<c:if
					test="${application.applicationstatus[0].status != 'Submitted'}">
					<p class="col-md-6" style="padding-top: 25px;">
						<a href="upload.html?id=${application.id}">Upload</a>
					</p>
				</c:if>
			</div>
			<div class="col-md-9">


				<ul>
					<li>ToeflScore -
						&nbsp;${application.academicrecords.toeflscore }</li>
					<li>GreScore - &nbsp;${application.academicrecords.grescore }</li>
					<li>GPA - &nbsp;${application.academicrecords.gpa }</li>
					<c:if test="${application.academicrecords.transcript != null}">
						<li><a href="download.html?id=${application.id}">Download
								transcript file</a></li>
					</c:if>
				</ul>
			</div>
			</div>
			<div class="col-md-12">
			<div class="col-md-12">
			<h3>Additional Requirements</h3>
			<ul>
					<c:forEach items="${application.values}" var="value">
					
						<c:choose>
							<c:when test="${value.additional.type == 'file'}">
								<li>
								Requirement Name: &nbsp;${value.additional.name}= &nbsp;<br/>
								<a href="adddownload.html?id=${value.id}">Download
										</a></li>
							</c:when>
							<c:otherwise>
								<li>Requirement Name: &nbsp;${value.additional.name}= &nbsp;<br/>
								Value: &nbsp; ${value.value}</li>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>

				</ul>
		</div></div>
		<div class="controls">
			<c:if
				test="${application.applicationstatus[0].status != 'Submitted'}">
				<a href="submitapp.html"><button class="btn pull-right"
						class="btn btn-success" name="submit" value="submit">Submit
						Application</button></a>
			</c:if>
		</div>
	</div>
</body>
</html>