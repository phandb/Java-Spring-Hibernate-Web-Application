package com.java_spring_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java_spring_hibernate.entity.Medication;
import com.java_spring_hibernate.entity.Patient;
import com.patient_history.sh.dao.MedicationDAO;

@Service
public class MedicationServiceImpl implements MedicationService {
	
	//need to inject  Medication DAO
	@Autowired
	private MedicationDAO medicationDAO;
	
	@Override
	@Transactional
	public List<Medication> getMedications(){
		
		//
		return medicationDAO.getMedications();
	}

	@Override
	@Transactional
	public List<Medication> getMedication(int theId) {
		
		return medicationDAO.getMedication(theId);
	}
	/*
	@Override
	@Transactional
	public List<Patient> getSelectedPatient(List<Patient> thePatient){
		return medicationDAO.getSelectedPatient(thePatient);
	}
	*/

	@Override
	@Transactional
	public void saveMedication(Medication thePrescription, Patient thePatient) {
		medicationDAO.saveMedication(thePrescription, thePatient);
		
	}

	@Override
	@Transactional
	public Medication getSelectedPrescription(int theId) {
		
		
		return medicationDAO.getSelectedPrescription(theId);
	}

	@Override
	@Transactional
	public void deletePrescription(int thePrescriptionId) {
		medicationDAO.deletePrescription(thePrescriptionId);
		
	}
}
