<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Patient Tracker Application</title>
	
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
		<div class="row mg-2">
			<div class="col-2"></div>
			<div class="col-8">
				<div class="btn-group"><!-- Add new button: Add Patient -->
					<input type="button" 
							class="btn btn-default add-patient-button"   
							value = "Add Patient"
							onclick="window.location.href='addPatientForm'; return false;"/> 
				</div>
			
					
			<table class="table table-sm table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Middle Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Action</th>
					
				</tr>
			</thead>
				<!-- Loop Over and print out list patient -->
				<c:forEach var="tempPatient" items="${patients}">
				<tbody>
					<tr>
						<td>${tempPatient.firstName}  </td>
						<td>${tempPatient.middleName}  </td>
						<td>${tempPatient.lastName}  </td>
						
					</tr>
				</tbody>
				</c:forEach>
				
			</table>
		</div>
		
			<div class="col-2"></div>
		</div>
			
		</div>
	

</body>

</html>