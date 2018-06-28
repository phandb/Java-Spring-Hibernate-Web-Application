package com.patient_history.sh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java_spring_hibernate.entity.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO {
	
	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Patient> getPatients() {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query
		Query<Patient> theQuery = currentSession.createQuery("from Patient", Patient.class);
		
		//execute query and get result list
		List<Patient> patients = theQuery.getResultList();
		
		//return the results
		
		return patients;
	}

}
