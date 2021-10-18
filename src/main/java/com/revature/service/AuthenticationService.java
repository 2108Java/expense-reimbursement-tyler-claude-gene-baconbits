package com.revature.service;

import com.revature.repo.EmployeeDao;
import com.revature.repo.EmployeeDaoImpl;

public class AuthenticationService {

	private EmployeeDao empDao = new EmployeeDaoImpl();
	
	public boolean verify(String username) {
		return empDao.selectCheckUserName(username);
		
	}
	
	public boolean authenticate(String username, String password) {
		return empDao.selectUserNameAndPass(username,password);
	}
	
	
}
