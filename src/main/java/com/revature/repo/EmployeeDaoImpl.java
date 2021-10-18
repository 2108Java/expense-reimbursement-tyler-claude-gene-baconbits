package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.models.TicketStatusEvent;
import com.revature.utilities.ConnectionDispatch;

public class EmployeeDaoImpl implements EmployeeDao {

	ConnectionDispatch dispatch = new ConnectionDispatch();
	Connection conn = null;
	
	@Override
	public boolean insertEmployee(String username, String password, String first_name, String last_name, String email) {
		
		boolean success = false;
		
		String sql = "INSERT INTO employee_table(username, password, first_name, last_name, email, is_manager) VALUES (?,?,?,?,?,?)";
		
		
		PreparedStatement ps;
		
		
		try { 
			
		this.conn = dispatch.getConnection();
		
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, first_name);
		ps.setString(4, last_name);
		ps.setString(5, email);
		ps.setBoolean(6, false);
		
		success = ps.execute();
	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return success;
	}

	@Override
	public Employee selectByUserName(String username) {
		PreparedStatement ps;
		Employee emp = new Employee();
		
		String sql = "SELECT * FROM employee_table WHERE username = ?";
	
		try {
			this.conn = dispatch.getConnection();
			
			
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				emp.setEmpId(rs.getInt("employee_id"));
				emp.setUserName(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setManager(rs.getBoolean("is_manager"));
				
			}
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		
		
		
		
		return emp;
	}

	@Override
	public Employee selectEmployeeById(int id) {
		PreparedStatement ps;
		Employee emp = new Employee();
		String sql = "SELECT * FROM employee_table WHERE employee_id = ?";
		
		try {
			this.conn = dispatch.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {			
				
				emp.setEmpId(rs.getInt("employee_id"));
				emp.setUserName(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setManager(rs.getBoolean("is_manager"));
			}
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		
		
		return emp;
		

	}

	@Override
	public boolean updateEmployeePasswordByUsername() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectUserNameAndPass(String username, String password) {
		boolean goodOps = false;
		
		String sql = "SELECT * FROM employee_table WHERE username = ? AND pass_word = ?";
		
		try {
			this.conn = dispatch.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			goodOps = ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return goodOps;
	}

	@Override
	public boolean selectCheckUserName(String username) {
		boolean goodOps = false;
		
		String sql = "SELECT username FROM employee_table WHERE username = ?";
		
		try {
			this.conn = dispatch.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			goodOps = ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return goodOps;
	}
	@Override
	public List<Ticket> selectUserTickets(int employee_id) {


		ArrayList<TicketStatusEvent> events = new ArrayList<>();
		List<Ticket> selectedTickets = new ArrayList<>();
		
		PreparedStatement ps;
		String sql = "SELECT * FROM ticket_table INNER JOIN ticket_history_table th ON ti.employee_id = ? AND ti.ticket_id = th.ticket_id ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, employee_id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Ticket t = new Ticket();
			    TicketStatusEvent e = new TicketStatusEvent();
			    t.setId(rs.getInt("ticket_id"));
			    t.setDescription(rs.getString("description"));
			    t.setTypeString(rs.getString("request"));
			    e.setNewStatusString(rs.getString("t_status"));
			    e.setDate(rs.getDate("issue_date"));
			    
			    events.add(e);
			    t.setTicketHistory(events);
			    
			    selectedTickets.add(t);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectedTickets;
	}

	@Override
	public List<TicketStatusEvent> selectAllTicketHistoryForUser(int userId) {
		List<TicketStatusEvent> events = new ArrayList<>();
		
		String sql = "SELECT tt.ticket_id, th.t_status, th.issue_date FROM ticket_table tt, ticket_history th WHERE tt.employee_id = ? AND tt.ticket_id = th.ticket_id";
		
		try {
			dispatch.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
				
						while (rs.next()) {
							
							TicketStatusEvent event = new TicketStatusEvent();
							event.setTickId(rs.getInt("ticket_id"));
							event.setNewStatusString(rs.getString("t_status"));
							event.setDate(rs.getDate("issue_date"));
							
							events.add(event);
							
						}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return events;
	}

	@Override
	public List<Ticket> selectAllTicketsForUser(int userId) {

		ArrayList<TicketStatusEvent> events = new ArrayList<>();
		List<Ticket> selectedTickets = new ArrayList<>();
		
		
		PreparedStatement ps;
		String sql = "SELECT * FROM ticket_table INNER JOIN ticket_history_table th ON ti.employee_id = ? AND ti.ticket_id = th.ticket_id ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Ticket t = new Ticket();
			    TicketStatusEvent e = new TicketStatusEvent();
			    t.setId(rs.getInt("ticket_id"));
			    t.setDescription(rs.getString("description"));
			    t.setTypeString(rs.getString("request"));
			    e.setNewStatusString(rs.getString("t_status"));
			    e.setDate(rs.getDate("issue_date"));
			    
			    events.add(e);
			    t.setTicketHistory(events);
			    
			    selectedTickets.add(t);
			    
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectedTickets;
	}
	

	@Override
	public List<Ticket> selectAllPendingTicketsForUser(int userId) {

		ArrayList<TicketStatusEvent> events = new ArrayList<>();
		List<Ticket> selectedTickets = new ArrayList<>();
		
		PreparedStatement ps;
		String sql = "select * from ticket_table tt inner join ticket_history th on tt.employee_id = 2 and tt.ticket_id = th.ticket_id and th.t_status = 'PENDING'";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Ticket t = new Ticket();
			    TicketStatusEvent e = new TicketStatusEvent();
			    t.setId(rs.getInt("ticket_id"));
			    t.setDescription(rs.getString("description"));
			    t.setTypeString(rs.getString("request"));
			    e.setNewStatusString(rs.getString("t_status"));
			    e.setDate(rs.getDate("issue_date"));
			    
			    events.add(e);
			    t.setTicketHistory(events);
			    
			    selectedTickets.add(t);
			    
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectedTickets;
	}
	
	@Override
	public List<Ticket> selectAllRejectedTicketsForUser(int userId) {
		ArrayList<TicketStatusEvent> events = new ArrayList<>();
		List<Ticket> selectedTickets = new ArrayList<>();
		
		PreparedStatement ps;
		String sql = "select * from ticket_table tt inner join ticket_history th on tt.employee_id = 2 and tt.ticket_id = th.ticket_id and th.t_status = 'REJECTED'";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Ticket t = new Ticket();
			    TicketStatusEvent e = new TicketStatusEvent();
			    t.setId(rs.getInt("ticket_id"));
			    t.setDescription(rs.getString("description"));
			    t.setTypeString(rs.getString("request"));
			    e.setNewStatusString(rs.getString("t_status"));
			    e.setDate(rs.getDate("issue_date"));
			    
			    events.add(e);
			    t.setTicketHistory(events);
			    
			    selectedTickets.add(t);
			    
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectedTickets;
	}

	@Override
	public List<Ticket> selectAllApprovedTicketsForUser(int userId) {
		ArrayList<TicketStatusEvent> events = new ArrayList<>();
		List<Ticket> selectedTickets = new ArrayList<>();
		
		PreparedStatement ps;
		String sql = "select * from ticket_table tt inner join ticket_history th on tt.employee_id = 2 and tt.ticket_id = th.ticket_id and th.t_status = 'APPROVED'";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Ticket t = new Ticket();
			    TicketStatusEvent e = new TicketStatusEvent();
			    t.setId(rs.getInt("ticket_id"));
			    t.setDescription(rs.getString("description"));
			    t.setTypeString(rs.getString("request"));
			    e.setNewStatusString(rs.getString("t_status"));
			    e.setDate(rs.getDate("issue_date"));
			    
			    events.add(e);
			    t.setTicketHistory(events);
			    
			    selectedTickets.add(t);
			    
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectedTickets;
	}

	@Override
	public Ticket insertNewTicket(Ticket t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket selectUserTicket(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TicketStatusEvent> selectAllTicketHistoryForUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> selectRejectedTicketsForUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> selectApprovedTicketsForUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> selectPendingTicketsForUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> selectAllTicketsForUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
