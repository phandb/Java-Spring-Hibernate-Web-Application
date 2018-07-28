package com.patient_history.sh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java_spring_hibernate.entity.Physician;

@Repository
public class PhysicianDAOImpl implements PhysicianDAO {

	//Need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//No need to call @Transactional here since service layer will call it.
	public List<Physician> getPhysicians() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Physician> theQuery = currentSession.createQuery("from Physician", Physician.class);
		
		//execute query and get result list
		List<Physician> physicians = theQuery.getResultList();
		
		return physicians;
	}

	@Override
	public List<Physician> getPhysicians(int thePatientId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		/*
		 * SELECT phy.id, phy.name,  phy.specialty, phy.phone, phy.address
FROM physicians AS phy
INNER JOIN patients_physicians AS pp
ON (phy.id = pp.physician_id )
INNER JOIN patients AS pat 
ON (pat.id = pp.patient_id AND  pp.patient_id=7);
		 * 
		 * */
		/*
		Query theQuery = currentSession.createNativeQuery("SELECT phy.id, phy.name,  phy.specialty, phy.phone, phy.address"
				+ " FROM physicians AS phy"
				+ " INNER JOIN patients_physicians AS pp"
				+ " ON (phy.id = pp.physician_id )"
				+ " INNER JOIN patients AS pat "
				+ " ON (pat.id = pp.patient_id AND  pp.patient_id = :patientId)");
		*/
		
		Query theQuery = currentSession.createQuery(" SELECT phy FROM Physician phy"
												+ " JOIN phy.patients pat"
												+ " WHERE pat.id = :patientId ");
		
		theQuery.setParameter("patientId",  thePatientId);
		
		//execute the query and get result list
		List<Physician> thePhysicians = theQuery.getResultList();
		
		//return result list																
		return thePhysicians;
	}

}
