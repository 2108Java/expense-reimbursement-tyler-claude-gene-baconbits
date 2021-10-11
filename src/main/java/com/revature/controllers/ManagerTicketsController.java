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
		public static Context getAllTickets(Context ctx) {
			List<Ticket> allTickets = new ArrayList<Ticket>();
			allTickets = ManagerService.getAllTickets();
			return ctx.json(allTickets);
				
		}
		
		
		public static Context getAllTicketsOfStatus(Context ctx){
			TicketStatus status = TicketStatus.valueOf(ctx.formParam("selectedStatus"));
			switch (status) {
				case PENDING:
					return ctx.json(ManagerService.getAllPendingTickets());
				case APPROVED:
					return ctx.json(ManagerService.getAllApprovedTickets());
				case REJECTED:
					return ctx.json(ManagerService.getAllRejectedTickets());
				default:
					return ctx;
			}
		}
		
		

		public static Context getAllPendingTickets(Context ctx) {
			List<Ticket> allPendingTickets = new ArrayList<Ticket>();
			allPendingTickets = ManagerService.getAllPendingTickets();
			return ctx.json(allPendingTickets);
		}
		
		
		
		public static Context getAllApprovedTickets(Context ctx) {
			List<Ticket> allApprovedTickets = new ArrayList<Ticket>();
			allApprovedTickets = ManagerService.getAllApprovedTickets();
			return ctx.json(allApprovedTickets);
			
		}

		
		
		public static Context getAllRejectedTickets(Context ctx) {
			List<Ticket> allRejectedTickets = new ArrayList<Ticket>();
			allRejectedTickets = ManagerService.getAllRejectedTickets();
			return ctx.json(allRejectedTickets);
	
		}
		
		
		
		public static Context getAllTicketHistory(Context ctx) {
			List<TicketStatusEvent> allTicketStatusEvents = new ArrayList<TicketStatusEvent>();
			allTicketStatusEvents = ManagerService.getAllTicketStatusEvents();
			return ctx.json(allTicketStatusEvents);
			
		}


		
		public static Context getSomeTicketById(Context ctx) {
			int id = Integer.parseInt(ctx.formParam("ticketId"));
			Ticket t = new Ticket();
			return ctx.json(t);
		}
		
		
		public static Context getTicketsByEmployeeName(Context ctx) {
			String empName = ctx.formParam("employeeName");
			List<Ticket> ticketsForEmployee = new ArrayList<Ticket>();
			ticketsForEmployee = ManagerService.getAllTicketsByEmployeeName(empName);
			return ctx.json(ticketsForEmployee);
		}
		
		
		//METHODS for UPDATING TICKETS
		public static Context approveTicket(Context ctx) {
			int id = Integer.parseInt(ctx.formParam("ticketId"));
			Ticket t = new Ticket();
			t = ManagerService.approveTicket(id);
			return ctx.json(t);		
		}
		
		
		
		public static Context rejectTicket(Context ctx) {
			int id = Integer.parseInt(ctx.formParam("ticketId"));
			Ticket t = new Ticket();
			t = ManagerService.rejectTicket(id);
			return ctx.json(t);		
		}
		
		
		public static Context changeStatusToPending(Context ctx) {
			int id = Integer.parseInt(ctx.formParam("ticketId"));
			Ticket t = new Ticket();
			t = ManagerService.changeStatusToPending(id);
			return ctx.json(t);
		}
		
		
		
		public static Context approveAllPendingTickets(Context ctx) {
			List<Ticket> listOfTickets = new ArrayList<Ticket>();
			listOfTickets = ManagerService.approveAllPendingTickets();
			return ctx.json(listOfTickets);
		}
		
		
		public static Context getListOfEmployees(Context ctx) {
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			listOfEmployees = ManagerService.getListOfEmployees();
			return ctx.json(listOfEmployees);
		}
		
}