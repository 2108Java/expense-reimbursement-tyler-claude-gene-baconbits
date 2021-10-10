package com.revature.controllers;

import com.revature.repo.EmpDaoImpl;
import com.revature.repo.EmployeeDao;
import com.revature.repo.TicketDao;
import com.revature.repo.TicketDaoImpl;
import com.revature.repo.TicketHistDao;
import com.revature.repo.TicketHistDaoImpl;
import com.revature.service.AuthenticationService;
import com.revature.service.AuthenticationServiceImpl;
import com.revature.service.EmployeeService;
import com.revature.service.EmployeeServiceImpl;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

import io.javalin.Javalin;
import io.javalin.http.Context;



public class RequestHandler {

	//FIELDS
	TicketDao tDao = new TicketDaoImpl();
	EmployeeDao empDao = new EmpDaoImpl();
	TicketHistDao tHistDao = new TicketHistDaoImpl();
	
	AuthenticationService authServ = new AuthenticationServiceImpl();
	UserService userServ = new UserServiceImpl();
	EmployeeService empServ = new EmployeeServiceImpl();
	
	AuthenticationController ac = new AuthenticationController();
	EmployeeTicketController ec = new EmployeeTicketController();
	ManagerTicketsController mc = new ManagerTicketsController();
	
	
	
	//METHODS
	public static boolean checkSession(Context ctx) {
		if(ctx.sessionAttribute("user")!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	public static void setupEndPoints(Javalin app) {
						
		//endpoint for LOGIN page
			app.get("/", ctx -> 
				ctx.req.getRequestDispatcher("login.html").forward(ctx.req, ctx.res));
			
			
			app.get("/login", ctx -> 			
//					ctx.req.getRequestDispatcher("login.html").forward(ctx.req, ctx.res)); //think I actually want to call the authentication method to return correct page
					ctx.redirect(AuthenticationController.authenticateUser(ctx)));
		
		
		
			
		//endpoint for LANDING page
			app.get("/landingPage", ctx -> {
					if(checkSession(ctx)) {
						ctx.req.getRequestDispatcher("landingPage.html").forward(ctx.req, ctx.res);
					} else {
						ctx.res.sendRedirect("/login");
					} 
					
				});
					
		
		
		
		//endpoint for SUBMIT-TICKET
			//don't use GET, because we don't want query-params displayed in search bar
			app.post("/newTicket", ctx -> {
					if(checkSession(ctx)) {
						ctx.req.getRequestDispatcher("newTicket.html").forward(ctx.req, ctx.res);
					} else {
						ctx.res.sendRedirect("/login");
					}				 
					ctx.json(EmployeeTicketController.submitMyTicket(ctx)); 
				});
	
		
			
		//endpoint for VIEW-TICKETS
			app.get("/viewTickets", ctx -> {
					if(checkSession(ctx)) {
						ctx.req.getRequestDispatcher("viewTickets.html").forward(ctx.req, ctx.res);
					} else {
						ctx.res.sendRedirect("/login");
					}
					ctx.json(EmployeeTicketController.getAllMyTickets(ctx));
				});
	
				
		
		//endpoint for UPDATE-TICKETS
				//needs to be available only to managers, so write some logic using session-attribute
				//isManager was included by Gene in EMPLOYEES table
			app.get("/changeTicketStatus", ctx -> {
				if(ctx.sessionAttribute("access") == "manager") {
					ctx.req.getRequestDispatcher("changeTicketStatus.html").forward(ctx.req, ctx.res);
				} else {
					ctx.res.sendRedirect("/login");
				}
//				ctx.redirect(ManagerTicketsController.
//						(ctx));

			});
		
		
		
		
		//endpoint for LOGOUT
		app.get("/endSession", ctx -> ctx.consumeSessionAttribute("user"));		
	
	
	}
	
	
}

