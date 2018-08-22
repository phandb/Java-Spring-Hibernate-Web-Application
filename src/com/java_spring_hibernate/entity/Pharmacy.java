package com.java_spring_hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//annotate the class as an entity and map to database table
@Entity
@Table(name="pharmacies")
public class Pharmacy {

	//define the fields
	//annotate the fields with db column names
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String pharmacyName;
	
	@Column(name="phone")
	private String pharmacyPhone;
	
	@Column(name="address")
	private String pharmacyAddress;
	
	/*********************************************************************
	 * Set up Many to One bidirectional relationship with patients table using FK patient_id
	 */
	/*
	@OneToMany(mappedBy="pharmacy",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH	})	
	private List<Patient> patients;   //represent patient_id FK
	
	*/
	/***************************************************************************/
	
	 // Set up Many to Many relationship with patients table using FK patient_id

	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH	})
	@JoinTable(
		name = "patient_pharmacy",
		joinColumns=@JoinColumn(name="pharmacy_id"),
		inverseJoinColumns=@JoinColumn(name="patient_id")
		)
	private List<Patient> patients;
	
	
	/***************************************************************************/
	
	//create constructors
	
	public Pharmacy() {
	
	}


	public Pharmacy(String pharmacyName, String pharmacyPhone, String pharmacyAddress) {
		this.pharmacyName = pharmacyName;
		this.pharmacyPhone = pharmacyPhone;
		this.pharmacyAddress = pharmacyAddress;
		
	}
	
	//generate getter/setter methods
	
	
	

	public int getId() {
		return id;
	}


	public List<Patient> getPatients() {
		return patients;
	}


	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPharmacyName() {
		return pharmacyName;
	}


	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}


	public String getPharmacyPhone() {
		return pharmacyPhone;
	}


	public void setPharmacyPhone(String pharmacyPhone) {
		this.pharmacyPhone = pharmacyPhone;
	}


	public String getPharmacyAddress() {
		return pharmacyAddress;
	}


	public void setPharmacyAddress(String pharmacyAddress) {
		this.pharmacyAddress = pharmacyAddress;
	}


	//add convenience methods for bi-directional relationship
	public void addPatient(Patient tempPatient) {
		if (patients == null) {
			patients = new ArrayList<>();
		}
		patients.add(tempPatient);
		
	}
	


	//generate toString() method
	@Override
	public String toString() {
		return "Pharmacy [id=" + id + ", pharmacyName=" + pharmacyName + ", pharmacyPhone=" + pharmacyPhone
				+ ", pharmacyAddress=" + pharmacyAddress + ", patientId_FK=" + patients + "]";
	}


	

	
	
	

}
