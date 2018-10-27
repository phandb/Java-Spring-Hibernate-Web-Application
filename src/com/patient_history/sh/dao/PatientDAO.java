package com.patient_history.sh.dao;

import java.util.List;

import com.java_spring_hibernate.entity.Patient;


public interface PatientDAO {
	public List<Patient> getPatients();

	public void savePatient(Patient thePatient);

	public Patient getPatientById(int theId);

	public void deletePatient(int theId);

	public List<Patient> searchPatients(String theSearchName);

}
