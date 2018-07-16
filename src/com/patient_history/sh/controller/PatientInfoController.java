package com.patient_history.sh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java_spring_hibernate.entity.Patient;
import com.java_spring_hibernate.service.PatientService;

@Controller
@RequestMapping("/")
public class PatientInfoController {
	
	
	//need to inject  the patient service
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("viewPatientInfo")
	public String viewPatientInfo(@RequestParam("patientId") int theId, Model theModel) {
		//get the patient information from the database
		Patient thePatient = patientService.getPatient(theId);
		
		//set medications as a model attribute to populate info
		theModel.addAttribute("medications", thePatient);
		
		//Send over to the patient info form
		return "patient-info-form";
	}

}
