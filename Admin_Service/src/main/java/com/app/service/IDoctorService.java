package com.app.service;

import java.util.List;

import com.app.pojos.Appointment;
import com.app.pojos.Doctor;

public interface IDoctorService {
	Doctor addDoctor(Doctor d);
	
	Doctor getDoctor(int id);
	
	Doctor getDoctorByEmailId(String emailId);
	
	void deleteDoctor(Doctor d);
	
	List<Appointment> getAppointment(Doctor doctor);

	List<Doctor> getDoctorList();
}

