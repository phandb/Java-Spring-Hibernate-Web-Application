package com.java_spring_hibernate.service;

import java.util.List;

import com.java_spring_hibernate.entity.Medication;
import com.java_spring_hibernate.entity.Patient;

public interface MedicationService {
	
	public List<Medication> getMedications();

	public List<Medication> getMedication(int theId);

	public void saveMedication(Medication thePrescription, Patient thePatient);

	public Medication getSelectedPrescription(int thePrescriptionId);

	public void deletePrescription(int thePrescriptionId);

	
}
