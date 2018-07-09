<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
				
				<!--  add a search box -->
            <form:form action="search" method="POST">
                Search patient: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			
					
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
				
					<!-- Construct an update link with patient id -->
					<c:url var="updateLink" value="/patient/updatePatientForm">
						<c:param name="patientId" value="${tempPatient.id }"/>
					</c:url>
					
					<!-- Construct an delete link with patient id -->
					<c:url var="deleteLink" value="/patient/delete">
						<c:param name="patientId" value="${tempPatient.id }"/>
					</c:url>
					
					<tr>
						<td>${tempPatient.firstName}  </td>
						<td>${tempPatient.middleName}  </td>
						<td>${tempPatient.lastName}  </td>
						<td>
							<!-- display update and delete link -->
							<a href="${updateLink }">Update</a>
							|
							<a href="${deleteLink }"
								onclick="if (!(confirm('Are you sure to delete this patient?'))) return false">Delete</a>
						</td>
						
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