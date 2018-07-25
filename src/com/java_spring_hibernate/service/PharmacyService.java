package com.java_spring_hibernate.service;

import java.util.List;

import com.java_spring_hibernate.entity.Pharmacy;

public interface PharmacyService {
	public List<Pharmacy> getPharmacies();

	public List<Pharmacy> getPharmacy(int thePatientId);
	

}
