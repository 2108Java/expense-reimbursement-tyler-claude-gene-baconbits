package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Ticket;
import com.revature.models.TicketStatusEvent;

public interface TicketDao {

	
	//use the ticket_id int to pull all the status change events for ticket history
	static ArrayList<TicketStatusEvent> selectAllStatusEventForTicket(int id) {
		ArrayList<TicketStatusEvent> someTicketHistory = new ArrayList<TicketStatusEvent>();
		//dao logic
		return someTicketHistory;
	}

	static List<Ticket> methodName () {
		List<Ticket> listName = new ArrayList<Ticket>();
		//dao logic
		return listName;
	}



	static List<Ticket> selectAllPendingTickets() {
		List<Ticket> listName = new ArrayList<Ticket>();
		//dao logic
		return listName;
	}

	static List<Ticket> selectAllApprovedTickets() {
		List<Ticket> listName = new ArrayList<Ticket>();
		//dao logic
		return listName;
	}

	static List<Ticket> selectAllRejectedTickets() {
		List<Ticket> listName = new ArrayList<Ticket>();
		//dao logic
		return listName;
	}

	static List<TicketStatusEvent> selectAllTicketStatusEvents() {
		List<TicketStatusEvent> listName = new ArrayList<TicketStatusEvent>();
		//dao logic
		return listName;
	}

	static List<Ticket> selectTicketsByEmployeeName(String empName) {
		List<Ticket> listName = new ArrayList<Ticket>();
		//dao logic
		return listName;
	}

	static List<Ticket> updateAllPendingToApproved() {
		List<Ticket> listName = new ArrayList<Ticket>();
		//dao logic
		return listName;
	}

	static Ticket updateStatusToPending(int id) {
		return null; //return ticket obj of the one updated
	}

	static Ticket updateStatusToRejected(int id) {
		//dao logic
		return null; //return ticket obj of the one updated
	}

	static Ticket updateStatusToApproved(int id) {
		//dao logic
		return null; //return ticket obj of the one updated
	}

}
