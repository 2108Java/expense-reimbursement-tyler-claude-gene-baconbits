package com.revature.service;

import com.revature.repo.EmployeeDao;

public interface AuthenticationService {

	public static boolean verify(String username) {
		return EmployeeDao.selectCheckUserName();
		
	}
	
	public static boolean authenticate(String username, String password) {
		return EmployeeDao.selectUserNameAndPass();
	}
	
	
}
