<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>


<html>

<head>
	<title>Save Patient</title>
	
	<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
		
	<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath }/resources/css/style.css">
</head>
<body>
	
			<div class="container-fluid bg-primary ">
			
				<div class="page-header text-center ">
				
					<h1>Patient Medical Management </h1>
					<h4>Spring Hibernate in Action</h4>
				</div>
				
			</div>
			
	<div class="container">
		<h3>Add Patient</h3>
		<form:form action="savePatient" modelAttribute="patient" method="POST"
					class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">First Name:</label>
				<div class="col-sm-5">
					<form:input path="firstName" type="text" class="form-control" placeholder="first name"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Middle Name:</label>
				<div class="col-sm-5">
					<form:input path="middleName" type="text" class="form-control" placeholder="middle name"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Last Name:</label>
				<div class="col-sm-5">
					<form:input path="lastName" type="text" class="form-control" placeholder="last name"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Gender:</label>
				<div class="col-sm-2">
					<form:input path="gender" type="text" class="form-control" placeholder="Male/Female"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Date of Birth:</label>
				<div class="col-sm-3">
					<form:input path="dateOfBirth" type="text" class="form-control" placeholder="YYYY-MM-DD"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Address:</label>
				<div class="col-sm-5">
					<form:input path="address" type="text" class="form-control" placeholder="address"/>
				</div>
			</div>
			
			<div class="form-group">
				
				<div class="col-sm-offset-2 col-sm-5">
					<input type="submit" value="Save" class="btn btn-primary"/>
				</div>
			</div>		
		</form:form>
		<div class="clearfix">
			<p><a href="${pageContext.request.contextPath}/patient/list">Back to Patient List</a>
		</div>
		
	</div>
	


</body>


</html>