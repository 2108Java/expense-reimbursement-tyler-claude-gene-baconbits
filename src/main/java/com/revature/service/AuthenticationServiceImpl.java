package com.revature.service;

import com.revature.repo.EmpDaoImpl;
import com.revature.repo.EmployeeDao;

public class AuthenticationServiceImpl implements AuthenticationService {

	
	//FIELDS
	EmployeeDao empDao = new EmpDaoImpl();
	
	
	
	//METHODS
	@Override
	public boolean verify(String username) {
		return empDao.selectByUserName();
	}

	@Override
	public boolean authenticate(String username, String password) {
		return empDao.selectUserNameAndPass();

	}

	
}
