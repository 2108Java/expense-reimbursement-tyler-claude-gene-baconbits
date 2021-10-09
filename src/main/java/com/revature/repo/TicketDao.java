package com.revature.repo;

import java.util.ArrayList;

import com.revature.models.TicketStatusEvent;

public interface TicketDao {

	static ArrayList<TicketStatusEvent> selectAllStatusEventForTicket(int id) {
		
		//use the ticket_id int to pull all the status change events for ticket history
		ArrayList<TicketStatusEvent> someTicketHistory = new ArrayList<TicketStatusEvent>();
		
		return someTicketHistory;
	}

}
