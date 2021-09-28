package com.revature.models;

public class Ticket {

	private int id; //serial, primary key in database
	private int employeeId; //person who is requesting reimbursement
	private double amount;
	private String type; //lodging, travel, food, or other
	private String description; //provided by employee on submission
	private int status; //approved, pending, or rejected
	
}
