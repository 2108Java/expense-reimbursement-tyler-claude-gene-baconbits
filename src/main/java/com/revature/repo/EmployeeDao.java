package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.models.TicketStatusEvent;

public interface EmployeeDao {

	boolean selectByUserName();


	static boolean selectUserNameAndPass() {
		// TODO Auto-generated method stub
		return (true || false);
	}


	Employee selectUser(String username);


	static boolean selectCheckUserName() {
		// TODO Auto-generated method stub
		return (true || false);
	}


	static boolean insertNewTicket(Ticket t) {
		//dao logic
		return true;
	}


	static Ticket selectUserTicket(int id) {
		Ticket t = new Ticket();
		//dao logic
		return t;
	}


	static List<Ticket> selectAllTicketsForUser(int userId) {
		List<Ticket> usersAllTicketsList = new ArrayList<Ticket>();
		//dao logic
		return usersAllTicketsList;
	}


	static List<Ticket> selectRejectedTicketsForUser(int userId) {
		List<Ticket> usersRejectedTicketsList = new ArrayList<Ticket>();
		//dao logic
		return usersRejectedTicketsList;
	}


	static List<Ticket> selectApprovedTicketsForUser(int userId) {
		List<Ticket> usersApprovedTicketsList = new ArrayList<Ticket>();
		//dao logic
		return usersApprovedTicketsList;
	}


	static List<Ticket> selectPendingTicketsForUser(int userId) {
		List<Ticket> usersPendingTicketsList = new ArrayList<Ticket>();
		//dao logic
		return usersPendingTicketsList;
	}


	static Employee selectUserByUsername(String username) {
		Employee e = new Employee();
		//dao logic
		return e;
	}


	static List<TicketStatusEvent> selectAllTicketHistoryForUser(int userId) {
		List<TicketStatusEvent> userTicketHistory = new ArrayList<TicketStatusEvent>();
		//dao logic
		return userTicketHistory;
	}


	static List<Employee> selectAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		//dao logic
		return employeeList;
	}
	
}
