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

//Map entity class to database table
@Entity
@Table(name = "patients")
public class Patient {
	
	
	//Map to appropriate column in table patients
	//name = "column name" in database
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="date_of_birth")
	private String dateOfBirth;
	
	@Column(name="address")
	private String address;
	
	/*****************************************************************/
	
	//Mapping One to Many relationship with medications table
	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="patient_id")
	private List<Medication> medications;
	
	/*******************************************************************/
	//Mapping Many To Many relationship with physicians table
	@ManyToMany(fetch=FetchType.LAZY,
				cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						  CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="patients_physicians",
			joinColumns=@JoinColumn(name="patient_id"),
			inverseJoinColumns=@JoinColumn(name="physician_id")
			)
	private List<Physician> physicians;
	
	/*****************************************************************/
	//Mapping Many To Many relationship with pharmacies table
	//No CascadeType.REMOVE since we don't want to delete a patient
	@ManyToMany(fetch=FetchType.LAZY,
				cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						CascadeType.DETACH, CascadeType.REFRESH	})
	@JoinTable(
			name = "patient_pharmacy",
			joinColumns=@JoinColumn(name="patient_id"),
			inverseJoinColumns=@JoinColumn(name="pharmacy_id")
			)
	private List<Pharmacy> pharmacies;
	
	/*****************************************************************/
	
	
	
	//default constructor
	public Patient() {
		
	}
	
	public List<Pharmacy> getPharmacies() {
		return pharmacies;
	}


	public void setPharmacies(List<Pharmacy> pharmacies) {
		this.pharmacies = pharmacies;
	}


	//Getter and setter methods
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
	//Setter and getter for relationship with medications table 
	public List<Medication> getMedications() {
		return medications;
	}


	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}
	
	
	//Setter and getter for physicians


	public List<Physician> getPhysicians() {
		return physicians;
	}


	public void setPhysicians(List<Physician> physicians) {
		this.physicians = physicians;
	}


	//ToString method
	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", address="
				+ address + "]";
	}	
	/*
	
	//Add convenience methods for bi-directional relationship
	
	public void addPhysician(Physician tempPhysician) {
		if (physicians == null) {
			physicians = new ArrayList<>();
		}
		
		physicians.add(tempPhysician);
		
		//tempPhysician.setPatients(this);
	}
	
	*/
	
	//Convenience add medications method for uni-directional relationship
	public void addMedication(Medication theMedication) {
		if(medications == null) {
			medications = new ArrayList<>();
		}
		
		medications.add(theMedication);
		
	}
	

}
