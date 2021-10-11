package com.revature.service;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.models.TicketStatusEvent;
import com.revature.repo.EmployeeDao;

public interface EmployeeService {

	public static Employee getUserByUsername(String username) {
		return EmployeeDao.selectUserByUsername(username);
	}

	public static Ticket submitTicketFromForm(Ticket t) {
		return EmployeeDao.insertNewTicket(t);
	}

	public static Ticket getMyTicketAndHist(int id) {
		return EmployeeDao.selectUserTicket(id);
	}

	public static List<TicketStatusEvent> getAllMyTicketHistory(int userId) {
		return EmployeeDao.selectAllTicketHistoryForUser(userId);
	}

	public static List<Ticket> getMyRejectedTickets(int userId) {
		return EmployeeDao.selectRejectedTicketsForUser(userId);
	}

	public static List<Ticket> getMyApprovedTickets(int userId) {
		return EmployeeDao.selectApprovedTicketsForUser(userId);
	}

	public static List<Ticket> getMyPendingTickets(int userId) {
		return EmployeeDao.selectPendingTicketsForUser(userId);
	}

	public static List<Ticket> getAllTicketsForUser(int userId) {
		return EmployeeDao.selectAllTicketsForUser(userId);
	}

}
