package com.java_spring_hibernate.service;

import java.util.List;

import com.java_spring_hibernate.entity.Medication;

public interface MedicationService {
	
	public List<Medication> getMedications();

	public List<Medication> getMedication(int theId);
}
