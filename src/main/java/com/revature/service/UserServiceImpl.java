package com.revature.service;

import com.revature.models.Employee;
import com.revature.repo.EmployeeDao;

public class UserServiceImpl implements UserService {

	EmployeeDao empDao = new EmpDaoImpl();
	
	
	@Override
	public Employee getUserByUsername(String username) {
		return empDao.selectUser(username);
	}

}
