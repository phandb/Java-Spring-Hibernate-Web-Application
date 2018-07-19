package com.patient_history.sh.dao;

import java.util.ArrayList;
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

	@Override
	public List<Medication> getMedication(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
	/*
		String q = "FROM Medication AS M "
				+ " INNER JOIN Patient "
				+ " ON (M.patient = :patientId) ";  
	*/
			
		//create a query
		Query theQuery = currentSession.createQuery("select m.medicationName, m.medicationStrength, m.medicationDosage"
				+ " from Medication m INNER JOIN  m.patient = :patientId ");
																
		
		theQuery.setParameter("patientId", theId);
		
		//execute the query and get result list
		List<Medication> theMedications = new ArrayList<Medication>();
		
		//List<Medication> theMedications =theQuery.getResultList();
		
		List<Object[]> rows = theQuery.getResultList();
		
		for (Object[] row : rows) {
			Medication prescription = new Medication();
			prescription.setMedicationName(row[0].toString());
			prescription.setMedicationStrength(row[1].toString());
			prescription.setMedicationDosage(row[2].toString());
			theMedications.add(prescription);
			
		}
		
		//return the results
		return theMedications;
	}

}
