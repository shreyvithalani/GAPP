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
<title>Department</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type='text/javascript'
  src='http://code.jquery.com/jquery-1.8.3.js'></script>
<script type='text/javascript'
  src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.1.0/bootstrap.min.js"></script>
<link href = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel = "stylesheet">
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<h3>Edit Department Name</h3>
<div class="container">
<p align="right"><a href="./logout.html">Logout</a></p>
    <div class="row">
		<div class="span12">
			<form:form modelAttribute="department" class="form-horizontal" >
			  <fieldset>
			    <div id="legend">
			     
			    </div>
			    <div class="control-group">
			      <!-- Username -->
			      <label class="control-label"  for="department">department</label>
			      <div class="controls">
			        <form:input type="text" path="Dept_name" id="Dept_name" name="Dept_name" placeholder="" class="input-xlarge" required="required" />
			      </div>
			    </div>
			    <br/>
			    <br/>
			    <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			        <button class="btn btn-success" type="submit">Edit Department</button>
			      </div>
			    </div>
			  </fieldset>
			</form:form>
		</div>
	</div>
	</div>
</body>
</html>