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
		ArrayList<Ticket> ticketListForMgrDisplay = new ArrayList<Ticket>();
		private ManagerService ms = new ManagerService();

		
		//CONSTRUCTORS
		public ManagerTicketsController(ManagerService mgrServ) {
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
				
		}
		
		
		public Context getAllTicketsOfStatus(Context ctx){
			TicketStatus status = TicketStatus.valueOf(ctx.formParam("selectedStatus"));
			switch (status) {
				case PENDING:
					return ctx.json(ms.getAllPendingTickets());
				case APPROVED:
					return ctx.json(ms.getAllApprovedTickets());
				case REJECTED:
					return ctx.json(ms.getAllRejectedTickets());
				default:
					return ctx;
			}
		}
		
		

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
		
		
		
		public Context getAllTicketHistory(Context ctx) {
			List<TicketStatusEvent> allTicketStatusEvents = new ArrayList<TicketStatusEvent>();
			allTicketStatusEvents = ms.getAllTicketStatusEvents();
			return ctx.json(allTicketStatusEvents);
			
		}


		
		public Context getSomeTicketById(Context ctx) {
			int id = Integer.parseInt(ctx.formParam("ticketId"));
			Ticket t = new Ticket();
			return ctx.json(t);
		}
		
		
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
		
		
		
		public Context approveAllPendingTickets(Context ctx) {
			List<Ticket> listOfTickets = new ArrayList<Ticket>();
			listOfTickets = ms.approveAllPendingTickets();
			return ctx.json(listOfTickets);
		}
		
		
		public Context getListOfEmployees(Context ctx) {
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			listOfEmployees = ms.getListOfEmployees();
			return ctx.json(listOfEmployees);
		}
		
}