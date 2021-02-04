package com.app.service;

import java.util.List;

import com.app.pojos.Appointment;
import com.app.pojos.Doctor;
import com.app.pojos.Medicine;
import com.app.pojos.Prescription;

public interface IDoctorService {

	List<Appointment> getAppointmentByDoctorId(int id);
	
	void savePrescription(Prescription prescription,Medicine[] medicine,String appointmentTime);
	
	Doctor getDoctor(int id);
}
