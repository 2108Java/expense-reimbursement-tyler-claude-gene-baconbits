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
		
		
		public ManagerTicketsController() {
			super();
		}


		
		
		//METHODS for DISPLAYING TICKETS
		public void getAllTickets(Context ctx) {
			mgrServ.getAllTickets();
			
			
			} else {
				ctx.res.setStatus(401);
			}

		
		
		public void getAllTicketsOfStatus(Context ctx){
				
		}
		
		

		public void getAllPendingTickets(Context ctx) {
			
			
		}
		
		
		
		public void getAllApprovedTickets(Context ctx) {
			
		}

		
		
		public void getAllRejectedTickets(Context ctx) {
			
		}
		
		
		
		public void getAllTicketHistory(Context ctx) {
			
		}


		
		public void getSomeTicketAndHist(Context ctx) {
			
		}
		
		
		//METHODS for UPDATING TICKETS
		public void approveTicket(Context ctx) {
			
		}
		
		
		public void approveAllPendingTickets(Context ctx) {
			
		}
		
		
		public void rejectTicket(Context ctx) {
			
		}

		
		public void changeTicketStatus(Context ctx) {
			
			
		}
		
}

	
	

	

