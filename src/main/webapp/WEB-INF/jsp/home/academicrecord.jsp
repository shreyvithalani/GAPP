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
	<div class="container">
	<p align="right"><a href="./logout.html">Logout</a></p>
		<div class="row">
			<div class="span12">
				<h3>Enter your Academic records</h3>
				<form:form modelAttribute="academic" class="form-horizontal">
					<fieldset>
						<div id="legend"></div>
						<div class="control-group">

							<label class="control-label" for="Toefl">Toefl score</label>
							<div class="controls">
								<form:input type="text" path="Toeflscore" id="Toeflscore"
									name="Toeflscore" placeholder="" class="input-xlarge" />

							</div>
						</div>
						<div class="control-group">

							<label class="control-label" for="Grescore">Grescore</label>
							<div class="controls">
								<form:input type="text" path="Grescore" id="Grescore"
									name="Grescore" placeholder="" class="input-xlarge" />

							</div>
						</div>
						<div class="control-group">

							<label class="control-label" for="gpa">GPA</label>
							<div class="controls">
								<form:input type="text" path="gpa" id="gpa" name="gpa"
									 placeholder="" class="input-xlarge" />

							</div>
						</div>

						<br />
						<div class="control-group">
							<!-- Button -->
							<div class="controls">
								<button class="btn btn-success" type="submit">Save and
									go to next phase</button>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>