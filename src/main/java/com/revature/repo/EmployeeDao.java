package com.revature.repo;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.models.TicketStatusEvent;


public interface EmployeeDao {

	// Create an employee
	
	public boolean insertEmployee(String username, String password, String first_name, String last_name, String email);
	
	// Selects an Employee by User Name and by ID
	
	public Employee selectByUserName(String username);
	
	public boolean selectUserNameAndPass(String username, String password);
	
	public Employee selectEmployeeById(int id);
	
	public boolean selectCheckUserName(String username);

	public List<Ticket> selectUserTickets(int employee_id);
	
	public List<TicketStatusEvent> selectAllTicketHistoryForUser(int userId);
	
	public List<Ticket> selectAllTicketsForUser(int userId);
	
	public List<Ticket> selectAllPendingTicketsForUser(int userId);
	
	public List<Ticket> selectAllRejectedTicketsForUser(int userId);
	
	public List<Ticket> selectAllApprovedTicketsForUser(int userId);
	
	// Update an Employee because reasons
	
	public boolean updateEmployeePasswordByUsername();
	
	// Delete an Employee because reasons
	
	public boolean deleteEmployee();

	public Ticket insertNewTicket(Ticket t);

	public Ticket selectUserTicket(int id);

	public List<TicketStatusEvent> selectAllTicketHistoryForUser(int userId);

	public List<Ticket> selectRejectedTicketsForUser(int userId);

	public List<Ticket> selectApprovedTicketsForUser(int userId);
	

	public List<Ticket> selectPendingTicketsForUser(int userId);

	public List<Ticket> selectAllTicketsForUser(int userId);

	public List<Employee> selectAllEmployees();
	
}
