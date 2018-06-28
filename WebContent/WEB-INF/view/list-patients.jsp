<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
	<title>Patient Tracker App</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<!-- link type="text/css" rel="stylesheet" href="css/add-patient-style.css"-->
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>
	<div id ="wrapper">
		<div class="container">
				<div class="row">
					<div class="col"></div>
					
					<div id="header" class="col-5"><h2>Patient Medical Management</h2></div>
					<div class="col"></div>
				</div>
			</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col-5">
		
			<!-- Add new button: Add Patient -->
			<input type="button" value = "Add Patient"
					onclick="window.location.href='add-patient-form.jsp'; return false;"
					class="add-patient-button"/>  <!-- -Style -->
			<table class="table table-sm table-bordered table-striped">
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Middle Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Action</th>
					
				</tr>
				
				<c:forEach var="tempPatient" items="${PATIENT_LIST}">
				<tbody>
					<tr>
					<!-- set up an update link for each patient--->
					<c:url var ="updateLink" value = "PatientControllerServlet">
						<c:param name="command" value="LOAD"/>
						<c:param name="patientId" value="${tempPatient.id}" />
					</c:url>
					
					<!-- set up a view link for each patient--->
					<c:url var ="viewLink" value = "PrescriptionControllerServlet">
						<c:param name="command" value="VIEW"/>
						<c:param name="patientId" value="${tempPatient.id}" />
					</c:url>
					
					<!-- set up a link to delete a patient -->
					<c:url var ="deleteLink" value = "PatientControllerServlet">
						<c:param name="command" value="DELETE"/>
						<c:param name="patientId" value="${tempPatient.id}" />
					</c:url>
						<td> ${tempPatient.firstName} </td>
						<td> ${tempPatient.middleName} </td>
						<td> ${tempPatient.lastName} </td>
						
						<td> 
							<a href = "${updateLink}">Update</a>|
							<a href = "${viewLink}">View</a> |
							<a href = "${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this patient?'))) return false">
							Delete</a>
						 </td>
					</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
		
			<div class="col"></div>
		</div>
			
		</div>
	

</body>

</html>