<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>


<html>

<head>
	<title>Save Patient</title>
	
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
	<div id="container">
		<h3>Save Patient</h3>
		<form:form action="savePatient" modelAttribute="patient" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /></td>
						
					</tr>
						
				</tbody>
			
			</table>
		
		</form:form>
	</div>
	


</body>


</html>