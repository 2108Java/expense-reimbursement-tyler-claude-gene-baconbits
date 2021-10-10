package com.revature.service;

import java.util.List;

import com.revature.models.*;
import com.revature.repo.EmployeeDao;
import com.revature.repo.TicketDao;

public interface ManagerService {



	static List<Ticket> getAllPendingTickets() {
		return TicketDao.selectAllPendingTickets();
	}

	static List<Ticket>  getAllApprovedTickets() {
		return TicketDao.selectAllApprovedTickets();
	}

	static List<Ticket> getAllRejectedTickets() {
		return TicketDao.selectAllRejectedTickets();
	}

	static List<Ticket> getAllTickets() {
		return TicketDao.selectAllApprovedTickets();
	}

	static List<TicketStatusEvent> getAllTicketStatusEvents() {
		return TicketDao.selectAllTicketStatusEvents();
	}

	static List<Ticket> getAllTicketsByEmployeeName(String empName) {
		return TicketDao.selectTicketsByEmployeeName(empName);
	}

	static Ticket approveTicket(int id) {
		return TicketDao.updateStatusToApproved(id);			
	}

	static Ticket rejectTicket(int id) {
		return TicketDao.updateStatusToRejected(id);			
	}

	static Ticket changeStatusToPending(int id) {
		return TicketDao.updateStatusToPending(id);		
	}

	static List<Ticket> approveAllPendingTickets() {
		return TicketDao.updateAllPendingToApproved();
	}

	static List<Employee> getListOfEmployees() {
		return EmployeeDao.selectAllEmployees();
	}



}
