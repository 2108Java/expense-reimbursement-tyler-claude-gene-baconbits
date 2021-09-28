package com.revature.repo;

import java.util.List;

import com.revature.models.Ticket;

public interface TicketDao {
	
	// Creates a new Ticket.
	
	public boolean createTicket();
	
	// Select Ticket(s) for the employee and the Manager.
	
	public Ticket selectTicket();
	
	public List<Ticket> selectYourOwnTickets();
	
	public List<Ticket> selectEmployeeTickets();
	
	public List<Ticket> selectAllTickets();
	
	// Updates your tickets
	
	public boolean updateTicket();
	
	// Deletes a Ticket if need be.
	
	public boolean deleteTicket();

}
