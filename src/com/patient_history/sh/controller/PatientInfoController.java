package com.patient_history.sh.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java_spring_hibernate.entity.Medication;
import com.java_spring_hibernate.entity.Patient;
import com.java_spring_hibernate.entity.Pharmacy;
import com.java_spring_hibernate.entity.Physician;
import com.java_spring_hibernate.service.MedicationService;
import com.java_spring_hibernate.service.PatientService;
import com.java_spring_hibernate.service.PharmacyService;
import com.java_spring_hibernate.service.PhysicianService;

@Controller
@Scope("session")
@RequestMapping("/patient")
public class PatientInfoController {
	
	private static int patient_id;
	//need to inject  services
	
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private MedicationService medicationService;
	@Autowired
	private PharmacyService pharmacyService;
	@Autowired
	private PhysicianService physicianService;
	
	@GetMapping("/viewPatientInfo")
	public String listMedications(@RequestParam("patientId") int thePatientId,  Model theModel) {
		
		patient_id = thePatientId;
		
		//get the patient medication from our service
		List<Medication> thePatientMedications = medicationService.getMedication(thePatientId);
		List<Pharmacy> thePharmacy = pharmacyService.getPharmacy(thePatientId);
		List<Physician> thePhysicians = physicianService.getPhysician(thePatientId);
		
		//Prepare list patient and medication
		List<Patient> thePatient = new ArrayList<Patient>();
		List<Medication> theMedications = new ArrayList<Medication>();
		
		
		//Separate patient and medications
		
				
		Iterator rows = thePatientMedications.iterator();
		while (rows.hasNext()) {
			Object[] row = (Object[]) rows.next();
			
			Patient selectedPatient = (Patient)row[0];
			thePatient.add(selectedPatient);
			
			Medication patientMedications = (Medication)row[1];
			theMedications.add(patientMedications);
		}
		
		
		//set medications as a model attribute to populate info
		theModel.addAttribute("selectedPatient", thePatient);
		theModel.addAttribute("medications", theMedications);
		theModel.addAttribute("pharmacies", thePharmacy);
		theModel.addAttribute("physicians",  thePhysicians);
		
		//Send over to the patient info form
		return "patient-info";
	}
	
	/********************* Medication CRUD 
	 * @param <CMDBean>**************************************/


	@GetMapping("/addPrescriptionForm")
	//Method name should match the name of URI onclick="window.location.href='addMedicationForm'
	public <CMDBean> String addMedicationForm(@RequestParam("patientId") int patientId, Model theModel) {
		
		
		//patient_id = patientId;
		//create model attribute to bind form data
		Medication thePrescription = new Medication();
		//get the patient from our service
		//Patient thePatient = patientService.getPatient(patientId);
		
		theModel.addAttribute("prescription", thePrescription);
		theModel.addAttribute("selectedPatientId", patientId);
		return "prescription-form";
	}
	
	@PostMapping("savePrescription") 
	//the "savePrescription" must be matched up with the one in the form action
	public String saveMedication(@ModelAttribute("prescription") Medication thePrescription,
								 @RequestParam("selectedPatientId") int thePatientId) {
		
		
		//get the patient from our service
		Patient thePatient = patientService.getPatient(thePatientId);
		//the model attribute "patient" must match with the one defined the form
		
		//save new patient using our service
		patientService.savePatient(thePatient);
		medicationService.saveMedication(thePrescription, thePatient);
		//patientService.savePatient(thePatient);
		
		return "redirect:/patient/viewPatientInfo?patientId=" + patient_id ;
	}
	
	
	
	@GetMapping("/updatePrescriptionForm")
	public String updatePrescriptionForm(@RequestParam("prescriptionId") int thePrescriptionId, 
										@RequestParam("selectedPatientId") int thePatientId,
									   Model theModel) {
		//patient_id = thePatientId;
		//get the medication from our service
		Medication thePrescription = medicationService.getSelectedPrescription(thePrescriptionId);
		
		//set prescriptiont as a model attribute to pre-populate the form
		theModel.addAttribute("prescription", thePrescription);
		theModel.addAttribute("selectedPatientId", thePatientId);
		//send over to  our form
		
		return "prescription-form" ;
	}
	
	
	
	@GetMapping("/deletePrescription")
	public String deletePrescription(@RequestParam("prescriptionId") int theId) {
		//delete the patient
		medicationService.deletePrescription(theId);
		return "redirect:/patient/viewPatientInfo?patientId=" + patient_id ;
	}
	
	
	/********************* Physician CRUD **************************************/


	@GetMapping("/addPhysicianForm")
	//Method name should match the name of URI onclick="window.location.href='addPhysicianForm'
	public String addPhysicianForm(@RequestParam("patientId") int patientId, Model theModel) {
		
		//create model attribute to bind form data
		Physician thePhysician = new Physician();
		
		theModel.addAttribute("physician", thePhysician);
		theModel.addAttribute("selectedPatientId", patientId);
		return "physician-form";
	}
	
		
	@PostMapping("/savePhysician") //the "savePatient" must be matched up with the one in the form action
	public String savePhysician(@ModelAttribute("physician") Physician thePhysician,
							    @RequestParam("selectedPatientId") int thePatientId) {

		//get the patient from our service
		Patient thePatient = patientService.getPatient(thePatientId);
		
		//save patient using our service
		patientService.savePatient(thePatient);
		physicianService.savePhysician(thePhysician, thePatient);
		
		return "redirect:/patient/viewPatientInfo?patientId=" + patient_id;
	}
		
	@GetMapping("/updatePhysicianForm")
	public String updatePhysicianForm(@RequestParam("physicianId") int thePhysicianId,
								      @RequestParam("selectedPatientId") int thePatientId,
								      Model theModel) {
		
		//get physician from our service
		Physician thePhysician = physicianService.getSelectedPhysician(thePhysicianId);
		
		//set seleted physican and patient as a model attribute to pre-populate the form
		theModel.addAttribute("physician", thePhysician);
		theModel.addAttribute("selectedPatientId", thePatientId);
		//send over to  our form
		
		return "physician-form";
	}
	
	
	
	@GetMapping("/deletePhysician")
	public String deletePhysician(@RequestParam("physicianId") int thePhysicianId,
								  @RequestParam("selectedPatientId") int thePatientId) {
		//delete the patient
		physicianService.deletePhysician(thePhysicianId, thePatientId);
		return "redirect:/patient/viewPatientInfo?patientId=" + patient_id;
	}
	

	/********************* Pharmacy CRUD **************************************/


	@GetMapping("/addPharmacyForm")
	//Method name should match the name of URI onclick="window.location.href='addMedicationForm'
	public <CMDBean> String addPharmacyForm(@RequestParam("patientId") int patientId, Model theModel) {
		
		List<Pharmacy> listAllPharmacies = pharmacyService.getAllPharmacies();
		//patient_id = patientId;
		//create model attribute to bind form data
		Pharmacy thePharmacy = new Pharmacy();
		
		theModel.addAttribute("listAllPharmacies", listAllPharmacies);
		theModel.addAttribute("pharmacy", thePharmacy);
		theModel.addAttribute("selectedPatientId", patientId);
		return "pharmacy-form";
	}
	

	
	
	@PostMapping("/savePharmacy") 
	//the "savePharmacy" must be matched up with the one in the form action
	public String savePharmacy(@ModelAttribute("pharmacy") Pharmacy thePharmacy,
								 @RequestParam("selectedPatientId") int thePatientId) {
		//Check pharmacy name for existing
		//if(thePharmacy.getPharmacyName() = )
		
		//get the patient from our service
		Patient thePatient = patientService.getPatient(thePatientId);
		
		//the model attribute "patient" must match with the one defined the form
		
		//save new patient using our service
		patientService.savePatient(thePatient);
		pharmacyService.savePharmacy(thePharmacy, thePatient);
		//patientService.savePatient(thePatient);
		
		return "redirect:/patient/viewPatientInfo?patientId=" + patient_id ;
	}
	
	@GetMapping("/updatePharmacyForm")
	public String updatePharmacyForm(@RequestParam("pharmacyId") int thePharmacyId, 
										@RequestParam("selectedPatientId") int thePatientId,
									   Model theModel) {
		//patient_id = thePatientId;
		//get the medication from our service
		Pharmacy thePharmacy = pharmacyService.getSelectedPharmacy(thePharmacyId);
		
		//set prescriptiont as a model attribute to pre-populate the form
		theModel.addAttribute("pharmacy", thePharmacy);
		theModel.addAttribute("selectedPatientId", thePatientId);
		//send over to  our form
		
		return "pharmacy-form" ;
	}
	
	
	
	@GetMapping("/deletePharmacy")
	public String deletePrescription(@RequestParam("pharmacyId") int thePharmacyId,
									 @RequestParam("selectedPatientId") int thePatientId) {
		//delete the patient
		pharmacyService.deletePharmacy(thePharmacyId, thePatientId);
		return "redirect:/patient/viewPatientInfo?patientId=" + patient_id ;
	}
	
	
	

}
