package com.java_spring_hibernate.service;

import java.util.List;

import com.java_spring_hibernate.entity.Physician;

public interface PhysicianService {
	public List<Physician> getPhysicians();
	
	public List<Physician> getPhysician(int thePatientId);

}
