<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" --%>

<!DOCTYPE html>


<html>

<head>
	<title>Add Physician</title>
	
	<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
		
	<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath }/resources/css/style.css">
		
	<script src="${pageContext.request.contextPath }/resources/js/jquery.js"
			type="text/javascript"></script>
	
			
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/getPhysicianInfo.js"	type="text/javascript"></script>
		
</head>
<body>
	
			<div class="container-fluid bg-primary ">
			
				<div class="page-header text-center ">
				
					<h1>Patient Medical Management </h1>
					<h4>Spring and Hibernate in Action</h4>
				</div>
				
			</div>
	
	<div class="container">
		<h3>Add Physician to the Patient</h3>
		
		
		
		<form:form method="POST" action="addPhysician"  modelAttribute="physician" class="form-horizontal">
		
			<%-- 	modelAttribute="physician"
			<!-- The hidden form will keep specific prescription Id when called   -->
			<form:hidden path="id" />
			--%>	
			
			<input type="hidden" name="selectedPatientId" value="${selectedPatientId}"/>
			
			
		<div class="form-group">
				<label class="col-sm-2 control-label">Physician List:</label>
				<div class="col-sm-5">
				
					<select class="form-control"  name="selectedPhysicianId"  id="selectedDoctor" > 
					
							<c:forEach items="${listAllPhysicians }" var="thePhysician">
								<option value="${thePhysician.id }"> ${thePhysician.physicianName } </option>
							
							</c:forEach>					
						
						
							<%--
							<form:option value= '{ "physicianName":"${thePhysician.physicianName }","physicianSpecialty":"${thePhysician.physicianSpecialty }",
											  "physicianAddress":"${thePhysician.physicianAddress }","physicianPhone":"${thePhysician.physicianPhone }",
											  "physicianId":"${thePhysician.id }"
											}' label=" ${thePhysician.physicianName} "/>
							 
							 <form:options items = "${listAllPhysicians.getPhysicianName()}"  />
							--%>
					</select>
				</div>
				
		</div>
	
	
		<div class="doctor-info-detail">				
				
			<div class="form-group">
				<label class="col-sm-2 control-label">Physician Name:</label>
				<div class="col-sm-5">
					<form:input path="physicianName" type="text" class="form-control" id="name" />
				</div>
			</div>
					 
			
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Specialty:</label>
				<div class="col-sm-5">
					<form:input path="physicianSpecialty" type="text" class="form-control" id="specialty"  />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Address:</label>
				<div class="col-sm-5">
					<form:input path="physicianAddress" type="text" class="form-control" id="address" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Phone:</label>
				<div class="col-sm-5">
					<form:input path="physicianPhone" type="text" class="form-control" id="phone"/>
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
	
		</div>
			<div class="form-group">
				
				<div class="col-sm-offset-2 col-sm-5">
					<input type="submit" value="Save" class="btn btn-primary"/>
				</div>
			</div>		
		
		</form:form>
		<div class="clearfix">
			
			<p>
				<a href=" <c:url value= "/patient/viewPatientInfo?patientId=${selectedPatientId}">
				</c:url> "> Back to the Patient Info View</a>
			</p>
		</div>
		
		
		
	</div>
	


</body>


</html>