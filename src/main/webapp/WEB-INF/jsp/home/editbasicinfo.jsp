<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset = "utf-8">
<meta http-equiv = "X-UA-Compatible" content = "IE = edge">
<meta name = "viewport" content = "width = device-width, initial-scale = 1">
<title>Login</title>
<link href = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel = "stylesheet">
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
		<div class="span12">
		<h3>Edit your basic information</h3>
			<form:form modelAttribute="application" class="form-horizontal">
			  <fieldset>
			    <div id="legend">
			     
			    </div>
			    <div class="control-group">
			      
			      <label class="control-label"  for="firstname">firstname</label>
			      <div class="controls">
			       <form:input path="firstname" id="firstname" name="firstname" placeholder="" class="input-xlarge"/>
			       
			      </div>
			    </div>
			    <div class="control-group">
			     
			      <label class="control-label" for="lastname">lastname</label>
			      <div class="controls">
			        <form:input path="lastname" id="lastname" name="lastname" placeholder="" class="input-xlarge"/>
			        
			      </div>
			    </div>
			     <div class="control-group">
			    
			      <label class="control-label"  for="email">email</label>
			      <div class="controls">
			        <form:input path="email" id="email" name="email" placeholder="" class="input-xlarge"/>
			        
			      </div>
			    </div>
			     <div class="control-group">
			      
			      <label class="control-label"  for="CIN">CIN</label>
			      <div class="controls">
			        <form:input type="number" path="CIN" id="CIN" name="CIN" placeholder="" class="input-xlarge"/>
			        
			      </div>
			    </div>
			    <div class="control-group">
			      
			      <label class="control-label"  for="phone">phone</label>
			      <div class="controls">
			        <form:input type="text" path="phone" id="phone" name="phone" placeholder="" class="input-xlarge"/>
			        
			      </div>
			    </div>
			     <div class="control-group">
			      
			      <label class="control-label"  for="gender">gender</label>
			      <div class="controls">
			        <form:input type="text" path="gender" id="gender" name="gender" placeholder="" class="input-xlarge"/>
			        
			      </div>
			    </div>
			    <div class="control-group">
			      
			      <label class="control-label"  for="dob">date of birth(mm/dd/yy)</label>
			      <div class="controls">
			        <form:input type="text" path="dob" id="dob" name="dob" placeholder="" class="input-xlarge"/>
			      </div>
			    </div>
			     <div class="control-group">
			      
			      <label class="control-label"  for="citizenship">citizenship</label>
			      <div class="controls">
			        <form:input type="text" path="citizenship" id="citizenship" name="citizenship" placeholder="" class="input-xlarge"/>
			      </div>
			    </div>
			    <br />
			    <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			        <button class="btn btn-success" type="submit">Save</button>
			      </div>
			    </div>
			  </fieldset>
			</form:form>
		</div>
	</div>
	</div>
</body>
</html>