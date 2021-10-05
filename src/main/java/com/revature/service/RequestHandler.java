package com.revature.service;

import com.revature.controllers.AuthenticationController;
import com.revature.repo.EmpDaoImpl;
import com.revature.repo.EmployeeDao;
import com.revature.repo.TicketDao;
import com.revature.repo.TicketDaoImpl;
import com.revature.repo.TicketHistDao;
import com.revature.repo.TicketHistDaoImpl;
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
	
	AuthenticationController ac = new AuthenticationController(authServ, userServ);
	
	
	
	
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
					ctx.req.getRequestDispatcher("login.html").forward(ctx.req, ctx.res));
	
		
		
		//endpoint for AUTHENTICATED
			//I think this is the one that needs a forward request
			app.post("/authenticate", ctx -> {
					try {
						ac.authenticateUser(ctx);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			
 
			
		
		
			
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
			app.post("/submitTicket", ctx -> {
				if(checkSession(ctx)) {
					ctx.req.getRequestDispatcher("submitTicket.html").forward(ctx.req, ctx.res);
				} else {
					ctx.res.sendRedirect("/login");
				}
			});	
	
		
		//endpoint for VIEW-TICKETS
			app.get("/viewTickets", ctx -> {
				if(checkSession(ctx)) {
					ctx.req.getRequestDispatcher("viewTickets.html").forward(ctx.req, ctx.res);
				} else {
					ctx.res.sendRedirect("/login");
				}
			});
	
				
		
		//endpoint for UPDATE-TICKETS
				//needs to be available only to managers, so write some logic using session-attribute
				//isManager was inlcuded by Gene in EMPLOYEES table
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

