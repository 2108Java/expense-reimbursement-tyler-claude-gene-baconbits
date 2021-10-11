package com.revature.models;

import java.util.Objects;
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


	public void setType(RequestType type) {
		this.type = type;
	}


	public TicketStatus getStatus() {
		return status;
	}


	public void setStatus(TicketStatus status) {
		this.status = status;
	}


	public ArrayList<TicketStatusEvent> getTicketHistory() {
		return ticketHistory;
	}


	public void setTicketHistory(ArrayList<TicketStatusEvent> ticketHistory) {
		this.ticketHistory = ticketHistory;
	}

	public String getTypeString() {
        return type.name();
    }

	public void setTypeString(String type) {
	        this.type = RequestType.valueOf(type);
	    }
	public String getStatusString() {
	        return status.name();
	    }
	public void setStatusString(String status) {
	        this.status = TicketStatus.valueOf(status);
	    }
	
	

	
	
}


