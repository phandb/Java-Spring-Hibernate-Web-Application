$(document).ready(function(){
	$("#selectedPharmacy option").filter(function(){
		
		return $(this).val() == $("#name").val();
	}).attr('selected', true);
	$("#selectedPharmacy").change(function(){
		var pharmacyObj =JSON.parse($(this).val());
		//alert(pharmacyObj.pharmacyName);
		
		$("#name").val(pharmacyObj.pharmacyName);
		$("#phone").val(pharmacyObj.pharmacyPhone);
		$("#address").val(pharmacyObj.pharmacyAddress);
	});
});