package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Ticket;
import com.revature.utilities.ConnectionDispatch;

public class TicketDaoImp implements TicketDao, TicketHistoryDao {

	ConnectionDispatch dispatch = new ConnectionDispatch();
	
	@Override
	public boolean createTicket() {
		boolean success = false;
		
		String sql = "INSERT INTO ticket_table() VALUES ()";
		
		// Make the ticket.
		
		success = dispatch.executeBoolean(sql);
		
		
		return success;
	}

	@Override
	public Ticket selectTicket() {
		Ticket selectedTicket = new Ticket();
		
		String sql = "SELECT * FROM ticket_table WHERE () = ?";
		
		// prepare the ticket
		
		selectedTicket = dispatch.executeTicket(sql);
		
		return selectedTicket;
	}

	@Override
	public List<Ticket> selectYourOwnTickets() {


		List<Ticket> selectedTickets = new ArrayList<>();
		
		String sql = "SELECT * FROM ticket_table WHERE () = ?";
		
		// prepare the ticket list.
		
		selectedTickets = dispatch.executeTickets(sql);
		
		return selectedTickets;
	}

	@Override
	public List<Ticket> selectEmployeeTickets() {
				
		List<Ticket> selectedTickets = new ArrayList<>();
		
		String sql =  "SELECT * FROM ticket_table WHERE () = ?";
		
		// make the ticket list. 
		
		selectedTickets = dispatch.executeTickets(sql);
		
		return selectedTickets;
	}

	@Override
	public List<Ticket> selectAllTickets() {
		
		List<Ticket> tickets = new ArrayList<>();
		
		String sql = "SELECT * FROM ticket_table";
		
		tickets = dispatch.executeTickets(sql);
		
		return tickets;
	}

	
	@Override
	public boolean updateTicket() {
		
		boolean success = false;
				
		return success;
	}

	@Override
	public boolean deleteTicket() {
		
		boolean success = false;
		
		return success;
	}
	// Ticket History Methods

	@Override
	public boolean insertTimeStamp() {
		boolean success = false;
		
		String sql = "INSERT INTO ticket_history() VALUES ()";
		
		success = dispatch.executeBoolean(sql);
		
		return success;
	}

	@Override
	public void selectATimeStamp() {
		// TODO find out what Tyler is doing with the timestamps and see if I have to use a date object.
		
	}

	@Override
	public void selectYourOwnTimeStamp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectEmployeeTimeStamp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectAllTimeStamps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteTimeStamp() {
		boolean success = false;
		return success;
	}

}
