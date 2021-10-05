package com.revature.controllers;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.service.AuthenticationService;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;
import com.revature.service.UserService;
import io.javalin.http.Context;



public class ManagerTicketsController {

	

		//FIELDS
		ArrayList<Ticket> ticketListForMgrDisplay = new ArrayList<Ticket>();
		private ManagerService mgrServ;

		
		//CONSTRUCTORS
		public ManagerTicketsController(ManagerService mgrServ) {
			super();
			this.mgrServ = mgrServ;
		}


		
		
		//METHODS for DISPLAYING TICKETS
		public void getAllTickets(Context ctx) {
			mgrServ.getAllTickets();
			
			
			} else {
				ctx.res.setStatus(401);
			}

		
		
		public void getAllTicketsOfStatus(TicketStatus x) {
				
		}
		
		

		public void getAllPendingTickets() {
			
			
		}
		
		
		
		public void getAllApprovedTickets() {
			
		}

		
		
		public void getAllRejectedTickets() {
			
		}
		
		
		
		public void getAllTicketHistory() {
			
		}


		
		public void getSomeTicketAndHist() {
			
		}
		
		
		//METHODS for UPDATING TICKETS
		public void approveTicket() {
			
		}
		
		
		public void approveAllPendingTickets() {
			
		}
		
		
		public void rejectTicket() {
			
		}

		
		public void changeTicketStatus(TicketStatus from, TicketStatus to) {
			
			
		}
		
}

	
	

	

