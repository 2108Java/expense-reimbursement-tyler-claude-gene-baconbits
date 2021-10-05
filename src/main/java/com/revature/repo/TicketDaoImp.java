package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Ticket;
import com.revature.utilities.ConnectionDispatch;

public class TicketDaoImp implements TicketDao, TicketHistoryDao {

	ConnectionDispatch dispatch = new ConnectionDispatch();
	
	@Override
	public boolean createTicket(int employee_id, double amount, String type, String description, int status) {
		boolean success = false;
		
		String sql = "INSERT INTO ticket_table() VALUES ()";
		
		// Make the ticket.
		
		success = dispatch.executeBoolean(sql);
		
		
		return success;
	}

	@Override
	public Ticket selectTicket(int id) {
		Ticket selectedTicket = new Ticket();
		
		String sql = "SELECT * FROM ticket_table WHERE employee_id = ?";
		
		// prepare the ticket
		
		selectedTicket = dispatch.executeTicket(sql);
		
		return selectedTicket;
	}

	@Override
	public List<Ticket> selectYourOwnTickets(int employee_id) {


		List<Ticket> selectedTickets = new ArrayList<>();
		
		String sql = "SELECT * FROM ticket_table WHERE employee_id = ?";
		
		// prepare the ticket list.
		
		selectedTickets = dispatch.executeTickets(sql);
		
		return selectedTickets;
	}
	
	@Override
	public List<Ticket> selectYourTicketsByStatus(int employee_id, int status) {
		List<Ticket> tickets = new ArrayList<>();
		
		String sql = "SELECT * FROM ticket_table WHERE employee_id = ? AND status = ?";
		
		// make the ticket list.
		tickets = dispatch.executeTickets(sql);
		
		return tickets;
	}

	@Override
	public List<Ticket> selectEmployeeTickets(int employee_id) {
				
		List<Ticket> selectedTickets = new ArrayList<>();
		
		String sql =  "SELECT * FROM ticket_table WHERE employee_id = ?";
		
		// make the ticket list. 
		
		selectedTickets = dispatch.executeTickets(sql);
		
		return selectedTickets;
	}

	
	@Override
	public List<Ticket> selectTicketsByStatus(int employee_id, int status) {
		
		List<Ticket> selectedTickets = new ArrayList<>();

		String sql = "SELECT * FROM ticket_table WHERE employee_id = ? AND status = ?";
		
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
	public boolean updateTicket(int id) {
		
		String sql = "UPDATE () IN ticket_table SET ()";
		
		boolean success = dispatch.executeBoolean(sql);
				
		return success;
	}

	@Override
	public boolean deleteTicket(int id) {
		
		String sql = "DELETE IN ticket_table WHERE id = ()";
		
		boolean success = dispatch.executeBoolean(sql);
		
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
