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
	private EmployeeService empServ;
	
	
	
	//METHODS
		

			public static Context getAllMyTickets(Context ctx) {
				int userId = Integer.parseInt(ctx.sessionAttribute("empId"));
				List<Ticket> allTicketsForUser = new ArrayList<Ticket>();
				allTicketsForUser = EmployeeService.getAllTicketsForUser(userId);
				return ctx.json(allTicketsForUser);

			}
			
			
				
				
			public static Context getAllMyTicketsOfStatus(Context ctx) {
				int userId = Integer.parseInt(ctx.sessionAttribute("empId"));
				TicketStatus status = TicketStatus.valueOf(ctx.formParam("selectedStatus"));
					switch (status) {
						case PENDING:
							return ctx.json(EmployeeService.getMyPendingTickets(userId));
						case APPROVED:
							return ctx.json(EmployeeService.getMyApprovedTickets(userId));
						case REJECTED:
							return ctx.json(EmployeeService.getMyRejectedTickets(userId));
						default:
							return ctx;
					}
			}
			
			

			
			public static Context getAllMyPendingTickets(Context ctx) {
				int userId = Integer.parseInt(ctx.sessionAttribute("empId"));
				List<Ticket> userPendingTickets = new ArrayList<Ticket>();
				userPendingTickets = EmployeeService.getMyPendingTickets(userId);
				return ctx.json(userPendingTickets);
				
			}
			
			
			
			public static Context getAllMyApprovedTickets(Context ctx) {
				int userId = Integer.parseInt(ctx.sessionAttribute("empId"));
				List<Ticket> userApprovedTickets = new ArrayList<Ticket>();
				userApprovedTickets = EmployeeService.getMyApprovedTickets(userId);
				return ctx.json(userApprovedTickets);
			}

			
			
			public static Context getAllMyRejectedTickets(Context ctx) {
				int userId = Integer.parseInt(ctx.sessionAttribute("empId"));
				List<Ticket> userRejectedTickets = new ArrayList<Ticket>();
				userRejectedTickets = EmployeeService.getMyRejectedTickets(userId);
				return ctx.json(userRejectedTickets);
			}
			
			
			
			public static Context getAllMyTicketHistory(Context ctx) {
				int userId = Integer.parseInt(ctx.sessionAttribute("empId"));
				List<TicketStatusEvent> userAllTicketHistory = new ArrayList<TicketStatusEvent>();
				userAllTicketHistory = EmployeeService.getAllMyTicketHistory(userId);
				return ctx.json(userAllTicketHistory);
				
			}


			
			
			public static Context getMyTicketAndHist(Context ctx) {
				int id = Integer.parseInt(ctx.formParam("ticketId"));
				Ticket t = EmployeeService.getMyTicketAndHist(id);
				return ctx.json(t);
			}
			
			


			//return types?
			public static Context submitMyTicket(Context ctx) {
				Ticket t = new Ticket();
					t.setAmount(Double.parseDouble(ctx.formParam("amount")));
					t.setDescription(ctx.formParam("description"));
					t.setStatus(TicketStatus.PENDING);
					t.setType(RequestType.valueOf(ctx.formParam("type")));
					t.setEmployeeId(Integer.parseInt(ctx.sessionAttribute("empId")));
				return ctx.json(EmployeeService.submitTicketFromForm(t));
			}


			
}
	
	
	

