<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE = edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>Login</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h3>Login Here</h3>
	<div class="container">
		<div class="row">
			<div class="span12">
				<h3>${message}</h3>
				<form:form modelAttribute="user" class="form-horizontal">
					<fieldset>
						<div id="legend"></div>
						<div class="control-group">
							<!-- Username -->
							<label class="control-label" for="username">Username</label>
							<div class="controls">
								<form:input type="text" path="email" id="username"
									name="username" placeholder="" class="input-xlarge"
									required="required" />
								<form:errors path="email" />
							</div>
						</div>
						<div class="control-group">
							<!-- Password-->
							<label class="control-label" for="password">Password</label>
							<div class="controls">
								<form:input type="password" path="password" id="password"
									name="password" placeholder="" class="input-xlarge"
									required="required" />
								<form:errors path="password" />
							</div>
						</div>
						<div class="control-group">
							<!-- Button -->
							<div class="controls">
								<button class="btn btn-success" type="submit">Login</button>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>