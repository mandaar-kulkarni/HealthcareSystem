package com.app.service;

import com.app.pojos.Admin;

public interface IAdminService {
	Admin findByEmailId(String emailId);
}
