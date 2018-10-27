$(document).ready(function() {
	
	// var doctorObj = new Object
	$("#selectedDoctor option").filter(function(){
		
		return $(this).val() == $("#name").val();
	}).attr('selected', true);
	
	 $("#selectedDoctor").change(function(){ //wrap doctor drop down and binds change handler
		
		 var doctorObj = JSON.parse($(this).val());
		 //alert(doctorObj.physicianId);
		 $("#name").val(doctorObj.physicianName);
		 $("#specialty").val(doctorObj.physicianSpecialty);
		 $("#phone").val(doctorObj.physicianPhone);
		 $("#address").val(doctorObj.physicianAddress);
	
	 });	
	
});
