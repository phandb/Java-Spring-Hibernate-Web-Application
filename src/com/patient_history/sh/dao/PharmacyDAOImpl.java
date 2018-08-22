package com.patient_history.sh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java_spring_hibernate.entity.Patient;
import com.java_spring_hibernate.entity.Pharmacy;

@Repository
public class PharmacyDAOImpl implements PharmacyDAO {
	
	//Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//No need to call @Transactional here since service layer will call it.
	public List<Pharmacy> getAllPharmacies() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Pharmacy> theQuery = currentSession.createQuery("from Pharmacy", Pharmacy.class);
		
		//Execute the query and get result list
		List<Pharmacy> listAllPharmacies = theQuery.getResultList();
		
		//return the reults
		return listAllPharmacies;
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

	@Override
	public void savePharmacy(Pharmacy thePharmacy, Patient thePatient) {
		// get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//add the patient to Pharmacy 
		thePharmacy.addPatient(thePatient);
		
		//Save new record and update existing record
		currentSession.saveOrUpdate(thePharmacy);
		
	}
	
	@Override
	public Pharmacy getSelectedPharmacy(int thePharmacyId) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve or read data from database via id
		Pharmacy thePharmacy = currentSession.get(Pharmacy.class, thePharmacyId);
		
		//return result set
		return thePharmacy;
	}
	
	@Override
	public void deletePharmacy(int thePharmacyId, int thePatientId) {
		//get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a native string query for deleting pharmacy for specific patient
		String nativeSql = "DELETE FROM patient_pharmacy WHERE pharmacy_id=:pharmacyId AND patient_id=:patientId";
		
		//delete the object with pharmacu ID
		NativeQuery nativeQuery = currentSession.createNativeQuery(nativeSql);
		nativeQuery.setParameter("pharmacyId", thePharmacyId);
		nativeQuery.setParameter("patientid", thePatientId);
		
		//execute the query
		nativeQuery.executeUpdate();
	}

}
