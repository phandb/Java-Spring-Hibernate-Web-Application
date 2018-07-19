package com.patient_history.sh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java_spring_hibernate.entity.Medication;
import com.java_spring_hibernate.entity.Patient;
import com.java_spring_hibernate.service.MedicationService;
import com.java_spring_hibernate.service.PatientService;
import com.java_spring_hibernate.service.PharmacyService;
import com.java_spring_hibernate.service.PhysicianService;

@Controller
@RequestMapping("/patient")
public class PatientInfoController {
	
	
	//need to inject  the patient service
	
	
	@Autowired
	private MedicationService medicationService;
	
	@GetMapping("/viewPatientInfo")
	public String listMedications(@RequestParam("patientId") int thePatientId, Model theModel) {
		
		//get the patient medication from our service
		List<Medication> theMedications = medicationService.getMedication(thePatientId);
		
			
		//set medications as a model attribute to populate info
		theModel.addAttribute("medications", theMedications);
		
		//Send over to the patient info form
		return "patient-info";
	}

}
