package com.revature.models;

import java.util.Objects;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import com.revature.repo.*;

public class Ticket {

	//FIELDS
	private int id; //serial, primary key in database
	private int employeeId; //person who is requesting reimbursement, foreignkey
	private double amount;
	private String description; //provided by employee on submission
	private RequestType type; //lodging, travel, food, or other
	private TicketStatus status; //approved, pending, or rejected
	private ArrayList<TicketStatusEvent> ticketHistory;
	
	
	//CONSTRUCTORS
	public Ticket() {
		super();
		this.ticketHistory = TicketDao.selectAllStatusEventForTicket(this.id);
	}


	public Ticket(int id, int employeeId, double amount, String description, RequestType type, TicketStatus status,
			ArrayList<TicketStatusEvent> ticketHistory) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.status = status;
		this.ticketHistory = ticketHistory;
	}



	public Ticket(int id, int employeeId, double amount, String description, String typeString, String statusString, Date date) {
		// TODO Auto-generated constructor stub
	}


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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public RequestType getType() {
		return type;
	}

	public String GetTypeString() {
		return type.name();
	}

	public void setType(RequestType type) {
		this.type = type;
	}
	
	
	public void setTypeString(String type) {
		this.type = RequestType.valueOf(type);
	}
 

	public TicketStatus getStatus() {
		return status;
	}
	
	public String getStatusString() {
		return status.name();
	}

	

	public void setStatus(TicketStatus status) {
		this.status = status;
	}
	
	public void setStatusString(String status) {
		this.status = TicketStatus.valueOf(status);
	}


	public ArrayList<TicketStatusEvent> getTicketHistory() {
		return ticketHistory;
	}


	public void setTicketHistory(ArrayList<TicketStatusEvent> ticketHistory) {
		this.ticketHistory = ticketHistory;
	}

	
	
	

	
	
}