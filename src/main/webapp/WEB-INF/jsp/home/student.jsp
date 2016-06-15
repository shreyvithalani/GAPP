<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset = "utf-8">
<meta http-equiv = "X-UA-Compatible" content = "IE = edge">
<meta name = "viewport" content = "width = device-width, initial-scale = 1">
<title>student</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel = "stylesheet">
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container"> 
<p align="right"><a href="./logout.html">Logout</a></p>     
<h2><a href="application.html">Create Application</a></h2>     
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Date of application</th>
        <th>Department</th>
        <th>Program</th>
        <th>Term</th>
        <th>Current status</th>
        <th>View Application</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${application}" var="app">
      <tr>
        <td>${app.dateofapp}</td>
        <td>${app.department.dept_name}</td>
        <td>${app.program.program}</td>
        <td>${app.term}</td>
        <td>${app.applicationstatus[0].status}</td>
        <td><a href="viewapp.html?id=${app.id}">View</a></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
 
</div>
</body>
</html>