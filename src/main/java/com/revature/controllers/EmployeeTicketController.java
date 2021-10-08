package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.revature.models.RequestType;
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
		
		//getAllMyTickets will load by default when user selects "view tickets" from "/landingPage" form 
		// and handler directs to "/viewTickets" 
		public static String getAllMyTickets(Context ctx) {
				
				try {
					if(EmployeeService.getAllTickets()) {
						return "/allMyTickets.html";
					}
				} else {
					ctx.res.setStatus(401);
					return "/somethingWentWrong.html";
				}
		}
			
			
				
				
			public void getAllMyTicketsOfStatus(Context ctx) {
					
			}
			
			

			
			public void getAllMyPendingTickets() {
				
				
			}
			
			
			
			public void getAllMyApprovedTickets() {
				
			}

			
			
			public void getAllMyRejectedTickets() {
				
			}
			
			
			
			public ArrayList<Ticket> getAllMyTicketHistory() {
				return this.ticketListForEmpDisplay;
			}


			
			
			public void getMyTicketAndHist() {
				
			}
			
			



			public String submitMyTicket(Context ctx) {
				Ticket t = new Ticket();
					t.setAmount(Double.parseDouble(ctx.formParam("amount")));
					t.setDescription(ctx.formParam("description"));
					t.setStatus(TicketStatus.PENDING);
					t.setType(RequestType.valueOf(ctx.formParam("type")));
					t.setEmployeeId(Integer.parseInt(ctx.sessionAttribute("user"))); //probably need to get emp Id from sessionAttributeMap first
				
					if(EmployeeService.submitTicketFromForm(t)) {
						return "/confirmTicketSubmission.html";
					} else {
						ctx.status(401);
						return "/somethingWentWrong.html";
						}
					}	

			
}
	
	
	

