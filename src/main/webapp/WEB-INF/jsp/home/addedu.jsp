<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h2><a href="educationalbackground.html">Add educational background</a></h2>     
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
    <c:forEach items="${degrees}" var="deg">
      <tr>
        <td>${deg.degree}</td>
        <td>${deg.univname}</td>
        <td>${deg.major}</td>
        <td><fmt:formatDate type="date" pattern="yyyy" value="${deg.start_year}"/></td>
        <td><fmt:formatDate type="date" pattern="yyyy" value="${deg.end_year}"/></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
<a href ="add.html"><button class="btn btn-success" type="submit">Go to next part</button></a>
</div>
</body>
</html>