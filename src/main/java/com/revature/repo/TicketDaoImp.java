package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Ticket;
import com.revature.utilities.ConnectionDispatch;

public class TicketDaoImp implements TicketDao, TicketHistoryDao {

	ConnectionDispatch dispatch = new ConnectionDispatch();
	Connection conn;
	
	@Override
	public boolean createTicket(int employee_id, double amount, String type, String description, String status) {
		boolean success = false;
		
		String sql = "INSERT INTO ticket_table(employee_id, amount, type, description, status) VALUES (?, ?, ?, ?)";
		
		try {
			dispatch.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, employee_id);
			ps.setDouble(2, amount);
			ps.setString(3, type);
			ps.setString(4, description);
			ps.setString(5, status);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return success;
	}

	@Override
	public Ticket selectTicket(int id) {
		Ticket selectedTicket = new Ticket();
		PreparedStatement ps;
		
		String sql = "SELECT * FROM ticket_table WHERE employee_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			selectedTicket = dispatch.executeTicket(ps);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return selectedTicket;
	}

	@Override
	public List<Ticket> selectYourOwnTickets(int employee_id) {


		List<Ticket> selectedTickets = new ArrayList<>();
		PreparedStatement ps;
		String sql = "SELECT * FROM ticket_table WHERE employee_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, employee_id);
			
			selectedTickets = dispatch.executeTickets(ps);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectedTickets;
	}
	
	@Override
	public List<Ticket> selectYourTicketsByStatus(int employee_id, String status) {
		PreparedStatement ps;
		List<Ticket> tickets = new ArrayList<>();
		
		String sql = "SELECT * FROM ticket_table WHERE employee_id = ? AND status = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee_id);
			ps.setString(2, status);
			
			tickets = dispatch.executeTickets(ps);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return tickets;
	}

	@Override
	public List<Ticket> selectEmployeeTickets(int employee_id) {
		
		List<Ticket> selectedTickets = new ArrayList<>();
		PreparedStatement ps;
		
		String sql =  "SELECT * FROM ticket_table WHERE employee_id = ?";
		
		try {

			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee_id);
			
			selectedTickets = dispatch.executeTickets(ps);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectedTickets;
	}

	
	@Override
	public List<Ticket> selectTicketsByStatus(int employee_id, String status) {
		
		PreparedStatement ps;
		List<Ticket> selectedTickets = new ArrayList<>();

		String sql = "SELECT * FROM ticket_table WHERE employee_id = ? AND status = ?";
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, employee_id);
			ps.setString(2, status);
			
			selectedTickets = dispatch.executeTickets(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectedTickets;
		
	}
	 
	@Override
	public List<Ticket> selectAllTickets() {
		
		List<Ticket> tickets = new ArrayList<>();
		PreparedStatement ps;
		
		String sql = "SELECT * FROM ticket_table";
		
		try {
			ps = conn.prepareStatement(sql);

			tickets = dispatch.executeTickets(ps);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tickets;
	}

	
	@Override
	public boolean updateTicket(int id) {
		boolean success = false;
		String sql = "UPDATE () IN ticket_table SET ()";
		
	
		return success;
	}

	@Override
	public boolean deleteTicket(int id) {
		boolean success = false;
		
		String sql = "DELETE IN ticket_table WHERE id = ()";
		
		
		
		return success;
	}
	
	 
	// Ticket History Methods

	@Override
	public boolean insertTimeStamp() {
		boolean success = false;
		
		String sql = "INSERT INTO ticket_history() VALUES ()";
		
	
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
