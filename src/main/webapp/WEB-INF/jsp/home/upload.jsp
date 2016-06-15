<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE = edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>Academic records</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%-- <form enctype="multipart/form-data"  method="post" action="uploadtranscript.html">
		Please select a file to upload : <input type="file" name="file" />
		<input type="submit" value="upload" />
		
	</form> --%>
	<div class="container">
		<div class="row">
			<div class="span12">
				<h3>Upload file</h3>
				<form:form enctype="multipart/form-data" modelAttribute="application" action="upload.html?id=${application.id}" class="form-horizontal">
					<fieldset>
						<div id="legend"></div>
						<div class="control-group">

							<label class="control-label" for="upload">Please select a file to upload :</label>
							<div class="controls">
								 <input type="file" name="file" />
							</div>
						</div>
						<br />
						<div class="control-group">
							<!-- Button -->
							<div class="controls">
								<button class="btn btn-success" type="submit" name="upload" value ="upload">upload and save application
									</button>
							</div>
						</div>
						<br />
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>