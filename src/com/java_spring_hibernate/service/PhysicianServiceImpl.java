package com.java_spring_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java_spring_hibernate.entity.Patient;
import com.java_spring_hibernate.entity.Physician;
import com.patient_history.sh.dao.PhysicianDAO;

@Service
public class PhysicianServiceImpl implements PhysicianService {
	
	//Need to inject physician DAO
	@Autowired
	private PhysicianDAO physicianDAO;
	
	@Override
	@Transactional
	public List<Physician> getPhysicians() {
		return physicianDAO.getPhysicians();
	}

	@Override
	@Transactional
	public List<Physician> getPhysician(int thePatientId) {
		// TODO Auto-generated method stub
		return physicianDAO.getPhysicians(thePatientId);
	}

	@Override
	@Transactional
	public void savePhysician(Physician thePhysician, Patient thePatient) {
		physicianDAO.savePhysician(thePhysician, thePatient);
		
	}

	@Override
	@Transactional
	public Physician getSelectedPhysician(int thePhysicianId) {
		// TODO Auto-generated method stub
		return physicianDAO.getSelectedPhysician(thePhysicianId);
	}

	@Override
	@Transactional
	public void deletePhysician(int thePhysicianId, int thePatientId) {
		physicianDAO.deletePhysician(thePhysicianId, thePatientId);
		
	}

}
