<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>


<html>

<head>
	<title>Update Physician</title>
	
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
					<h4>Spring & Hibernate in Action</h4>
				</div>
				
			</div>
			
	<div class="container">
		<h3>Update Physician Information</h3>
		
		
		
		<form:form action="updatePhysician" modelAttribute="physician" method="POST"
					class="form-horizontal">
					
			<!-- The hidden form will keep specific prescription Id when called -->
			<form:hidden path="id" />
			<input type="hidden" name="selectedPatientId" value="${selectedPatientId}"/>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Physician Name:</label>
				<div class="col-sm-5">
					
					<form:input path="physicianName" type="text" class="form-control" />
					 
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Specialty:</label>
				<div class="col-sm-5">
					<form:input path="physicianSpecialty" type="text" class="form-control"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Addess:</label>
				<div class="col-sm-5">
					<form:input path="physicianAddress" type="text" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Phone:</label>
				<div class="col-sm-5">
					<form:input path="physicianPhone" type="text" class="form-control" />
				</div>
			</div>
			<%-- 
			<div class="form-group">
				<label class="col-sm-2 control-label">Patient ID:</label>
				<div class="col-sm-5">
					<form:input path="patients[0].id" value="${selectedPatientId }"/>
				</div>
			</div>
			
			--%>
			
			<div class="form-group">
				
				<div class="col-sm-offset-2 col-sm-5">
					<input type="submit" value="Save" class="btn btn-primary"/>
				</div>
			</div>		
		</form:form>
		
		<div class="clearfix">
			
			<p><a href=" <c:url value= "/patient/viewPatientInfo?patientId=${selectedPatientId}">
						
						</c:url> "> Back to the Patient Info View</a></p>
		</div>
		
		
		
	</div>
	


</body>


</html>