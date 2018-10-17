<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>


<html>

<head>
	<title>Add Pharmacy</title>
	
	<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
		
	<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath }/resources/css/style.css">
		<script type="text/javascript" src="${pagrContext.request.contextPath }/resources/js/jquery.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/getPharmacyInfo.js"></script>
</head>
<body>
	
			<div class="container-fluid bg-primary ">
			
				<div class="page-header text-center ">
				
					<h1>Patient Medical Management </h1>
					<h4>Spring & Hibernate in Action</h4>
				</div>
				
			</div>
	
	<div class="container">
		<h3>Add Pharmacy to Patient</h3>
		<form:form action="addPharmacy" modelAttribute="pharmacy" method="POST"
					class="form-horizontal">
					
			<!-- The hidden form will keep specific prescription Id when called -->
			<form:hidden path="id" />
			<input type="hidden" name="selectedPatientId" value="${selectedPatientId}"/>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Pharmacy List:</label>
				<div class="col-sm-5">
					<select class="form-control" name="selectedPharmacy" id="selectedPharmacy">
						<option value="">Select Pharmacy in the List</option>
						<c:forEach items="${listAllPharmacies }" var="thePharmacy">
							<option value='{"pharmacyName":"${thePharmacy.pharmacyName }",
											"pharmacyPhone":"${thePharmacy.pharmacyPhone }",
											"pharmacyAddress":"${thePharmacy.pharmacyAddress }"
											}'>${thePharmacy.pharmacyName }
							</option>
						
						</c:forEach>
					</select>
				</div>
			</div>
		<div class="pharmacy-info-detail">
			<div class="form-group">
				<label class="col-sm-2 control-label">Pharmacy Name:</label>
				<div class="col-sm-5">
					
					<form:input path="pharmacyName" value = "" type="text" class="form-control" id="name" />
					
				</div>
			</div>
									
			<div class="form-group">
				<label class="col-sm-2 control-label">Addess:</label>
				<div class="col-sm-5">
					<form:input path="pharmacyAddress" value = "" type="text" class="form-control" id="address" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Phone:</label>
				<div class="col-sm-5">
					<form:input path="pharmacyPhone"  value = ""  type="text" class="form-control" id="phone"/>
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