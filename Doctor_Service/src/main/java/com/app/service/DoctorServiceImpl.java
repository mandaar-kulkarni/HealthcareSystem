package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.dao.AppointmentRepository;
import com.app.dao.DoctorRepository;
import com.app.dao.MedicineRepository;
import com.app.dao.PatientRepository;
import com.app.dao.PrescriptionRepository;
import com.app.pojos.Appointment;
import com.app.pojos.Department;
import com.app.pojos.Doctor;
import com.app.pojos.Medicine;
import com.app.pojos.Prescription;

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
			return appointmentDao.findAllByDoctor(doctor.get());
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
