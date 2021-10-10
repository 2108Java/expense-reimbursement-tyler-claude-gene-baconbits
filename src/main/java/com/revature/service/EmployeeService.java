package com.revature.service;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.models.TicketStatusEvent;
import com.revature.repo.EmployeeDao;

public interface EmployeeService {

	static Employee getUserByUsername(String username) {
		return EmployeeDao.selectUserByUsername(username);
	}

	static boolean submitTicketFromForm(Ticket t) {
		return EmployeeDao.insertNewTicket(t);
	}

	static Ticket getMyTicketAndHist(int id) {
		return EmployeeDao.selectUserTicket(id);
	}

	static List<TicketStatusEvent> getAllMyTicketHistory(int userId) {
		return EmployeeDao.selectAllTicketHistoryForUser(userId);
	}

	static List<Ticket> getMyRejectedTickets(int userId) {
		return EmployeeDao.selectRejectedTicketsForUser(userId);
	}

	static List<Ticket> getMyApprovedTickets(int userId) {
		return EmployeeDao.selectApprovedTicketsForUser(userId);
	}

	static List<Ticket> getMyPendingTickets(int userId) {
		return EmployeeDao.selectPendingTicketsForUser(userId);
	}

	static List<Ticket> getAllTicketsForUser(int userId) {
		return EmployeeDao.selectAllTicketsForUser(userId);
	}

}
