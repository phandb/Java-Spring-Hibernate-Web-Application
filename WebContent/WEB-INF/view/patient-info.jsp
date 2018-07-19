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
			
							
					
			<table class="table table-sm table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Prescription Name</th>
					<th scope="col">Strength</th>
					<th scope="col">Dosage</th>
					<th scope="col">Action</th>
					
				</tr>
			</thead>
				<!-- Loop Over and print out list patient -->
				<c:forEach var="tempMedication" items="${medications}">
					<tbody>
					
						<tr class="text-center">
							<td>${tempMedication.medicationName}  </td>
							<td>${tempMedication.medicationStrength}  </td>
							<td>${tempMedication.medicationDosage}  </td>
							
							
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