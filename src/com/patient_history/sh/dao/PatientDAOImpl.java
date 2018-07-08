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
	//removed  @Transactional so the Service layer start to call appropriate DAO. 
	//Service will now manage transactions
	public List<Patient> getPatients() {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query...and sort by last name
		Query<Patient> theQuery = currentSession.createQuery("from Patient order by last_name", Patient.class);
		
		//execute query and get result list
		List<Patient> patients = theQuery.getResultList();
		
		//return the results
		return patients;
	}

	@Override
	public void savePatient(Patient thePatient) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.save(thePatient);
		
	}

}
