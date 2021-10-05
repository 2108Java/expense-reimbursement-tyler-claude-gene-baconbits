package com.revature.repo;

import com.revature.models.Employee;

public interface EmployeeDao {

	boolean selectByUserName();


	boolean selectUserNameAndPass();


	Employee selectUser(String username);

}
