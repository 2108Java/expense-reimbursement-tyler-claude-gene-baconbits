package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utilities.ConnectionDispatch;

public class EmployeeDaoImp implements EmployeeDao {

	ConnectionDispatch dispatch = new ConnectionDispatch();
	Connection conn;
	
	@Override
	public boolean insertEmployee() {
		
		boolean success = false;
		
		String sql = "INSERT INTO employee_table() VALUES ()";
		
		// append the appropriate values.
		
		
		success = dispatch.executeBoolean(sql);
//		PreparedStatement ps;
//		String sql = "";
//		
//		try { 
//			
////		dispatch.GetConnection();
////		ps = conn.prepareStatement(sql);
////		
////		success = ps.execute();
//		
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		
		return success;
	}

	@Override
	public void selectEmployeeByUserName() {
		
		
		String sql = "SELECT * FROM employee_table WHERE username = ?";
		
		// append the username. 
		
		dispatch.executeEmployee(sql);
		
//		try {
//			
//			dispatch.GetConnection();
//			ps = conn.prepareStatement(sql);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				// to be implemented.
//			}
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//
	}

	@Override
	public void selectEmployeeById() {
		
		String sql = "SELECT * FROM employee_table WHERE employee_id = ?";
		
		// append the employee ID.
		
		dispatch.executeEmployee(sql);
		
		

	}

}
