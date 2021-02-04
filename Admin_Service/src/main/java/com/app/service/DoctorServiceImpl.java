package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.*;
import com.app.pojos.*;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepository docRepo;

	@Autowired
	private AppointmentRepository appRepo;

	@Override
	public Doctor addDoctor(Doctor d) {
		System.out.println("in add Doctor Method");
		return docRepo.save(d);
	}

	@Override
	public List<Appointment> getAppointment(Doctor doctor) {
		List<Appointment> listOfAppointment = appRepo.findAllByDoctor(doctor);
		return listOfAppointment;
	}

	@Override
	public Doctor getDoctor(int id) {
		return docRepo.findById(id).get();
	}

	@Override
	public void deleteDoctor(Doctor d) {
		docRepo.delete(d);
	}

	@Override
	public List<Doctor> getDoctorList() {
		return docRepo.findAllByStatus(1);
	}

	@Override
	public Doctor getDoctorByEmailId(String emailId) {
		return docRepo.findByEmailId(emailId);
	}

	
}
