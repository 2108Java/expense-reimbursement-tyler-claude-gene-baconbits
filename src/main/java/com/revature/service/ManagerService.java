package com.revature.service;

import java.util.List;

import com.revature.models.*;
import com.revature.repo.EmployeeDao;
import com.revature.repo.EmployeeDaoImpl;
import com.revature.repo.TicketDao;
import com.revature.repo.TicketDaoImpl;
import com.revature.repo.TicketHistoryDao;
import com.revature.repo.TicketHistoryDaoImpl;

public class ManagerService {

		private TicketDao tDao = new TicketDaoImpl();
		private EmployeeDao eDao = new EmployeeDaoImpl();
		private TicketHistoryDao hDao = new TicketHistoryDaoImpl();
		
	public List<Ticket> getAllPendingTickets() {
		return tDao.selectAllPendingTickets();
	}

	public List<Ticket>  getAllApprovedTickets() {
		return tDao.selectAllApprovedTickets();
	}

	public List<Ticket> getAllRejectedTickets() {
		return tDao.selectAllRejectedTickets();
	}

	public List<Ticket> getAllTickets() {
		return tDao.selectAllApprovedTickets();
	}

	public List<TicketStatusEvent> getAllTicketStatusEvents() {
		return hDao.selectAllTicketStatusEvents();
	}

	public List<Ticket> getAllTicketsByEmployeeName(String empName) {
		return tDao.selectTicketsByEmployeeName(empName);
	}

	public Ticket approveTicket(int id) {
		return tDao.updateStatusToApproved(id);			
	}

	public Ticket rejectTicket(int id) {
		return tDao.updateStatusToRejected(id);			
	}

	public Ticket changeStatusToPending(int id) {
		return tDao.updateStatusToPending(id);		
	}

	public List<Ticket> approveAllPendingTickets() {
		return tDao.updateAllPendingToApproved();
	}

	public List<Employee> getListOfEmployees() {
		return eDao.selectAllEmployees();
	}



}
