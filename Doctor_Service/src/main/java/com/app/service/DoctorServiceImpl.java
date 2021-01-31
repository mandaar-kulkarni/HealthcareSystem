package com.app.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.dao.*;
import com.app.pojos.*;

@Service
@Transactional
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	DoctorRepository doctorDao;
	
	@Autowired
	AppointmentRepository appointmentDao;

	@Autowired
	PrescriptionRepository prescriptionDao;
	
	@Autowired
	MedicineRepository medicineDao;
	
	@Autowired
	PatientRepository patientDao;
	
	@Override
	public List<Appointment> getAppointmentByDoctorId(int id) {
		Optional<Doctor> doctor= doctorDao.findById(id);
		if(doctor.isPresent())
			return appointmentDao.findAllByDoctor(doctor.get(),LocalDate.now());
	 throw new ResourceNotFoundException("please enter valid doctor id/doctor not present");
	}

	@Override
	public void savePrescription(Prescription prescription, List<Medicine> medicine) {
		prescription.setDoctor(doctorDao.findById(prescription.getDoctor().getDoctorId()).get());
		prescription.setPatient(patientDao.findById(prescription.getPatient().getPatientId()).get());
		Prescription pre=prescriptionDao.save(prescription);
		for(Medicine m:medicine) {
			m.setPrescriptionId(pre);
		}
		medicineDao.saveAll(medicine); 
	}
	
	

	
	
}
