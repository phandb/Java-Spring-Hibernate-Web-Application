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
	 			<div>
					<c:set var="selectedPatient" value="${selectedPatient.get(0)}"/>
					<h4 class="lead">Patient: ${selectedPatient.firstName} 
								 ${selectedPatient.middleName} 
								 ${selectedPatient.lastName} 
					</h4>
			
				</div>
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
								<c:set var="i" value="${i+1}"/>
								<tr class="text-center">
									<td>${i }</td>
									<td>${tempMedication.medicationName}  </td>
									<td>${tempMedication.medicationStrength}  </td>
									<td>${tempMedication.medicationDosage}  </td>
									
									
								</tr>
							</tbody>
						</c:forEach>
						
					</table>
					<c:if test="${i == 0 }">
						<h4 class="text-muted">No prescription for this patient</h4>
					</c:if >
				</div>
				
				
				<!-- List of Physician -->
				<h4>List of Physicians</h4>
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
								<c:set var="i" value="${i+1}"/>
								<tr class="text-center">
									<td>${i }</td>
									<td>${tempPhysician.physicianName}  </td>
									<td>${tempPhysician.physicianSpecialty}  </td>
									<td>${tempPhysician.physicianAddress}  </td>
									<td>${tempPhysician.physicianPhone}  </td>
									
									
								</tr>
							</tbody>
						</c:forEach>
						
					</table>
					<c:if test="${i == 0 }">
						<h4 class="text-muted">No physician for this patient</h4>
					</c:if >
					
					
					<!-- List of Physician -->
				<h4>List of Pharmacies</h4>
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
								<c:set var="i" value="${i+1}"/>
								<tr class="text-center">
									<td>${i }</td>
									<td>${tempPharmacy.pharmacyName}  </td>
									<td>${tempPharmacy.pharmacyAddress}  </td>
									<td>${tempPharmacy.pharmacyPhone}  </td>
									
									
								</tr>
							</tbody>
						</c:forEach>
						
					</table>
					<c:if test="${i == 0 }">
						<h4 class="text-muted">No pharmacy for this patient</h4>
					</c:if >
				
		
			<div class="col-2"></div>
		</div>
			
		</div>
	

</body>

</html>