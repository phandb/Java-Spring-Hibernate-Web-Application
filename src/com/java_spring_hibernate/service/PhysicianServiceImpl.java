package com.java_spring_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
