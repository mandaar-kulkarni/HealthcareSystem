package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdminRepository;
import com.app.pojos.Admin;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	public AdminServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public Admin findByEmailId(String emailId) {
		Admin authenticatedAdmin = adminRepo.findByEmailId(emailId);
		return authenticatedAdmin;
	}

}
