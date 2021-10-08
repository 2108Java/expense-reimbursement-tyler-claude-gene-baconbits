package com.revature.service;

import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.repo.EmployeeDao;

public interface EmployeeService {

	Employee getUserByUsername(String username);

	static boolean getAllTickets() {
		return EmployeeDao.selectAllUserTickets();
	}

	static boolean submitTicketFromForm(Ticket t) {
		return EmployeeDao.insertNewTicket(t);
		
	}

}
