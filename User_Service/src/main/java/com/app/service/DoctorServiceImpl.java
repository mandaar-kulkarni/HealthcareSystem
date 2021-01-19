package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DoctorRepository;
import com.app.pojos.Department;
import com.app.pojos.Doctor;

@Service
@Transactional
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	DoctorRepository doctorDao;

	@Override
	public Doctor getDoctorByEmailId(String emailid) {
		return doctorDao.findByEmailId(emailid);
	}

	@Override
	public List<Doctor> getDoctorBySpec(String spec) {
		return doctorDao.findAllBySpecialization(Department.valueOf(spec));
	}
	
	
	
}
