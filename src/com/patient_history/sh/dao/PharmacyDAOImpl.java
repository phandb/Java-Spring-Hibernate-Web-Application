package com.patient_history.sh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java_spring_hibernate.entity.Pharmacy;

@Repository
public class PharmacyDAOImpl implements PharmacyDAO {
	
	//Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//No need to call @Transactional here since service layer will call it.
	public List<Pharmacy> getPharmacies() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Pharmacy> theQuery = currentSession.createQuery("from Pharmacy", Pharmacy.class);
		
		//Execute the query and get result list
		List<Pharmacy> pharmacies = theQuery.getResultList();
		
		//return the reults
		return pharmacies;
	}

	@Override
	public List<Pharmacy> getPharmacies(int thePatientId) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				//create a query
				Query theQuery = currentSession.createQuery("SELECT phar FROM Pharmacy phar"
														  + " JOIN phar.patients pat"
														  + " WHERE pat.id = :patientId");
				
				/*Query theQuery = currentSession.createQuery("select pat, med"
						+ " from Medication as med"
						+ " inner join  med.patient as pat"
						+ " with med.patient.id = :patientId "); */
									

				theQuery.setParameter("patientId", thePatientId);
				
				//Execute the query and get result list
				List<Pharmacy> pharmacies = theQuery.getResultList();
				
				//return the reults
				return pharmacies;
	}

}
