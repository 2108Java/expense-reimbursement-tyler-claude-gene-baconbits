package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.RequestType;
import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.models.TicketStatusEvent;
import com.revature.utilities.ConnectionDispatch;

public class TicketDaoImp implements TicketDao {

	ConnectionDispatch dispatch = new ConnectionDispatch();
	TicketHistoryDao historyDao = new TicketHistoryDaoImpl();
	Connection conn;
	Employee emp;
	
	@Override
	public boolean createTicket(int employee_id, double amount, RequestType type, String description, TicketStatus status) {
		boolean success = false;
		
		String sql = "INSERT INTO ticket_table(employee_id, amount, type, description, status), VALUES (?, ?, ?, ?)";
		
		try {
			dispatch.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, emp.getEmpId());
			ps.setDouble(2, amount);
			ps.setString(3, type.name());
			ps.setString(4, description);
			ps.setString(5, status.name());
			
			
			success = ps.execute();
			
			if (success) {
				historyDao.insertTimeStamp(emp.getEmpId());
			}
			
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
		
		String sql = "SELECT * FROM ticket_table ti RIGHT JOIN ticket_history_table WHERE ticket_id = ?";
		
		try {
			dispatch.getConnection();
	
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				selectedTicket.setId(result.getInt("ticket_id"));
				selectedTicket.setEmployeeId(result.getInt("employee_id"));
				selectedTicket.setAmount(result.getDouble("amount"));
				selectedTicket.setTypeString(result.getString("type"));
				selectedTicket.setDescription(result.getString("description"));
				selectedTicket.setStatusString(result.getString("status"));
				
				
			}
			
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
		String sql = "SELECT * from ticket_table RIGHT JOIN ticket_history_table th ON ti.employee_id = ? AND ti.ticket_id = th.ticket_id ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, employee_id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectedTickets;
	}
	
	@Override
	public List<Ticket> selectYourTicketsByStatus(int employee_id, TicketStatus status) {
		PreparedStatement ps;
		List<Ticket> tickets = new ArrayList<>();
		List<TicketStatusEvent> events = new ArrayList<>();
		
		String sql = "SELECT * FROM ticket_table WHERE employee_id = ? AND status = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee_id);
			ps.setString(2, status.name());
			
			ResultSet rs = ps.executeQuery();
			
			// need to figure out how to make a date into an
			while (rs.next()) {
				
						while (rs.next()) {
						    Ticket t = new Ticket();
						    t.setId(rs.getInt("ticket_id"));
						    emp.setEmpId(rs.getInt("employee_id"));
						    t.setDescription(rs.getString("description"));
						    t.setStatusString(rs.getString("status"));
						    t.setTypeString(rs.getString("type"));
						    
						    
						    
						    tickets.add(t); //it's something like that
						
						}
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return tickets;
	}

	@Override
	public List<Ticket> selectEmployeeTickets(int employee_id) {
		
		List<Ticket> tickets = new ArrayList<>();
		PreparedStatement ps;
		
		String sql =  "SELECT * FROM ticket_table WHERE employee_id = ?";
		
		try {

			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee_id);
			

			ResultSet rs = ps.executeQuery();
			
			// need to figure out how to make a date into an
			while (rs.next()) {
				
						    Ticket t = new Ticket();
						    t.setId(rs.getInt("ticket_id"));
						    emp.setEmpId(rs.getInt("employee_id"));
						    t.setDescription(rs.getString("description"));
						    t.setStatusString(rs.getString("status"));
						    t.setTypeString(rs.getString("type"));
						    
						    
						    
						    tickets.add(t); //it's something like that
				
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tickets;
	}

	
	@Override
	public List<Ticket> selectTicketsByStatus(int employee_id, TicketStatus status) {
		
		PreparedStatement ps;
		List<Ticket> selectedTickets = new ArrayList<>();

		String sql = "SELECT * FROM ticket_table WHERE employee_id = ? AND status = ?";
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, employee_id);
			ps.setString(2, status.name());
			
ResultSet rs = ps.executeQuery();
			
			// need to figure out how to make a date into an
			while (rs.next()) {
				    Ticket t = new Ticket();
				    t.setId(rs.getInt("ticket_id"));
				    emp.setEmpId(rs.getInt("employee_id"));
				    t.setDescription(rs.getString("description"));
				    t.setStatusString(rs.getString("status"));
				    t.setTypeString(rs.getString("type"));
				    
				    
				    
				    selectedTickets.add(t); //it's something like that
				
			}
			
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

			ResultSet rs = ps.executeQuery();
			
			// need to figure out how to make a date into an
			while (rs.next()) {
				    Ticket t = new Ticket();
				    t.setId(rs.getInt("ticket_id"));
				    emp.setEmpId(rs.getInt("employee_id"));
				    t.setDescription(rs.getString("description"));
				    t.setStatusString(rs.getString("status"));
				    t.setTypeString(rs.getString("type"));
				    
				    
				    
				    tickets.add(t); //it's something like that
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tickets;
	}

	
	
	// Generic update
	@Override
	public boolean updateTicket(int id) {
		boolean success = false;
		String sql = "UPDATE () IN ticket_table SET ()";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			success = ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return success;
	}
	
	@Override
	public boolean updateTicketStatus(int id, TicketStatus status) {
		boolean success = false;
		
		String sql = "UPDATE ticket_table SET status = ? WHERE employee_id = ?";
		
		try {
			
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, status.name());
		ps.setInt(2, id);
		
		success = ps.execute();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}

	@Override
	public boolean deleteTicket(int id) {
		
		boolean success = false;
		
		String sql = "DELETE IN ticket_table WHERE id = ?";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			success = ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success;
	}
	
	
	
}