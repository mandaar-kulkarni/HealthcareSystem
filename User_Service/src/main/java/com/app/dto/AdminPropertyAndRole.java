package com.app.dto;

import com.app.pojos.Patient;
import com.app.pojos.User;

public class AdminPropertyAndRole {
	
	private User user;
	private String role;
	public AdminPropertyAndRole(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
