package com.revature.controllers;

import java.time.LocalDate;
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
	LocalDate local;
	
	
	//METHODS
		
	public ArrayList<Ticket> getDummyList(Context ctx) {
		
		Ticket t1 = new Ticket (1,1,200.00,"had an expense","FOOD","PENDING", LocalDate.now().toString());
		Ticket t2 = new Ticket (2,1,190.00,"had some other expense","TRAVEL","PENDING",LocalDate.now().toString());
		Ticket t3 = new Ticket (3,1,180.00,"additional expense","LODGING","PENDING",LocalDate.now().toString());
		Ticket t4 = new Ticket (4,1,170.00,"more expensive expense","OTHER","PENDING",LocalDate.now().toString());
		Ticket t5 = new Ticket (5,2,160.25,"hotels","LODGING","APPROVED",LocalDate.now().toString());
		Ticket t6 = new Ticket (6,2,150.55,"restaurants","FOOD","REJECTED",LocalDate.now().toString());
		Ticket t7 = new Ticket (7,3,140.65,"car fare","TRAVEL","PENDING",LocalDate.now().toString());
		Ticket t8 = new Ticket (8,4,135.95,"had some other expense","LODGING","PENDING",LocalDate.now().toString());
		Ticket t9 = new Ticket (9,4,125.85,"had some other expense","OTHER","PENDING",LocalDate.now().toString());
		ArrayList<Ticket> dummyList = new ArrayList<Ticket>();
		dummyList.add(t1);
		dummyList.add(t2);
		dummyList.add(t3);
		dummyList.add(t4);
		dummyList.add(t5);
		dummyList.add(t6);
		dummyList.add(t7);
		dummyList.add(t8);
		dummyList.add(t9);		
		ctx.res.setStatus(200);
		return dummyList;
		
	}

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
					t.setStatus(TicketStatus.PENDING.toString());
					t.setType(ctx.formParam("type"));
					t.setEmployeeId(Integer.parseInt(ctx.sessionAttribute("empId")));
				return ctx.json(es.submitTicketFromForm(t));
			}


			
}
	
	
	

