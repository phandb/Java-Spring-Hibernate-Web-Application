package com.patient_history.sh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java_spring_hibernate.entity.Patient;
import com.java_spring_hibernate.service.PatientService;
import com.patient_history.sh.dao.PatientDAO;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	//need to inject  the patient service
	
	@Autowired
	private PatientService patientService;
	
	//@RequestMapping("/list")
	
	//changed to only response to get request
	@GetMapping("/list")
	public String listPatients(Model theModel) {
		//list-patients.jsp
		
		//get patients from the service
		List<Patient> thePatients = patientService.getPatients();
		
		//add the patients to the model
		theModel.addAttribute("patients", thePatients);
		return "list-patients";
		
	}
	
	@GetMapping("/addPatientForm")
	public String addPatientForm(Model theModel) {
		
		//create model attribute to bind form data
		Patient thePatient = new Patient();
		
		theModel.addAttribute("patient", thePatient);
		return "patient-form";
	}
	
	@PostMapping("/savePatient") //the "savePatient" must be matched up with the one in the form action
	public String savePatient(@ModelAttribute("patient") Patient thePatient) {
		//the model attribute "patient" must match with the one defined in the form
		
		//save new patient using our service
		patientService.savePatient(thePatient);
		
		return "redirect:/patient/list";
	}

}
