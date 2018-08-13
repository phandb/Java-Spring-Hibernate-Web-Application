<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>


<html>

<head>
	<title>Add Prescription</title>
	
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
		<h3>Add New Prescription</h3>
		
		
		
		<form:form action="savePrescription" modelAttribute="prescription" method="POST"
					class="form-horizontal">
					
			<!-- The hidden form will keep specific prescription Id when called -->
			<form:hidden path="id" />
			<input type="hidden" name="selectedPatientId" value="${selectedPatientId}"/>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Prescription Name:</label>
				<div class="col-sm-5">
					<form:input path="medicationName" type="text" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Prescription Strength:</label>
				<div class="col-sm-5">
					<form:input path="medicationStrength" type="text" class="form-control"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Dosage</label>
				<div class="col-sm-5">
					<form:input path="medicationDosage" type="text" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Patient ID</label>
				<div class="col-sm-5">
					<form:input path="patient.id" value="${selectedPatientId }"/>
				</div>
			</div>
			
			
			
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