package com.revature.service;

import java.util.List;

import com.revature.models.*;
import com.revature.repo.EmployeeDao;
import com.revature.repo.TicketDao;

public interface ManagerService {



	public static List<Ticket> getAllPendingTickets() {
		return TicketDao.selectAllPendingTickets();
	}

	public static List<Ticket>  getAllApprovedTickets() {
		return TicketDao.selectAllApprovedTickets();
	}

	public static List<Ticket> getAllRejectedTickets() {
		return TicketDao.selectAllRejectedTickets();
	}

	public static List<Ticket> getAllTickets() {
		return TicketDao.selectAllApprovedTickets();
	}

	public static List<TicketStatusEvent> getAllTicketStatusEvents() {
		return TicketDao.selectAllTicketStatusEvents();
	}

	public static List<Ticket> getAllTicketsByEmployeeName(String empName) {
		return TicketDao.selectTicketsByEmployeeName(empName);
	}

	public static Ticket approveTicket(int id) {
		return TicketDao.updateStatusToApproved(id);			
	}

	public static Ticket rejectTicket(int id) {
		return TicketDao.updateStatusToRejected(id);			
	}

	public static Ticket changeStatusToPending(int id) {
		return TicketDao.updateStatusToPending(id);		
	}

	public static List<Ticket> approveAllPendingTickets() {
		return TicketDao.updateAllPendingToApproved();
	}

	public static List<Employee> getListOfEmployees() {
		return EmployeeDao.selectAllEmployees();
	}



}
