package com.revature.controllers;

import java.util.ArrayList;

import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;

import io.javalin.http.Context;

public class EmployeeTicketController {

	//FIELDS
	ArrayList<Ticket> ticketListForEmpDisplay = new ArrayList<Ticket>();
	private EmployeeService empServ;
	
	
	
	//METHODS for DISPLAYING THE EMPLOYEE'S TICKETS
			public void getAllMyTickets(Context ctx) {
				empServ.getAllTickets();
				
				
				} else {
					ctx.res.setStatus(401);
				}

			
			
			public void getAllMyTicketsOfStatus(TicketStatus x) {
					
			}
			
			

			public void getAllMyPendingTickets() {
				
				
			}
			
			
			
			public void getAllMyApprovedTickets() {
				
			}

			
			
			public void getAllMyRejectedTickets() {
				
			}
			
			
			
			public void getAllMyTicketHistory() {
				
			}


			
			public void getMyTicketAndHist() {
				
			}
			
			

			
}
	
	
	

