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
	@Transactional
	public List<Physician> getPhysicians() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Physician> theQuery = currentSession.createQuery("from Physician", Physician.class);
		
		//execute query and get result list
		List<Physician> physicians = theQuery.getResultList();
		
		return physicians;
	}

}
