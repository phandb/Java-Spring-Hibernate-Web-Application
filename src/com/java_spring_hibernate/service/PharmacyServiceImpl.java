package com.java_spring_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java_spring_hibernate.entity.Patient;
import com.java_spring_hibernate.entity.Pharmacy;
import com.patient_history.sh.dao.PharmacyDAO;


@Service
public class PharmacyServiceImpl implements PharmacyService {
	
	//need to inject pharmacy DAO
	@Autowired
	private PharmacyDAO pharmacyDAO;
	
	
	@Override
	@Transactional
	public List<Pharmacy> getAllPharmacies() {
		// 
		return pharmacyDAO.getAllPharmacies();
	}

	@Override
	@Transactional
	public List<Pharmacy> getPharmacy(int thePatientId) {
		// 
		return pharmacyDAO.getPharmacies(thePatientId);
	}

	@Override
	@Transactional
	public void savePharmacy(Pharmacy thePharmacy, Patient thePatient) {
	
		pharmacyDAO.savePharmacy(thePharmacy, thePatient);
		
	}

	@Override
	@Transactional
	public Pharmacy getSelectedPharmacy(int thePharmacyId) {
		
		return pharmacyDAO.getSelectedPharmacy(thePharmacyId);
	}

	@Override
	@Transactional
	public void deletePharmacy(int thePharmacyId, int thePatientId) {
		pharmacyDAO.deletePharmacy(thePharmacyId, thePatientId);
		
	}

}
