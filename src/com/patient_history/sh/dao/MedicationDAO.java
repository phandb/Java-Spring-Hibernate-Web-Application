package com.patient_history.sh.dao;

import java.util.List;

import com.java_spring_hibernate.entity.Medication;
import com.java_spring_hibernate.entity.Patient;

public interface MedicationDAO {
	
	public List<Medication> getMedications();

	public List<Medication> getMedication(int theId);

	//public List<Patient> getSelectedPatient(List<Patient> selectedPatient);
	//public List<Patient> getSelectedPatient(int theId);

}
