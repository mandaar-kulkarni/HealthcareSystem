package com.app.dto;

import com.app.pojos.Patient;
import com.app.pojos.User;

public class Trail {

	private Patient patient;
	private User user;
	
	public Trail(){
		
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
