package com.revature.controllers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import com.revature.models.Employee;
import com.revature.models.RequestType;
import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.models.TicketStatusEvent;
import com.revature.service.AuthenticationService;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;
import io.javalin.http.Context;



public class ManagerTicketsController {

	

		//FIELDS
		private ManagerService ms = new ManagerService();

		
		//CONSTRUCTORS
		public ManagerTicketsController(ManagerService ms) {
			super();
			this.ms = ms;
		}
		
		
		public ManagerTicketsController() {
			super();
		}


		
		
		//METHODS for DISPLAYING TICKETS
		public Context getAllTickets(Context ctx) {
			List<Ticket> allTickets = new ArrayList<Ticket>();
			allTickets = ms.getAllTickets();
			return ctx.json(allTickets);
				// send POJOs and just use JS JSON.parse(); change return type to the POJO you wanna send
		}
		
		
		public Context getAllTicketsOfStatus(Context ctx){
			String status = ctx.formParam("selectedStatus");
			switch (status) {
				case "PENDING":
					return ctx.json(ms.getAllPendingTickets());
				case "APPROVED":
					return ctx.json(ms.getAllApprovedTickets());
				case "REJECTED":
					return ctx.json(ms.getAllRejectedTickets());
			}
					return ctx;
			}
		
		
		

		//get by status
		public Context getAllPendingTickets(Context ctx) {
			List<Ticket> allPendingTickets = new ArrayList<Ticket>();
			allPendingTickets = ms.getAllPendingTickets();
			return ctx.json(allPendingTickets);
		}
		
		
		
		public Context getAllApprovedTickets(Context ctx) {
			List<Ticket> allApprovedTickets = new ArrayList<Ticket>();
			allApprovedTickets = ms.getAllApprovedTickets();
			return ctx.json(allApprovedTickets);
			
		}

		
		
		public Context getAllRejectedTickets(Context ctx) {
			List<Ticket> allRejectedTickets = new ArrayList<Ticket>();
			allRejectedTickets = ms.getAllRejectedTickets();
			return ctx.json(allRejectedTickets);
	
		}
		
		
		
		

		//get by emp name		
		public Context getTicketsByEmployeeName(Context ctx) {
			String empName = ctx.formParam("employeeName");
			List<Ticket> ticketsForEmployee = new ArrayList<Ticket>();
			ticketsForEmployee = ms.getAllTicketsByEmployeeName(empName);
			return ctx.json(ticketsForEmployee);
		}
		
		
		
		//METHODS for UPDATING TICKETS
		public Context approveTicket(Context ctx) {
			int id = Integer.parseInt(ctx.formParam("ticketId"));
			Ticket t = new Ticket();
			t = ms.approveTicket(id);
			return ctx.json(t);		
		}
		
		
		
		public Context rejectTicket(Context ctx) {
			int id = Integer.parseInt(ctx.formParam("ticketId"));
			Ticket t = new Ticket();
			t = ms.rejectTicket(id);
			return ctx.json(t);		
		}
		
		
		public Context changeStatusToPending(Context ctx) {
			int id = Integer.parseInt(ctx.formParam("ticketId"));
			Ticket t = new Ticket();
			t = ms.changeStatusToPending(id);
			return ctx.json(t);
		}
		
		
		



		public Context updateWhichStatus(Context ctx) {
				String status = ctx.formParam("new_status");
				switch (status) {
					case "PENDING":
						this.changeStatusToPending(ctx);
					case "APPROVED":
						this.approveTicket(ctx);
					case "REJECTED":
						this.rejectTicket(ctx);
				}
						return this.getAllTickets(ctx);
				}
		
		
}