<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Patient Tracker Application</title>
	
	<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath }/resources/css/style.css">
	<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
		
	
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
					onclick="window.location.href='addPatientForm'; return false;"
					class="btn btn-primary"/>  <!-- -Style -->
					
			<table class="table table-sm table-bordered table-striped">
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Middle Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Action</th>
					
				</tr>
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
		
			<div class="col"></div>
		</div>
			
		</div>
	

</body>

</html>