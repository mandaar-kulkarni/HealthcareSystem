package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.dto.MedPres;
import com.app.dto.PrescriptionMedicineDTO;
import com.app.pojos.*;
import com.app.service.IDoctorService;
import com.app.service.IPatientService;

@RestController
@RequestMapping("/doctor")
@Validated
@CrossOrigin
public class DoctorController {
	@Autowired
	IDoctorService doctorService;

	@Autowired
	IPatientService patientService;

	public DoctorController() {

	}

	@GetMapping("/getAppointment/{id}")
	public ResponseEntity<?> getAppointmentByDoctorId(@PathVariable int id) {
		if (id > 0) {
			List<Appointment> appoinmentList = doctorService.getAppointmentByDoctorId(id);
			if (appoinmentList.isEmpty())
				throw new ResourceNotFoundException("Today you want no appointment");
			else
				return ResponseEntity.ok(appoinmentList);
		}
		throw new ResourceNotFoundException("Please enter valid doctor id");
	}

	@GetMapping("/getPrescription/{id}")
	public ResponseEntity<?> getPrescriptionByPatientId(@PathVariable int id) {
		if (id > 0) {
			List<Medicine> list = patientService.getPrescriptionByPatientId(patientService.getPatient(id));
			if (list.isEmpty())
				throw new ResourceNotFoundException("Prescription list is empty");
			else
				return ResponseEntity.ok(list);

		}
		throw new ResourceNotFoundException("please enter valid patient id");
	}

	@PostMapping("/saveprescription")
	public ResponseEntity<?> savePrescription(@RequestBody PrescriptionMedicineDTO prescriptionDTO) {
		System.out.println(prescriptionDTO);
		Prescription pres = new Prescription();
		 pres.setPrecautions(prescriptionDTO.getPrecautions());
		 pres.setSymptoms(prescriptionDTO.getSymptoms());
		 pres.setDoctor(doctorService.getDoctor(prescriptionDTO.getDoctorId()));
		 pres.setPatient(patientService.getPatient(prescriptionDTO.getPatientId()));
		 pres.setCreatedOn(LocalDate.now());
//		 pres.setCreatedOn(dto.getCreatedOn());
		Medicine[] med = (Medicine[]) prescriptionDTO.getListOfMedicine();
		String appointmentTime=prescriptionDTO.getAppointmentTime();
		System.out.println(pres);
	//	System.out.println("\n" + med);
		if (pres != null) {
			doctorService.savePrescription(pres, med,appointmentTime);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Error while saving patient please try again");
	
	}
}
