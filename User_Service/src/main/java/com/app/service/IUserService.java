package com.app.service;

import com.app.pojos.User;

public interface IUserService {
	
	User authenticateUser(User user);
	
	User saveUser(User user);

}
