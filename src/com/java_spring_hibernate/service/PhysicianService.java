package com.java_spring_hibernate.service;

import java.util.List;

import com.java_spring_hibernate.entity.Patient;
import com.java_spring_hibernate.entity.Physician;

public interface PhysicianService {
	public List<Physician> getAllPhysicians();
	
	public List<Physician> getPhysician(int thePatientId);

	public void savePhysician(Physician thePhysician, Patient thePatient);

	public Physician getSelectedPhysician(int thePhysicianId);

	public void deletePhysician(int thePhysicianId, int thePatientId);

}
