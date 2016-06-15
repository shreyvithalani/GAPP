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
<title>Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel = "stylesheet">
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Welcome Admin</h2>
<div class="container"> 
<p align="right"><a href="./logout.html">Logout</a></p>          
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Department Name</th>
        <th>No of Programs Offered</th>
        <th>View</th>
        <th>Program</th>
        <th>Additional</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${dept}" var="department">
      <tr>
        <td>${department.dept_name}</td>
        <td>${department.programs.size()}</td>
        <td><a href="view.html?id=${department.id}">View</a></td>
        <td><a href="program.html?id=${department.id}">AddProgram</a></td>
        <td><a href="additional.html?id=${department.id}">Add-Additional</a></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  
  <p><a href="department.html">Add A Department</a></p>
</div>
</body>
</html>