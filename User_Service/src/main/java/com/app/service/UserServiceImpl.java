package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.pojos.Role;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userDao;
	
	@Override
	public User authenticateUser(User user) {
		return userDao.findByEmailIdAndPasswordAndStatus(user.getEmailId(), user.getPassword(),1);
	}

	@Override
	public User saveUser(User user) {
		user.setPersonRole(Role.valueOf("PATIENT"));
		return userDao.save(user);
	}

	
}
