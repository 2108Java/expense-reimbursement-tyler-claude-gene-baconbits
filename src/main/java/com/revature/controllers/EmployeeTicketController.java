package com.revature.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.revature.models.RequestType;
import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.models.TicketStatusEvent;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;

import io.javalin.http.Context;

public class EmployeeTicketController {

	//FIELDS
	ArrayList<Ticket> ticketListForEmpDisplay = new ArrayList<Ticket>();
	private EmployeeService es = new EmployeeService();
	
	
	
	//METHODS
		

			public Context getAllMyTickets(Context ctx) {
				int userId = Integer.parseInt(ctx.sessionAttribute("empId"));
				List<Ticket> allTicketsForUser = new ArrayList<Ticket>();
				allTicketsForUser = es.getAllTicketsForUser(userId);
				return ctx.json(allTicketsForUser);

			}
			
			
				
				
			public Context getAllMyTicketsOfStatus(Context ctx) {
				int userId = Integer.parseInt(ctx.sessionAttribute("empId"));
				TicketStatus status = TicketStatus.valueOf(ctx.formParam("selectedStatus"));
					switch (status) {
						case PENDING:
							return ctx.json(es.getMyPendingTickets(userId));
						case APPROVED:
							return ctx.json(es.getMyApprovedTickets(userId));
						case REJECTED:
							return ctx.json(es.getMyRejectedTickets(userId));
						default:
							return ctx;
					}
			}
			
			

			
			public Context getAllMyPendingTickets(Context ctx) {
				int userId = Integer.parseInt(ctx.sessionAttribute("empId"));
				List<Ticket> userPendingTickets = new ArrayList<Ticket>();
				userPendingTickets = es.getMyPendingTickets(userId);
				return ctx.json(userPendingTickets);
				
			}
			
			
			
			public Context getAllMyApprovedTickets(Context ctx) {
				int userId = Integer.parseInt(ctx.sessionAttribute("empId"));
				List<Ticket> userApprovedTickets = new ArrayList<Ticket>();
				userApprovedTickets = es.getMyApprovedTickets(userId);
				return ctx.json(userApprovedTickets);
			}

			
			
			public Context getAllMyRejectedTickets(Context ctx) {
				int userId = Integer.parseInt(ctx.sessionAttribute("empId"));
				List<Ticket> userRejectedTickets = new ArrayList<Ticket>();
				userRejectedTickets = es.getMyRejectedTickets(userId);
				return ctx.json(userRejectedTickets);
			}
			
			
			
			public Context getAllMyTicketHistory(Context ctx) {
				int userId = Integer.parseInt(ctx.sessionAttribute("empId"));
				List<TicketStatusEvent> userAllTicketHistory = new ArrayList<TicketStatusEvent>();
				userAllTicketHistory = es.getAllMyTicketHistory(userId);
				return ctx.json(userAllTicketHistory);
				
			}


			
			
			public Context getMyTicketAndHist(Context ctx) {
				int id = Integer.parseInt(ctx.formParam("ticketId"));
				Ticket t = es.getMyTicketAndHist(id);
				return ctx.json(t);
			}
			
			


			public Context submitMyTicket(Context ctx) {
				Ticket t = new Ticket();
					t.setAmount(Double.parseDouble(ctx.formParam("amount")));
					t.setDescription(ctx.formParam("description"));
					t.setStatus(TicketStatus.PENDING);
					t.setType(RequestType.valueOf(ctx.formParam("type")));
					t.setEmployeeId(Integer.parseInt(ctx.sessionAttribute("empId")));
				return ctx.json(es.submitTicketFromForm(t));
			}


			
}
	
	
	

