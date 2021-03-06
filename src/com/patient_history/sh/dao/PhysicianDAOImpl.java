package com.patient_history.sh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java_spring_hibernate.entity.Patient;
import com.java_spring_hibernate.entity.Physician;

@Repository
public class PhysicianDAOImpl implements PhysicianDAO {

	//Need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//No need to call @Transactional here since service layer will call it.
	public List<Physician> getAllPhysicians() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Physician> theQuery = currentSession.createQuery("from Physician", Physician.class);
		
		//execute query and get result list
		List<Physician> listAllPhysicians = theQuery.getResultList();
		
		return listAllPhysicians;
	}

	@Override
	public List<Physician> getPhysicians(int thePatientId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
	
		Query<Physician> theQuery = currentSession.createQuery(" SELECT phy FROM Physician phy "
												+ " JOIN FETCH phy.patients pat "
												+ " WHERE pat.id = :patientId ", Physician.class);
		
		theQuery.setParameter("patientId", thePatientId);
		
		//Query<Physician> theQuery  = currentSession.getNamedQuery("Physician.getPatientPhysicianInfoById").setParameter("patientId",  thePatientId);
		
		
		//execute the query and get result list
		List<Physician> thePhysicians = theQuery.getResultList();
		
		//return result list																
		return thePhysicians;
	}
/*****************************************************************************************************/
	
	@Override
	public void savePhysician(Physician thePhysician, Patient thePatient) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//call the convenience method in Physician Class to add the patient to physician
		thePhysician.addPatientToPhysician(thePatient);
		
		//save or update either new or existing records
		//currentSession.save(thePhysician);
		currentSession.saveOrUpdate(thePhysician);
		
	}
	
			
	@Override
	public Physician getSelectedPhysician(int thePhysicianId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Retrieve/read data from database via id
		Physician thePhysician = currentSession.get(Physician.class,  thePhysicianId);
		
		//return result
		return thePhysician;
	}

		

	@Override
	public void deletePhysician(int thePhysicianId, int thePatientId) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//query
		String nativeSql = "DELETE FROM patients_physicians WHERE physician_id=:physicianId AND patient_id=:patientId";
		
		
			
		//delete object with physician ID
		NativeQuery<?> nativeQuery = currentSession.createNativeQuery(nativeSql);
		
		nativeQuery.setParameter("physicianId",  thePhysicianId);
		nativeQuery.setParameter("patientId",  thePatientId);
		
		nativeQuery.executeUpdate();
		
		
	}
	

}
