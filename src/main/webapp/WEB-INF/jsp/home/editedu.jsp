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
		<h3>Enter your Educational background</h3>
			<form:form modelAttribute="degree" class="form-horizontal">
			  <fieldset>
			    <div id="legend">
			     
			    </div>
			    <div class="control-group">
			      
			      <label class="control-label"  for="degree">Degree</label>
			      <div class="controls">
			       <form:input type="text" path="degree" id="degree" name="degree" placeholder="" class="input-xlarge"/>
			       
			      </div>
			    </div>
			    <div class="control-group">
			     
			      <label class="control-label" for="major">major</label>
			      <div class="controls">
			        <form:input type="text" path="major" id="major" name="major" placeholder="" class="input-xlarge"/>
			        
			      </div>
			    </div>
			     <div class="control-group">
			    
			      <label class="control-label"  for="univname">University name</label>
			      <div class="controls">
			        <form:input type="text" path="univname" id="univname" name="univname" placeholder="" class="input-xlarge"/>
			        
			      </div>
			    </div>
			    
			     <div class="control-group">
			      
			      <label class="control-label"  for="startyear">starting year</label>
			      <div class="controls">
			        <form:input type="text" path="start_year" id="start_year" name="start_year" placeholder="" class="input-xlarge"/>
			        
			      </div>
			    </div>
			     
			    <div class="control-group">
			      
			      <label class="control-label"  for="endyear">ending year</label>
			      <div class="controls">
			        <form:input type="text" path="end_year" id="end_year" name="end_year" placeholder="" class="input-xlarge"/>
			        
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