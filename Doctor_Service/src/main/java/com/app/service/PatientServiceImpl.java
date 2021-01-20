package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.dao.AppointmentRepository;
import com.app.dao.DoctorRepository;
import com.app.dao.MedicineRepository;
import com.app.dao.PatientRepository;
import com.app.dao.PrescriptionRepository;
import com.app.pojos.Appointment;
import com.app.pojos.Medicine;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;

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
	
//	@Override
//	public Patient getPatientByEmailid(String emailid) {
//		return patientDao.findByEmailId(emailid);
//	}
//
//	@Override
//	public Patient savePatient(Patient patient) {
//		return patientDao.save(patient);
//	}
//
//	@Override
//	public List<Appointment> getAppointmentByPatientId(Patient patient) {
//		return appointmentDao.findAllByPatient(patient);
//	}

	@Override
	public Patient getPatient(Integer id) {
		return patientDao.findById(id).get();
	}

	@Override
	public List<Medicine> getPrescriptionByPatientId(Patient patient) {
		
		List<Prescription> list=prescriptionDao.findAllByPatient(patient);
		if(list.isEmpty()) {
			throw new ResourceNotFoundException("Non prescription available for this patient");
		}else {
			List<Medicine> medicineList=new ArrayList<>();
			for(Prescription p:list) {
				medicineList.addAll(medicineDao.findAllByPrescriptionId(p));
			}
			return medicineList;
		}
	}

	
	
}
