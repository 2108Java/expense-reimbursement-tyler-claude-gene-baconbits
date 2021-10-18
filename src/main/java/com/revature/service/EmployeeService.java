package com.revature.service;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.models.TicketStatusEvent;
import com.revature.repo.EmployeeDao;
import com.revature.repo.EmployeeDaoImpl;

public class EmployeeService {

	private EmployeeDao empDao = new EmployeeDaoImpl();
	
	
	public Employee getUserByUsername(String username) {
		return empDao.selectByUserName(username);
	}

	public Ticket submitTicketFromForm(Ticket t) {
		return empDao.insertNewTicket(t);
	}

	public Ticket getMyTicketAndHist(int id) {
		return empDao.selectUserTicket(id);
	}

	public List<TicketStatusEvent> getAllMyTicketHistory(int userId) {
		return empDao.selectAllTicketHistoryForUser(userId);
	}

	public List<Ticket> getMyRejectedTickets(int userId) {
		return empDao.selectRejectedTicketsForUser(userId);
	}

	public List<Ticket> getMyApprovedTickets(int userId) {
		return empDao.selectApprovedTicketsForUser(userId);
	}

	public List<Ticket> getMyPendingTickets(int userId) {
		return empDao.selectPendingTicketsForUser(userId);
	}

	public List<Ticket> getAllTicketsForUser(int userId) {
		return empDao.selectAllTicketsForUser(userId);
	}

}
