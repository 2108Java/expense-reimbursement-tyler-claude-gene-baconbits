package com.revature.repo;

import java.util.List;

import com.revature.models.Ticket;

public interface TicketDao {
	
	// Creates a new Ticket.
	
	public boolean createTicket(int employee_id, double amount, String type, String description, int status);
	
	// Select Ticket(s) for the employee and the Manager.
	
	public Ticket selectTicket(int id);
	
	public List<Ticket> selectYourOwnTickets(int employee_id);
	
	public List<Ticket> selectYourTicketsByStatus(int employee_id, int status);
	
	public List<Ticket> selectTicketsByStatus(int employee_id, int status);
	
	public List<Ticket> selectEmployeeTickets(int employee_id);
	
	public List<Ticket> selectAllTickets();
	
	// Updates your tickets
	
	public boolean updateTicket(int id);
	
	// Deletes a Ticket if need be.
	
	public boolean deleteTicket(int id);

}
