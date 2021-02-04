package com.app.controller;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.dto.*;
import com.app.pojos.*;
import com.app.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/admin")
@Validated
@CrossOrigin
public class DoctorController {

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IUserService userService;

	public DoctorController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/regDoctor")
	public ResponseEntity<?> addDoctor(@RequestBody	 TrailDoctor t) {
		Doctor doctor = t.getDoctor();
		User user = t.getUser();
		doctor.setSpecialization(t.getDoctor().getSpecialization());
		Doctor addedDoctor = doctorService.addDoctor(doctor);
		User addedUser = userService.addUser(user);
		if (addedDoctor != null && addedUser != null) {
			return ResponseEntity.ok(addedDoctor);
		}
		throw new ResourceNotFoundException("Error while saving patient please try again");
	}

	@GetMapping
	public ResponseEntity<?> getDoctorList() {
		List<Doctor> listOfDoctor = doctorService.getDoctorList();
		if (listOfDoctor.isEmpty()) {
			throw new ResourceNotFoundException("There are no Doctors!!!");
		} else {
			return ResponseEntity.ok(listOfDoctor);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDoctor(@PathVariable int id) {
		if (id > 0) {
			Doctor doc = doctorService.getDoctor(id);
			User user = userService.getUser(doc.getEmailId());
			doc.setStatus(0);
			user.setStatus(0);
			TrailDoctor t = new TrailDoctor();
			t.setDoctor(doc);
			t.setUser(user);
			addDoctor(t);
			/*
			 * userService.deleteUser(user); doctorService.deleteDoctor(doc);
			 */
			return new ResponseEntity<>(HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Please Enter the Valid details");
	}

	@GetMapping("/getDoctor/{id}")
	public ResponseEntity<?> getDoctor(@PathVariable int id) {
		if (id > 0) {
			TrailDoctor t = new TrailDoctor();
			t.setDoctor(doctorService.getDoctor(id));
			t.setUser(userService.getUser(t.getDoctor().getEmailId()));
			return ResponseEntity.ok(t);
		}
		throw new ResourceNotFoundException("Please Enter the Valid details");
	}

	@PostMapping("/upload")
	public String fileUploadWithParams(@RequestParam String doctor, @RequestParam MultipartFile degreeCertificate,
			@RequestParam MultipartFile license) throws IOException {
		try {
			// un marshalling json--> java
			Doctor doc = doctorService
					.getDoctorByEmailId((new ObjectMapper().readValue(doctor, Doctor.class).getEmailId()));
			doc.setDegreeCertificate(degreeCertificate.getBytes());
			doc.setLicense(license.getBytes());
			doc.setImageContentTypeDC(degreeCertificate.getContentType());
			doc.setImageContentTypeLic(license.getContentType());
			doctorService.addDoctor(doc);
			return "file uploaded successfully";
		} catch (Exception e) {
			throw new ResourceNotFoundException("Error while uploading files");
		}
	}
	
	@GetMapping("/getCertificate/{doctorId}")
	public ResponseEntity<?> downloadImage(@PathVariable int doctorId) throws IOException {
		System.out.println("in img download " + doctorId);
		Doctor doc= doctorService.getDoctor(doctorId);
		ImageDTO img= new ImageDTO();
		// img.setName(imgName);
		img.setData(doc.getDegreeCertificate());
		img.setType(doc.getImageContentTypeDC());
		return new ResponseEntity<>(img, HttpStatus.OK);
	}
	
	@GetMapping("/getLicense/{doctorId}")
	public ResponseEntity<?> downloadImageLic(@PathVariable int doctorId) throws IOException {
		System.out.println("in img download " + doctorId);
		Doctor doc= doctorService.getDoctor(doctorId);
		ImageDTO img= new ImageDTO();
		// img.setName(imgName);
		img.setData(doc.getLicense());
		img.setType(doc.getImageContentTypeLic());
		return new ResponseEntity<>(img, HttpStatus.OK);
	}
}
