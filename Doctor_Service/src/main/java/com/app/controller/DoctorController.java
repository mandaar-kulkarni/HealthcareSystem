package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



import com.app.cust_excs.ResourceNotFoundException;
import com.app.dto.PrescriptionMedicineDto;
import com.app.pojos.Appointment;
import com.app.pojos.Medicine;
import com.app.pojos.Prescription;
import com.app.service.IDoctorService;
import com.app.service.IPatientService;


@RestController
@RequestMapping("/doctor")
@Validated
public class DoctorController {

	
	@Autowired
	IDoctorService doctorService;
	
	@Autowired
	IPatientService patientService;
	
	public DoctorController() {
		
	}
	
	@GetMapping("/getAppointment/{id}")
	public ResponseEntity<?> getAppointmentByDoctorId(@PathVariable int id){
		if(id>0) {
			List<Appointment> appoinmentList=doctorService.getAppointmentByDoctorId(id);
			if(appoinmentList.isEmpty())
				throw new ResourceNotFoundException("Today you want no appointment");
			else
				return ResponseEntity.ok(appoinmentList);
		}
		throw new ResourceNotFoundException("Please enter valid doctor id");
	}
	
	@GetMapping("/getPrescription/{id}")
	public ResponseEntity<?> getPrescriptionByPatientId(@PathVariable int id){
		if(id>0) {
			List<Medicine> list=patientService.getPrescriptionByPatientId(patientService.getPatient(id));
			if(list.isEmpty())
				throw new ResourceNotFoundException("Prescription list is empty");
			else
				return ResponseEntity.ok(list);
		}
		throw new ResourceNotFoundException("please enter valid patient id");
	}
	
	
	@PostMapping("/savePrescription")
	public ResponseEntity<?> savePrescription(@RequestBody PrescriptionMedicineDto dto){
		Prescription pres=dto.getPrescription();
		List<Medicine> med=(List<Medicine>) dto.getMedicine();		
		doctorService.savePrescription(pres, med);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
