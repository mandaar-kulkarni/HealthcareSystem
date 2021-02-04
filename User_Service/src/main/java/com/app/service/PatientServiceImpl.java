package com.app.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.*;
import com.app.dto.*;
import com.app.pojos.*;

@Service
@Transactional
public class PatientServiceImpl implements IPatientService {

	@Autowired
	PatientRepository patientDao;

	@Autowired
	AppointmentRepository appointmentDao;

	@Autowired
	PrescriptionRepository prescriptionDao;

	@Autowired
	MedicineRepository medicineDao;
	
	@Autowired
	DoctorRepository doctorDao;

	@Override
	public Patient getPatientByEmailid(String emailid) {
		return patientDao.findByEmailId(emailid);
	}

	@Override
	public Patient savePatient(Patient patient) {
		return patientDao.save(patient);
	}

	@Override
	public List<Appointment> getAppointmentByPatientId(Patient patient) {
		return appointmentDao.findAllByPatient(patient);
	}

	@Override
	public Patient getPatient(Integer id) {
		return patientDao.findById(id).get();
	}

	@Override
	public List<Medicine> getPrescriptionByPatientId(Patient patient) {
		List<Prescription> list = prescriptionDao.findAllByPatient(patient);
		List<Medicine> medicineList = new ArrayList<>();
		for (Prescription p : list) {
			medicineList.addAll(medicineDao.findAllByPrescriptionId(p));
		}
		return medicineList;
	}

	@Override
	public String checkAndSaveAppointment(AppointmentDTO appointment) {
		Doctor doc=doctorDao.findById(appointment.getDoctorId()).get();
		Patient patient=patientDao.findById(appointment.getPatientId()).get();
		Appointment appt=appointmentDao.findByAppointmentTimeAndAppointmentDateAndDoctor(appointment.getAppointmentTime(),appointment.getAppointmentDate(),doc);
		if(appt == null) {
			Appointment bookAppointment=new Appointment();
			bookAppointment.setAppointmentTime(appointment.getAppointmentTime());
			bookAppointment.setAppointmentDate(appointment.getAppointmentDate());
			bookAppointment.setDoctor(doc);
			bookAppointment.setPatient(patient);
			appointmentDao.save(bookAppointment);
			return "Booked Successfully!!";
		}
		return "Slot already taken!!";
	}

}
