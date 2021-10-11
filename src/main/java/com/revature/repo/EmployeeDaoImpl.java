package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employee;
import com.revature.utilities.ConnectionDispatch;

public class EmployeeDaoImpl implements EmployeeDao {

	ConnectionDispatch dispatch = new ConnectionDispatch();
	Connection conn;
	
	@Override
	public boolean insertEmployee(String username, String password, String first_name, String last_name, String email) {
		
		boolean success = false;
		
		String sql = "INSERT INTO employee_table(username, password, first_name, last_name, email, is_manager) VALUES (?,?,?,?,?,?)";
		
		
		PreparedStatement ps;
		
		
		try { 
			
		dispatch.getConnection();
		
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
			dispatch.getConnection();
			
			
			
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
			dispatch.getConnection();
			
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
		
		String sql = "SELECT * FROM employee_table WHERE username = ? AND password = ?";
		
		try {
			dispatch.getConnection();
			
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
			dispatch.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			goodOps = ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return goodOps;
	}

}
