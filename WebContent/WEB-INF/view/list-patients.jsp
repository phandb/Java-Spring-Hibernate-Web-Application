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
					<h4>Spring & Hibernate in Action</h4>
				</div>
				
			</div>
					
				
		
	
	
	<div class="container">
		<div class="row mg-2">
			<div class="col-2"></div>
			<div class="col-8">
			
				<div class="form-inline navbar">
				
				
						<!-- Add new button: Add Patient -->
					
						<input type="button" 
								class="btn btn-primary"   
								value = "Add Patient"
								onclick="window.location.href='addPatientForm'; return false;"/> 
					
					
					<!--  add a search box -->
					
			            <form:form action="search" method="POST" class="pull-right">
			            	<div class="form-group ">
			                 <input type="text" name="theSearchName" class="form-control" placeholder="search patient"/>
			                 </div>
			               <span> <button type="submit" class=" btn btn-primary">Search</button> 
			               </span>
			            </form:form>
		            
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
				
					<!-- Construct an view patient link with patient id -->
					<c:url var="viewPatientLink" value="/patient/viewPatientInfo">
						<c:param name="patientId" value="${tempPatient.id }"/>
					</c:url>
					
					<!-- Construct an update link with patient id -->
					<c:url var="updatePatientLink" value="/patient/updatePatientForm">
						<c:param name="patientId" value="${tempPatient.id }"/>
					</c:url>
					
					<!-- Construct an delete link with patient id -->
					<c:url var="deletePatientLink" value="/patient/deletePatient">
						<c:param name="patientId" value="${tempPatient.id }"/>
					</c:url>
					
					<tr class="text-center">
						<td>${tempPatient.firstName}  </td>
						<td>${tempPatient.middleName}  </td>
						<td>${tempPatient.lastName}  </td>
						<td>
							<!-- display view, update and delete link -->
							<a href="${viewPatientLink }">View Patient Info</a>
							|
							<a href="${updatePatientLink }">Update</a>
							|
							<a href="${deletePatientLink }"
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