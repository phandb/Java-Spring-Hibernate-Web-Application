package com.patient_history.sh.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java_spring_hibernate.entity.Medication;
import com.java_spring_hibernate.entity.Patient;

@Repository
public class MedicationDAOImpl implements MedicationDAO {
	
	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//No need to call @Transactional here since service layer will call it.
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
	/*
	@Override
	public List<Patient> getSelectedPatient(List<Patient> selectedPatient){
		return selectedPatient;
	}*/

	@Override
	public List<Medication> getMedication(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//create a query
		Query theQuery = currentSession.createQuery("select pat, med"
													+ " from Medication as med"
													+ " inner join  med.patient as pat"
													+ " with med.patient.id = :patientId ");
																
		
		theQuery.setParameter("patientId", theId);
		
		//execute the query and get result list
		//List<Medication> thePatientMedications = new ArrayList<Medication>();
		
		
		//List<Patient> thePatient = new ArrayList<Patient>();
		
		List<Medication> thePatientMedication = theQuery.getResultList();
		
		
		
		//return the results
		return thePatientMedication;
	}
	

}
