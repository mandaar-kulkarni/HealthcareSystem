package com.app.service;

import com.app.pojos.*;

public interface IUserService {
		User authenticationUser(User u);
		
		User addUser(User u);
		
		void deleteUser(User u);
		
		User getUser(String emailId);
}
