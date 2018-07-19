package com.java_spring_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java_spring_hibernate.entity.Pharmacy;
import com.patient_history.sh.dao.PharmacyDAO;


@Service
public class PharmacyServiceImpl implements PharmacyService {
	
	//need to inject pharmacy DAO
	@Autowired
	private PharmacyDAO pharmacyDAO;
	
	@Override
	@Transactional
	public List<Pharmacy> getPharmacies() {
		// 
		return pharmacyDAO.getPharmacies();
	}

}
