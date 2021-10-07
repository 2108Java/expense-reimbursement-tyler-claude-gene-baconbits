package com.revature.repo;

import com.revature.models.Employee;

public interface EmployeeDao {

	// Create an employee
	
	public boolean insertEmployee(String username, String password, String first_name, String last_name, String email);
	
	// Selects an Employee by User Name and by ID
	
	public Employee selectByUsername(String username);
	
	public boolean selectUsernameAndPass(String username, String password);
	
	public Employee selectEmployeeById(int id);
	
	// Update an Employee because reasons
	
	public boolean updateEmployeePasswordByUsername();
	
	// Delete an Employee because reasons
	
	public boolean deleteEmployee();
	
}
