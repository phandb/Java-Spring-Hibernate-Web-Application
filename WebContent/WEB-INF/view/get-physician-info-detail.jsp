<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="org.json.JSONObject;"%>


<%
JSONObject doctorObj=(JSONObject)session.getAttribute("doctorInfo");
%>

<%=doctorObj %>
<form:form action=" " modelAttribute="doctorInfo" method="POST"
					class="form-horizontal">
				
			<div class="form-group">
				<label class="col-sm-2 control-label">Physician Name:</label>
				<div class="col-sm-5">
					<form:input path="physicianName" 
								 type="text" class="form-control" 
								 id="name" 
								 value = "doctorObj['physicianName']"/>
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


</form:form>
		
	
	



