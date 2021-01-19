package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.pojos.User;
import com.app.service.IDoctorService;
import com.app.service.IPatientService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	IPatientService patientService;
	
	@Autowired
	IDoctorService doctorService;
	
	public UserController(){
		
	}
	
	//authenticate user
	@PostMapping
	public ResponseEntity<?> authenticateUser(@RequestBody User user){
		System.out.println(user);
		User authenticatedUser=userService.authenticateUser(user);
		System.out.println(authenticatedUser);
		if(authenticatedUser!=null) {
			if(authenticatedUser.getPersonRole().toString().equals("ADMIN")) {
				return ResponseEntity.ok(authenticatedUser);
			}else if(authenticatedUser.getPersonRole().toString().equals("PATIENT")){
				return ResponseEntity.ok(patientService.getPatientByEmailid(authenticatedUser.getEmailId()));
			}else if(authenticatedUser.getPersonRole().toString().equals("DOCTOR")){
				return ResponseEntity.ok(doctorService.getDoctorByEmailId(authenticatedUser.getEmailId()));
			}
		}
		throw new ResourceNotFoundException("enter valid username and password");
	}
}
