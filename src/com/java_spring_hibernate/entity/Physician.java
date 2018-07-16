package com.java_spring_hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="physicians")
public class Physician {
	
	//annotate the class as an entity and map to database table

	//define the fields
	//annotate the fields with db column names
	/***
	 * Set up relationship with patients table using FK patient_id
	 */
	//create constructors
	//generate getter/setter methods
	//generate toString() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String physicanName;
	
	@Column(name="phone")
	private String physicianPhone;
	
	@Column(name="address")
	private String physicianAddress;
	
	@Column(name="specialty")
	private String physicianSpecialty;
	
	
	//Relationship with patients table
	//a doctor can have many patients
	//No delete cascade type.  Can't not delete doctor once a patient is deleted
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	//Constructors
	public Physician() {
		
	}

	/**
	 * @param physicanName
	 * @param physicianPhone
	 * @param physicianAddress
	 * @param physicianSpecialty
	 */
	public Physician(String physicanName, String physicianPhone, String physicianAddress, String physicianSpecialty) {
		this.physicanName = physicanName;
		this.physicianPhone = physicianPhone;
		this.physicianAddress = physicianAddress;
		this.physicianSpecialty = physicianSpecialty;
	}
	
	//Define getter and setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhysicanName() {
		return physicanName;
	}

	public void setPhysicanName(String physicanName) {
		this.physicanName = physicanName;
	}

	public String getPhysicianPhone() {
		return physicianPhone;
	}

	public void setPhysicianPhone(String physicianPhone) {
		this.physicianPhone = physicianPhone;
	}

	public String getPhysicianAddress() {
		return physicianAddress;
	}

	public void setPhysicianAddress(String physicianAddress) {
		this.physicianAddress = physicianAddress;
	}

	public String getPhysicianSpecialty() {
		return physicianSpecialty;
	}

	public void setPhysicianSpecialty(String physicianSpecialty) {
		this.physicianSpecialty = physicianSpecialty;
	}

	

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Physician [id=" + id + ", physicanName=" + physicanName + ", physicianPhone=" + physicianPhone
				+ ", physicianAddress=" + physicianAddress + ", physicianSpecialty=" + physicianSpecialty + "]";
	}
	
	
	
	

}
