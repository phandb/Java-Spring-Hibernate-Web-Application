package com.patient_history.sh.dao;

import java.util.List;

import com.java_spring_hibernate.entity.Medication;

public interface MedicationDAO {
	
	public List<Medication> getMedications();

	public List<Medication> getMedication(int theId);
}
