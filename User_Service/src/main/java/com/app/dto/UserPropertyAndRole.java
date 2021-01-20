package com.app.dto;

import com.app.pojos.Patient;

public class UserPropertyAndRole {
	
	private Patient patient;
	private String role;
	public UserPropertyAndRole(Patient patient, String role) {
		super();
		this.patient = patient;
		this.role = role;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
