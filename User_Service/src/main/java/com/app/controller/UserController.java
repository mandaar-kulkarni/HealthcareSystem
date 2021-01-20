package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.dto.AdminPropertyAndRole;
import com.app.dto.DoctorPropertyAndRole;
import com.app.dto.UserPropertyAndRole;
import com.app.pojos.User;
import com.app.service.IDoctorService;
import com.app.service.IPatientService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
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
				return ResponseEntity.ok(new AdminPropertyAndRole(authenticatedUser, "ADMIN"));
			}else if(authenticatedUser.getPersonRole().toString().equals("PATIENT")){
				return ResponseEntity.ok(new UserPropertyAndRole(patientService.getPatientByEmailid(authenticatedUser.getEmailId()),"PATIENT"));
			}else if(authenticatedUser.getPersonRole().toString().equals("DOCTOR")){
				return ResponseEntity.ok(new DoctorPropertyAndRole(doctorService.getDoctorByEmailId(authenticatedUser.getEmailId()),"DOCTOR"));
			}
		}
		throw new ResourceNotFoundException("enter valid username and password");
	}
}
