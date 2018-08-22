package com.patient_history.sh.dao;

import java.util.List;

import com.java_spring_hibernate.entity.Patient;
import com.java_spring_hibernate.entity.Pharmacy;

public interface PharmacyDAO {
	public List<Pharmacy> getAllPharmacies();

	public List<Pharmacy> getPharmacies(int thePatientId);

	public void savePharmacy(Pharmacy thePharmacy, Patient thePatient);

	Pharmacy getSelectedPharmacy(int thePharmacyId);

	void deletePharmacy(int thePharmacyId, int thePatientId);

}
