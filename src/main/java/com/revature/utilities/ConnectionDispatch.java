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
	
	public boolean executeBoolean(String sql) {
		boolean success = false;
		
		try {
		getConnection();
		
		prepared = connect.prepareStatement(sql);
		
		success = prepared.execute();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return success;
		
	}
	
	// This method should get any employees that come this way.

	public Employee executeEmployee(String sql) {
		worker = new Employee();
		
		try {
			
			getConnection();
			
			prepared = connect.prepareStatement(sql);
			
			ResultSet results = prepared.executeQuery();
			
			while (results.next()) { 
				// Make the employee.
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return worker;
	}
	
	// This method should generate a single ticket
	
	public Ticket executeTicket(String sql) {
		ticket = new Ticket();
		
		try {
			getConnection();
			
			prepared = connect.prepareStatement(sql);
			
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				// Make the ticket
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ticket;
		
	}
	
	public List<Ticket> executeTickets(String sql) {
		tickets = new ArrayList<>();
		
		try {
			getConnection();
			
			prepared = connect.prepareStatement(sql);
			
			ResultSet results = prepared.executeQuery();
			
			while(results.next()) {
				// make the ticket list.
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tickets;
	}
}
