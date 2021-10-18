package com.revature.controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;



public class RequestHandler {

				
				AuthenticationController ac = new AuthenticationController();
				EmployeeTicketController ec = new EmployeeTicketController();
				ManagerTicketsController mc = new ManagerTicketsController();
	
	
	
		//METHODS
		public boolean checkSession(Context ctx) {
			if(ctx.sessionAttribute("user")!=null) {
				return true;
			} else {
				return false;
			}
		}
		
		
		
		
		public void setupEndPoints(Javalin app) {
							
			//endpoint for LOGIN page
				app.get("/", ctx -> 
					ctx.req.getRequestDispatcher("login.html").forward(ctx.req, ctx.res));
				
				
				app.get("/login", ctx ->
					ctx.req.getRequestDispatcher("login.html").forward(ctx.req, ctx.res));
				
				app.post("/login", ctx -> 			
						this.ac.authenticateUser(ctx));
			
			
			
				
			//endpoint for LANDING page
				app.get("/landingPage", ctx -> {
						if(checkSession(ctx)) {
							ctx.req.getRequestDispatcher("ticketLandingPage.html").forward(ctx.req, ctx.res);
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

				});
			
			
			
			
			//endpoint for LOGOUT
			app.get("/endSession", ctx -> ctx.consumeSessionAttribute("user"));		
		
		
		}
	
	
}

