package com.patient_history.sh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java_spring_hibernate.entity.Medication;

@Repository
public class MedicationDAOImpl implements MedicationDAO {
	
	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Medication> getMedications() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Medication> theQuery = currentSession.createQuery("from Medication", Medication.class);
		
		//execute the query and get result list
		List<Medication> medications =theQuery.getResultList();
		
		//return the results
		
		return medications;
	}

}
