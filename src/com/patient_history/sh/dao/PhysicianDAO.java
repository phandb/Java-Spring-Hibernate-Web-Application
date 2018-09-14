package com.patient_history.sh.dao;

import java.util.List;

import com.java_spring_hibernate.entity.Patient;
import com.java_spring_hibernate.entity.Physician;

public interface PhysicianDAO {
	public List<Physician> getAllPhysicians();

	public List<Physician> getPhysicians(int thePatientId);

	public void savePhysician(Physician thePhysician, Patient thePatient);

	public Physician getSelectedPhysician(int thePhysicianId);

	public void deletePhysician(int thePhysicianId, int thePatientId);

}
