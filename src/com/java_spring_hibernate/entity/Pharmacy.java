package com.java_spring_hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	/***
	 * Set up One to One relationship with patients table using FK patient_id
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	
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

    

	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	//generate toString() method
	@Override
	public String toString() {
		return "Pharmacy [id=" + id + ", pharmacyName=" + pharmacyName + ", pharmacyPhone=" + pharmacyPhone
				+ ", pharmacyAddress=" + pharmacyAddress + ", patientId_FK=" + patient + "]";
	}

	
	
	

}
