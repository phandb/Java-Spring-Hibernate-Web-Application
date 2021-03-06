package com.patient_history.sh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
		Query<Medication> theQuery = currentSession.createQuery("SELECT med"
													+ " FROM Medication as med"
													+ " JOIN FETCH med.patient as pat"
													+ " Where pat.id = :patientId ", Medication.class);
										
		
		theQuery.setParameter("patientId", theId);
		
		//execute the query and get result list
		//List<Medication> thePatientMedications = new ArrayList<Medication>();
		
		
		//List<Patient> thePatient = new ArrayList<Patient>();
		
		List<Medication> theMedications = theQuery.getResultList();
		
		
		
		//return the results
		return theMedications;
	}

	@Override
	public void saveMedication(Medication thePrescription, Patient thePatient) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//the saveOrUpdate will either save new record or update existing record.  
		currentSession.saveOrUpdate(thePatient);
		currentSession.saveOrUpdate(thePrescription);
		
	}
	
	//This method will return info for selected prescription 
	@Override
	public Medication getSelectedPrescription(int thePrescriptionId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
				
		//Retrieve/read from database using primary key
		Medication thePrescription = currentSession.get(Medication.class, thePrescriptionId);
				
		//return the results
		return thePrescription;
	}
	

	@Override
	public void deletePrescription(int thePrescriptionId) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				//delete object with primary key
				Query<Medication> theQuery = currentSession.createQuery("delete from Medication where id=:prescriptionId ",
																		Medication.class);
				
				theQuery.setParameter("prescriptionId", thePrescriptionId);
				
				theQuery.executeUpdate();
		
	}
	
	
	

}
