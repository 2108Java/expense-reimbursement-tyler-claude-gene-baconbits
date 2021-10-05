package com.revature.service;

import com.revature.models.Employee;

public interface EmployeeService {

	Employee getUserByUsername(String username);

	void getAllTickets();

}
