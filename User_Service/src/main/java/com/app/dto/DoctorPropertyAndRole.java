package com.app.dto;

import com.app.pojos.Doctor;
import com.app.pojos.Patient;
import com.app.pojos.User;

public class DoctorPropertyAndRole {
	
	private Doctor doctor;
	private String role;
	public DoctorPropertyAndRole(Doctor doctor, String role) {
		super();
		this.doctor = doctor;
		this.role = role;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
