package com.patient_history.sh.dao;

import java.util.List;

import com.java_spring_hibernate.entity.Pharmacy;

public interface PharmacyDAO {
	public List<Pharmacy> getPharmacies();

	public List<Pharmacy> getPharmacies(int thePatientId);

}
