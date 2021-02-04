package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.dto.*;
import com.app.pojos.*;
import com.app.service.*;
import com.sun.xml.bind.v2.schemagen.xmlschema.Appinfo;

@RestController
@RequestMapping("/patient")
@Validated
@CrossOrigin
public class PatientController {

	@Autowired
	IPatientService patientService;

	@Autowired
	IUserService userService;

	@Autowired
	IDoctorService doctorService;

	public PatientController() {

	}

	@PostMapping
	public ResponseEntity<?> savePatient(@RequestBody Trail t) {
		Patient p = t.getPatient();
		User u = t.getUser();
		System.out.println(p + " " + u);
		Patient savedPatient = patientService.savePatient(p);
		User savedUser = userService.saveUser(u);
		if (savedPatient.getPatientId() > 0 && savedUser.getUserId() > 0) {
			return ResponseEntity.ok(savedPatient);
		}
		throw new ResourceNotFoundException("Error while saving patient please try again");
	}

	@GetMapping("/getAppointmentList/{id}")
	public ResponseEntity<?> getAppointmentByPatientId(@PathVariable int id) {
		if (id > 0) {
			List<Appointment> appointmentList = patientService.getAppointmentByPatientId(patientService.getPatient(id));
			if (appointmentList.isEmpty())
				throw new ResourceNotFoundException("List is empty");
			else
				return ResponseEntity.ok(appointmentList);
		}
		throw new ResourceNotFoundException("Please enter valid patient id");

	}

	@GetMapping("/getPrescription/{id}")
	public ResponseEntity<?> getPrescriptionByPatientId(@PathVariable int id) {
		if (id > 0) {
			List<Medicine> prescriptionList = patientService.getPrescriptionByPatientId(patientService.getPatient(id));
			if (prescriptionList.isEmpty())
				throw new ResourceNotFoundException("Prescription list is empty");
			else
				return ResponseEntity.ok(prescriptionList);
		}
		throw new ResourceNotFoundException("please enter valid patient id");
	}

	@GetMapping("/getDoctorBySpecification/{spec}")
	public ResponseEntity<?> getDoctorsBySpecification(@PathVariable String spec) {
		List<Doctor> listOfDoctors = doctorService.getDoctorBySpec(spec);
		//System.out.println(listOfDoctors);
		if (listOfDoctors.isEmpty())
			throw new ResourceNotFoundException("No doctor available");
		else
			return ResponseEntity.ok(listOfDoctors);
	}
	
	@PostMapping("/bookAppointment")
	public String bookAppointment(@RequestBody AppointmentDTO appointment){
		
		System.out.println(appointment);
		if(appointment ==null) {
			throw new ResourceNotFoundException("Booking Failed!!");
		}
		String message = patientService.checkAndSaveAppointment(appointment);
		return message;
	}
}
