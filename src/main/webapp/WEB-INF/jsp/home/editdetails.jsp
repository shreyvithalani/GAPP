<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE = edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>application</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- <script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script>
	$(document).ready(function() {

	$( "#department" ).on('change',function() {
		data = "dept=" + $('#department').val();
		$.ajax({
			type: 'GET',
			  url: "submitdept.html",
			  data: data,
			  success : function(data) {
					$('#program').html(data);
				}
		});
	});
	});
	</script> -->
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span12">
				<form:form modelAttribute="application" method="post">
					<fieldset>
						<div id="legend"></div>
						<div class="control-group">
							<label class="control-label" for="department">Select
								department</label>
							<div class="controls">
								Department name: <input type="text" name="dept"
									value="${application.department.dept_name }" disabled>
							</div>
						</div>

						<div class="control-group">
							<!-- Program-->
							<label class="control-label" for="program">Select program</label>
							<div class="controls">
								<form:select id="program" name="program" path="program.id" >
									<c:forEach items="${program}" var="prog">
										<c:choose>
											<c:when test="${prog.id == application.program.id}">
												<option value="${prog.id}" selected="selected">${prog.program}</option>
											</c:when>
											<c:otherwise>
												<option value="${prog.id}">${prog.program}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="term">Select Term</label>
							<div class="controls">
								<form:select id="term" name="term" path="term">
									<form:option value="spring 2016">spring 2016</form:option>
									<form:option value="fall 2016">fall 2016</form:option>
									<form:option value="winter 2017">winter 2017</form:option>
									<form:option value="spring 2017">spring 2017</form:option>
								</form:select>
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