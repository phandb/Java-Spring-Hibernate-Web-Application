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
	<script src="${pageContext.request.contextPath }/resources/js/populatePhysicianInfo.js"
			type="text/javascript"></script>
	
	<script type="text/javascript">
<%-- 	
	$(document).ready(function() {
	// var doctorObj = new Object
	$("#selectedDoctor option").filter(function(){
		
		return $(this).val() == $("#name").val();
	}).attr('selected', true);
	
	 $("#selectedDoctor").change(function(){
		
		/* var dataString = $(this).val();
		 alert(dataString);*/
		 var doctorObj = JSON.parse('$(this).val()');
		 alert(doctorObj.physicianName);
		 
		 document.getElementById("name").innerHTML = doctorObj.physicianName;
		 $("#name").doctorObj.physicianName;
		 $("#specialty").doctorObj.physicianSpecialty;
		 
	 });
});

--%>
$(document).ready(function() {
	/*
	 var doctorObj = JSON.parse($(this).val());
	 //alert(doctorObj.physicianName);
	
		$("#name").text(doctorObj.physicianName);
		$("#specialty").html(doctorObj.physicianSpecialty);
	
	/*
	// var doctorObj = new Object
	$("#selectedDoctor option").filter(function(){
		
		return $(this).val() == $("#name").val();
	}).attr('selected', true);
	*/
	
	/*
	 $("#selectedDoctor").change(function(event){ //wrap doctor drop down and binds change handler
		
		var doctorObj = JSON.parse($(this).val());
		//alert(doctorObj['physicianName']);
		//$("#name").html("doctorObj"); 
		 $.get(
				 
				 'view/get-physician-info-detail.jsp',
				 {
					 doctorInfo: $(event.target).val()
				 },
				 function(response){
					 $('#doctor-info-detail').html(response);
					 $('[value=""]', event,target).remove();
				 }
		 
		 
		 );
		 
	 });	
	*/
});
	</script>
	
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
		
		
		
		<form:form action="addPhysician" modelAttribute="physician" method="POST"
					class="form-horizontal">
					
			<!-- The hidden form will keep specific prescription Id when called -->
			<form:hidden path="id" />
			<input type="hidden" name="selectedPatientId" value="${selectedPatientId}"/>
			
			
		<div class="form-group">
				<label class="col-sm-2 control-label">Physician List:</label>
				<div class="col-sm-5">
				
					<select   class="form-control" name="selectedPhysician"  id="selectedDoctor" > 
													
						<option value="" >Select Doctor in the List</option>
						<c:forEach items="${listAllPhysicians }" var="thePhysician" >
							
							<option value= '{ "physicianName":"${thePhysician.physicianName }","physicianSpecialty":"${thePhysician.physicianSpecialty }",
											  "physicianAddress":"${thePhysician.physicianAddress }","physicianPhone":"${thePhysician.physicianPhone }"
											}'>  ${thePhysician.physicianName}</option>
							
						</c:forEach>
					</select>
				</div>
				
		</div>
	<%-- 
		<json:object>
			<json:property name="physicianName" value="${thePhysician.physicianName }"/>
			<json:property name="physicianSpecialty" value="${thePhysician.physicianSpecialty }"/>
			<json:property name="physicianAddress" value="${thePhysician.physicianAddress }"/>
			<json:property name="physicianPhone" value="${thePhysician.physicianPhone }"/>
		
			
		</json:object>
		
--%>
		<div class="doctor-info-detail">				
				
			<div class="form-group">
				<label class="col-sm-2 control-label">Physician Name:</label>
				<div class="col-sm-5">
					<form:input path="physicianName" value = ""
								 type="text" class="form-control" 
								 id="name" />
				</div>
			</div>
					 
			
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Specialty:</label>
				<div class="col-sm-5">
					<form:input path="physicianSpecialty"
								 type="text" class="form-control"
								
								 id="specialty"  />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Address:</label>
				<div class="col-sm-5">
					<form:input path="physicianAddress" 
								type="text" 
								
								class="form-control" 
								id="address" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Phone:</label>
				<div class="col-sm-5">
					<form:input path="physicianPhone" 
								type="text" 
								
								class="form-control" 
								id="phone"/>
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
			
			<p><a href=" <c:url value= "/patient/viewPatientInfo?patientId=${selectedPatientId}">
						
						</c:url> "> Back to the Patient Info View</a></p>
		</div>
		
		
		
	</div>
	


</body>


</html>