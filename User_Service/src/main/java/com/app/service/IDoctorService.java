package com.app.service;

import java.util.List;

import com.app.pojos.Doctor;

public interface IDoctorService {

	Doctor getDoctorByEmailId(String emaild);
	
	List<Doctor> getDoctorBySpec(String spec);
}
