package com.revature.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;

public class ConnectionDispatch {

	private static final String URL = "";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	
	PreparedStatement prepared; 
	
	Connection connect;
	Employee worker;
	Ticket ticket;
	List<Ticket> tickets;
	
	public ConnectionDispatch() {
		super();
	}
	
	
	public Connection getConnection() throws SQLException{
		
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		return conn;
		
	}
	
	
	// Should execute to the database any needed booleans that come this way.
	
	
	
	// This method should get any employees that come this way.

	
	public Ticket executeTicket(PreparedStatement prepared) {
		ticket = new Ticket();
		
		try {
			getConnection();
			

			
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				ticket.setId(result.getInt("ticket_id"));
				ticket.setEmployeeId(result.getInt("employee_id"));
				ticket.setAmount(result.getDouble("amount"));
				ticket.setType(result.getString("type"));
				ticket.setDescription(result.getString("description"));
				ticket.setStatus(result.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ticket;
		
	}
	
	public List<Ticket> executeTickets(PreparedStatement prepared) {
		tickets = new ArrayList<>();
		
		try {
			getConnection();
			
			ResultSet results = prepared.executeQuery();
			
			while(results.next()) {
				tickets.add(
						new Ticket(
								
								(results.getInt("account_id")),
								(results.getInt("employee_id")),
								(results.getDouble("amount")),
								(results.getString("type")),
								(results.getString("description")),
								(results.getString("status"))
								
								));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tickets;
	}
	
	
	// Make the ticket histories.
	
}
