package com.patient_history.sh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java_spring_hibernate.entity.Patient;
import com.patient_history.sh.dao.PatientDAO;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	//need to inject  the patient DAO
	@Autowired
	private PatientDAO patientDAO;
	
	@RequestMapping("/list")
	public String listPatients(Model theModel) {
		//list-patients.jsp
		
		//get patients from the DAO
		List<Patient> thePatients = patientDAO.getPatients();
		
		//add the patients to the model
		theModel.addAttribute("patients", thePatients);
		return "list-patients";
		
	}

}
