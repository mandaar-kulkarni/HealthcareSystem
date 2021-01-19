package com.app.service;

import java.util.List;

import com.app.pojos.Appointment;
import com.app.pojos.Medicine;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;


public interface IPatientService {
	Patient getPatientByEmailid(String emailid);
	
	Patient savePatient(Patient patient);
	
	List<Appointment> getAppointmentByPatientId(Patient patient);
	
	Patient getPatient(Integer id);
	
	List<Medicine> getPrescriptionByPatientId(Patient patient);
}
