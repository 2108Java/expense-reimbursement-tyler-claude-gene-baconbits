package com.revature.repo;

import com.revature.models.TicketStatusEvent;

public interface TicketHistoryDao {
	
	// Creates a new timestamp
	
	public boolean insertTicketStatus(int ticketId);
	
	// Updates a ticket's history
	
	public boolean updateStatusToRejected(int ticketId);
	
	public boolean updateStatusToApproved(int ticketId);
	
	public boolean updateStatusToPending(int ticketId);
	
	
	
	

}
