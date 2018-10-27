package com.java_spring_hibernate.entity;

import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="physicians")
/*
@NamedQueries({
	@NamedQuery(name="Physician.getPatientPhysicianInfoById",
			query="select distinct phy from Physician phy " +
				   "left join fetch phy.patients pat " +
					" where pat.id = :patientId"),
	@NamedQuery(name="Physician.getAllPhysicians",
			query="from Physician phy")
	
	
}) 
*/
public class Physician implements Serializable{
	
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
	private String physicianName;
	
	@Column(name="phone")
	private String physicianPhone;
	
	@Column(name="address")
	private String physicianAddress;
	
	@Column(name="specialty")
	private String physicianSpecialty;
	
	/*****************************************************************/
	//Relationship with patients table
	//a doctor can have many patients, and  a patient can have many doctors
	//No delete cascade type.  Can't not delete doctor once a patient is deleted
	@ManyToMany(fetch = FetchType.EAGER,
				cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	
	@JoinTable(
			name="patients_physicians",
			joinColumns=@JoinColumn(name="physician_id"),
			inverseJoinColumns=@JoinColumn(name="patient_id")
			)
	private List<Patient> patients;
	
	
	/*****************************************************************/
	//Constructors
	public Physician() {
		
	}

	/**
	 * @param physicanName
	 * @param physicianPhone
	 * @param physicianAddress
	 * @param physicianSpecialty
	 */
	public Physician(String physicianName, String physicianPhone, String physicianAddress, String physicianSpecialty) {
		this.physicianName = physicianName;
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

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(String physicanName) {
		this.physicianName = physicanName;
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

	

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	
	//add a convenience method
	public void addPatientToPhysician(Patient thePatient) {
		if(patients == null) {
			patients = new ArrayList<>();
		}
		patients.add(thePatient);
	}

	@Override
	public String toString() {
		return "Physician [id=" + id + ", physicianName=" + physicianName + ", physicianPhone=" + physicianPhone
				+ ", physicianAddress=" + physicianAddress + ", physicianSpecialty=" + physicianSpecialty + "]";
	}
	
	
	
	

}
