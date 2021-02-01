package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.*;
import com.app.pojos.*;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public User authenticationUser(User u) {
		userRepo.findByEmailIdAndPassword(u.getEmailId(), u.getPassword());
		return null;
	}

	@Override
	public User addUser(User u) {
		System.out.println("In add User method");
		return userRepo.save(u);
	}

	@Override
	public void deleteUser(User u) {
		userRepo.delete(u);
	}

	@Override
	public User getUser(String emailId) {
		User selectedUser = userRepo.findByEmailId(emailId);
		return selectedUser;
	}

}
