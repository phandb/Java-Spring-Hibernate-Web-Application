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
	 			 <div>
					<c:set var="thePatient" value="${selectedPatient}"/>
					
					<h4 class="lead">Patient: ${thePatient.patientFullName()}</h4>
			
				</div>
					
				<div class="form-inline navbar">
				
					<form:form action="addPrescriptionForm" method="get" >
						<!-- Add new Patient Button -->
						<button class ="btn btn-primary" name="patientId" value="${thePatient.id}">Add Prescription</button>
						
						
					
						<!--  return button -->
					
			            <input type="button" 
								class="btn btn-primary pull-right"   
								value = "Return to Patient List"
								onclick="window.location.href='${pageContext.request.contextPath}/patient/list'; return false;"/> 
				
		           	
					</form:form>
					
					
					<%--- 
						<input type="button" 
								class="btn btn-primary"   
								value = "Add Prescription"
								onclick="window.location.href='addPrescriptionForm/${selectedPatient.id}'; return false;"/> 
								
						--%>
					
				</div>
				
				
				 <h4 class="text-center"> Medication List</h4>	
								
					<table class="table table-sm table-bordered table-striped">
						<thead class="thead-dark">
							<tr>
								<th scope="col">No</th>
								<th scope="col">Prescription Name</th>
								<th scope="col">Strength</th>
								<th scope="col">Dosage</th>
								<th scope="col">Action</th>
								
							</tr>
						</thead>
						<!-- Loop Over and print out list patient -->
						<c:set var="i" value="${0}"/>
						<c:forEach var="tempMedication" items="${medications}">
							<tbody>
							
								
								
								<!-- Construct an update link with medication id -->
								<c:url var="updatePrescriptionLink" value="/patient/updatePrescriptionForm">
									<c:param name="prescriptionId" value="${tempMedication.id }"/>
									<c:param name="selectedPatientId" value= "${thePatient.id }"/>
								</c:url>
								
								<!-- Construct an delete link with medication id -->
								<c:url var="deletePrescriptionLink" value="/patient/deletePrescription">
									<c:param name="prescriptionId" value="${tempMedication.id }"/>
									<c:param name="selectedPatientId" value= "${thePatient.id }"/>
									
								</c:url>
								
								<c:set var="i" value="${i+1}"/>
								<tr class="text-center">
									<td>${i}</td>
									<td>${tempMedication.medicationName}  </td>
									<td>${tempMedication.medicationStrength}  </td>
									<td>${tempMedication.medicationDosage}  </td>
									<td>
											<!-- display update and delete link -->
										
										<a href="${updatePrescriptionLink }">Update</a>
										|
										<a href="${deletePrescriptionLink }"
											onclick="if (!(confirm('Are you sure to delete this prescription?'))) return false">Delete</a>
									</td>
									
								</tr>
							</tbody>
						</c:forEach>
						
					</table>
					<c:if test="${i == 0 }">
						<h4 class="text-muted">No prescription for this patient</h4>
					</c:if >
				
				
				
				<img src="${pageContext.request.contextPath }/resources/images/deco-line.jpg" class="center-block">
				
				
<!-- -------------------------List of Physician --------------------------------------------------->
		
						<form:form action="addPhysicianForm" method="get" >
						<!-- Add new Patient Button -->
						<button class ="btn btn-primary" name="patientId" value="${thePatient.id}">Add Physician</button>
						
						
					
						<!--  return button -->
					
			            <input type="button" 
								class="btn btn-primary pull-right"   
								value = "Return to Patient List"
								onclick="window.location.href='${pageContext.request.contextPath}/patient/list'; return false;"/> 
				
		           	
					</form:form>
								
					<h4 class="text-center"> Physicians</h4>		
					<table class="table table-sm table-bordered table-striped">
						<thead class="thead-dark">
							<tr>
								<th scope="col">No</th>
								<th scope="col">Physician Name</th>
								<th scope="col">Specialty</th>
								<th scope="col">Address</th>
								<th scope="col">Phone</th>
								<th scope="col">Action</th>
								
							</tr>
						</thead>
						<!-- Loop Over and print out list patient -->
						<c:set var="i" value="${0}"/>
						<c:forEach var="tempPhysician" items="${physicians}">
							<tbody>
							
								<!-- Construct an update link with medication id -->
								<c:url var="updatePhysicianLink" value="/patient/updatePhysicianForm">
									<c:param name="physicianId" value="${tempPhysician.id }"/>
									<c:param name="selectedPatientId" value= "${thePatient.id }"/>
								</c:url>
								
								<!-- Construct an delete link with medication id -->
								<c:url var="deletePhysicianLink" value="/patient/deletePhysician">
									<c:param name="physicianId" value="${tempPhysician.id }"/>
									<c:param name="selectedPatientId" value= "${thePatient.id }"/>
								</c:url>
								
								<c:set var="i" value="${i+1}"/>
								<tr class="text-center">
									<td>${i }</td>
									<td>${tempPhysician.physicianName}  </td>
									<td>${tempPhysician.physicianSpecialty}  </td>
									<td>${tempPhysician.physicianAddress}  </td>
									<td>${tempPhysician.physicianPhone}  </td>
									<td>
											<!-- display update and delete link -->
										
										<a href="${updatePhysicianLink }">Update</a>
										|
										<a href="${deletePhysicianLink }"
											onclick="if (!(confirm('Are you sure to delete this doctor?'))) return false">Delete</a>
									</td>
									
								</tr>
							</tbody>
						</c:forEach>
						
					</table>
					<c:if test="${i == 0 }">
						<h4 class="text-muted">No physician for this patient</h4>
					</c:if >
					
					<img src="${pageContext.request.contextPath }/resources/images/deco-line.jpg" class="center-block">
					
<!-- ---------------------------------------List of Pharmacy ----------------------------------------------->
				
						<form:form action="addPharmacyForm" method="get" >
						<!-- Add new Patient Button -->
						<button class ="btn btn-primary" name="patientId" value="${thePatient.id}">Add Pharmacy</button>
						
						
					
						<!--  return button -->
					
			            <input type="button" 
								class="btn btn-primary pull-right"   
								value = "Return to Patient List"
								onclick="window.location.href='${pageContext.request.contextPath}/patient/list'; return false;"/> 
				
		           	
					</form:form> 
								
					<h4 class="text-center">Pharmacies</h4>		
						
					<table class="table table-sm table-bordered table-striped">
						<thead class="thead-dark">
							<tr>
								<th scope="col">No</th>
								<th scope="col">Pharmacy Name</th>
								<th scope="col">Address</th>
								<th scope="col">Phone</th>
								
								<th scope="col">Action</th>
								
							</tr>
						</thead>
						<!-- Loop Over and print out list patient -->
						<c:set var="i" value="${0}"/>
						<c:forEach var="tempPharmacy" items="${pharmacies}">
							<tbody>
							
								<!-- Construct an update link with medication id -->
								<c:url var="updatePharmacyLink" value="/patient/updatePharmacyForm">
									<c:param name="pharmacyId" value="${tempPharmacy.id }"/>
									<c:param name="selectedPatientId" value= "${thePatient.id }"/>
								</c:url>
								
								<!-- Construct an delete link with medication id -->
								<c:url var="deletePharmacyLink" value="/patient/deletePharmacy">
									<c:param name="pharmacyId" value="${tempPharmacy.id }"/>
									<c:param name="selectedPatientId" value= "${thePatient.id }"/>
								</c:url>
								
								
								<c:set var="i" value="${i+1}"/>
								<tr class="text-center">
									<td>${i }</td>
									<td>${tempPharmacy.pharmacyName}  </td>
									<td>${tempPharmacy.pharmacyAddress}  </td>
									<td>${tempPharmacy.pharmacyPhone}  </td>
									
									<td>
											<!-- display update and delete link -->
										
										<a href="${updatePharmacyLink }">Update</a>
										|
										<a href="${deletePharmacyLink }"
											onclick="if (!(confirm('Are you sure to delete this pharmacy?'))) return false">Delete</a>
									</td>
								</tr>
							</tbody>
						</c:forEach>
						
					</table>
					<c:if test="${i == 0 }">
						<h4 class="text-muted">No pharmacy for this patient</h4>
					</c:if >
				
				</div>
			<div class="col-2"></div>
			
		</div>
			
		
	<img src="${pageContext.request.contextPath }/resources/images/deco-line.jpg" class="center-block">
</div>
</body>

</html>