package com.revature.repo;

public interface EmployeeDao {

	// Create an employee
	
	public boolean insertEmployee();
	
	// Selects an Employee by User Name and by ID
	
	public void selectEmployeeByUserName();
	
	public void selectEmployeeById();
	
	// Update an Employee because reasons
	
	// public boolean updateEmployeePasswordByUsername();
	
	// Delete an Employee because reasons
	
	// public boolean deleteEmployee
	
}
