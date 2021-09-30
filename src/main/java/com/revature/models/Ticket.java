package com.revature.models;

import java.util.Objects;
import java.util.ArrayList;
import java.util.Calendar;


public class Ticket {

	//FIELDS
	private int id; //serial, primary key in database
	private int employeeId; //person who is requesting reimbursement, foreignkey
	private double amount;
	private String description; //provided by employee on submission
	private RequestType type; //lodging, travel, food, or other
	private TicketStatus status; //approved, pending, or rejected
	private ArrayList<Calendar> ticketHistory; 	//to collect timestamp data from the db for display to user
												//probably will be separate table in db, 
												//but can be part of TIcket object
	
	
	//CONSTRUCTORS
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Ticket(int id, int employeeId, double amount, RequestType type, String description, TicketStatus status) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.status = status;
	}



	//METHODS
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public RequestType getType() {
		return type;
	}



	public void setType(RequestType type) {
		this.type = type;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public TicketStatus getStatus() {
		return status;
	}



	public void setStatus(TicketStatus status) {
		this.status = status;
	}



	public ArrayList<Calendar> getTicketHistory() {
		return ticketHistory;
	}



	public void setTicketHistory(ArrayList<Calendar> ticketHistory) {
		this.ticketHistory = ticketHistory;
	}



	@Override
	public String toString() {
		return "Ticket [id=" + id + ", employeeId=" + employeeId + ", amount=" + amount + ", description=" + description
				+ ", type=" + type + ", status=" + status + "]"; //excludes ticketHistory
	}





	
	
	
}


