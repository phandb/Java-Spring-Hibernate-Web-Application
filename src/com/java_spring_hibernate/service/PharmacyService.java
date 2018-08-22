package com.java_spring_hibernate.service;

import java.util.List;

import com.java_spring_hibernate.entity.Patient;
import com.java_spring_hibernate.entity.Pharmacy;

public interface PharmacyService {
	public List<Pharmacy> getAllPharmacies();

	public List<Pharmacy> getPharmacy(int thePatientId);

	public void savePharmacy(Pharmacy thePharmacy, Patient thePatient);

	public Pharmacy getSelectedPharmacy(int thePharmacyId);

	public void deletePharmacy(int thePharmacyId, int thePatientId);
	

}
