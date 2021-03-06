package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.RequestType;
import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.models.TicketStatusEvent;

public interface TicketDao {
	
	// Creates a new Ticket.
	
	public boolean insertNewTicket(Ticket t);
	
	// Select Ticket(s) for the employee and the Manager.
	
	public Ticket selectTicket(int id);
	
	public List<Ticket> selectUserTickets(int employee_id);
	
	public List<Ticket> selectYourTicketsByStatus(int employee_id, TicketStatus status);
	
	public List<Ticket> selectTicketsByStatus(int employee_id, TicketStatus status);
	
	public List<Ticket> selectEmployeeTickets(int employee_id);
	
	public List<Ticket> selectAllTickets();
	
	public List<Ticket> selectAllPendingTickets();
	
	public List<Ticket> selectAllApproedTickets();
	
	public List<Ticket> selectAllRejectedTickets();
	
	// Updates your tickets
	
	public boolean updateTicket(int id);
	
	public boolean updateTicketStatus(int id, TicketStatus status);
	
	
	
	// Deletes a Ticket if need be.
	
	public boolean deleteTicket(int id);


	

	

	public ArrayList<TicketStatusEvent> selectAllStatusEventForTicket(int id);

	public List<Ticket> selectAllPendingTickets();

	public List<Ticket> selectAllApprovedTickets();

	public List<Ticket> selectAllRejectedTickets();

	public List<Ticket> updateAllPendingToApproved();

	public Ticket updateStatusToPending(int id);

	public Ticket updateStatusToRejected(int id);

	public Ticket updateStatusToApproved(int id);

	public List<Ticket> selectTicketsByEmployeeName(String empName);


}
