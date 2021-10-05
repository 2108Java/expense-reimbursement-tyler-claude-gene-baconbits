package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employee;
import com.revature.utilities.ConnectionDispatch;

public class EmployeeDaoImp implements EmployeeDao {

	ConnectionDispatch dispatch = new ConnectionDispatch();
	Connection conn;
	
	@Override
	public boolean insertEmployee(String username, String first_name, String last_name, String email) {
		
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
	public Employee selectEmployeeByUserName(String username) {
		
		Employee emp = new Employee();
		
		String sql = "SELECT * FROM employee_table WHERE username = ?";
		
		// append the username. 
		
		emp = dispatch.executeEmployee(sql);
		
		
		return emp;
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
	public Employee selectEmployeeById(int id) {
		
		Employee emp = new Employee();
		String sql = "SELECT * FROM employee_table WHERE employee_id = ?";
		
		// append the employee ID.
		
		emp = dispatch.executeEmployee(sql);
		
		
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

}
