package com.java_spring_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java_spring_hibernate.entity.Patient;
import com.patient_history.sh.dao.PatientDAO;


//Service annotation
@Service
public class PatientServiceImpl implements PatientService {

	//need to inject patient DAO
	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	@Transactional  //Define transactions at Service layer
	public List<Patient> getPatients() {
		
		return patientDAO.getPatients();
	}

}
