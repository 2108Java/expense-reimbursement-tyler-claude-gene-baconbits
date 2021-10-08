package com.revature.repo;

import com.revature.models.Employee;
import com.revature.models.Ticket;

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
		return (true || false);
	}


	static boolean selectAllUserTickets() {
		return (true || false);
	}
	
}
