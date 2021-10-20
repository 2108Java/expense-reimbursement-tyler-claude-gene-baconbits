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

	private static final String URL = "jdbc:postgresql://database-1.cuxfgs7svfhd.us-east-2.rds.amazonaws.com/";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "49STOREdata40$16";
	
	
	public Connection connect;

	
	public ConnectionDispatch() {
		super();
	}
	
	
	public final Connection getConnection() throws SQLException{
		
		
		try {
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		this.connect = conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} return this.connect;
	}
	
	
}
