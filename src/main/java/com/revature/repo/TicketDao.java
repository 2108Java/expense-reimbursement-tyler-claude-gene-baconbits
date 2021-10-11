package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.RequestType;
import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.models.TicketStatusEvent;

public interface TicketDao {
	
	// Creates a new Ticket.
	
	public boolean createTicket(int employee_id, double amount, RequestType type, String description, TicketStatus status);
	
	// Select Ticket(s) for the employee and the Manager.
	
	public Ticket selectTicket(int id);
	
	public List<Ticket> selectYourOwnTickets(int employee_id);
	
	public List<Ticket> selectYourTicketsByStatus(int employee_id, TicketStatus status);
	
	public List<Ticket> selectTicketsByStatus(int employee_id, TicketStatus status);
	
	public List<Ticket> selectEmployeeTickets(int employee_id);
	
	public List<Ticket> selectAllTickets();
	
	
	
	// Updates your tickets
	
	public boolean updateTicket(int id);
	
	public boolean updateTicketStatus(int id, TicketStatus status);
	
	
	
	// Deletes a Ticket if need be.
	
	public boolean deleteTicket(int id);

	public static ArrayList<TicketStatusEvent> selectAllStatusEventForTicket(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
