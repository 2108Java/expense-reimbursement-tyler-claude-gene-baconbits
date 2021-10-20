package com.revature.service;

import com.revature.models.Employee;
import com.revature.repo.EmployeeDao;
import com.revature.repo.EmployeeDaoImpl;

public class AuthenticationService {

	private EmployeeDao empDao = new EmployeeDaoImpl();
	
	public boolean verify(String username) {
		return empDao.selectCheckUserName(username);
		
	}
	
	public boolean authenticate(String username, String password) {
		boolean goodOps = false;
		Employee e = empDao.selectUserNameAndPass(username,password);
		
		if(e != null) {
			if (e.getPassword() == password) {
				goodOps = true;
				System.out.println("Password: " + password);
				System.out.println("Dao has" + e.getPassword());
				System.out.println("goodOps is " + goodOps);
			}
		}
		
		return goodOps;
	}
	
	
}
