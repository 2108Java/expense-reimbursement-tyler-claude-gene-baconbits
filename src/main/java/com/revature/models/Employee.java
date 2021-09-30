package com.revature.models;

import java.util.Objects;

public class Employee {

	
	//FIELDS
	private int empId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private boolean isManager;
	
	
	
	
	//CONSTRUCTORS
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Employee(int empId, String firstName, String lastName, String userName, String password, String email,
			boolean isManager) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.isManager = isManager;
	}



	//METHODS
	public int getEmpId() {
		return empId;
	}




	public void setEmpId(int empId) {
		this.empId = empId;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public boolean isManager() {
		return isManager;
	}




	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}



	//FOR HASHING PASSWORD
	@Override
	public int hashCode() {
		return Objects.hash(password);
	}


	

	//FOR HASHING PASSWORD
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(password, other.password);
	}
	
	

	
	
	
	
}
