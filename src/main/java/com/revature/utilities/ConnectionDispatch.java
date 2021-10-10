package com.revature.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	
}
