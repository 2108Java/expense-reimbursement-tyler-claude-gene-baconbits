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
			app.get("/", ctx -> {
				ctx.req.getRequestDispatcher("login.html").forward(ctx.req, ctx.res);	
			});
			
			app.get("/login", ctx -> {
				ctx.req.getRequestDispatcher("login.html").forward(ctx.req, ctx.res);
			});
			
			app.post("/postLogin", ctx -> {	//this end point gets mentioned in xhttp obj in js!
				ctx.redirect(this.ac.authenticateUser(ctx));
			});
			
			
			
			//manager home
			app.get("/managerHome", ctx -> {
				if(ctx.sessionAttribute("access") == "manager") {
				ctx.req.getRequestDispatcher("managerLanding.html").forward(ctx.req, ctx.res);
				} else {
					ctx.res.sendRedirect("/login");
				}
			});
			
			
			app.post("/managerLanding.html", ctx -> { 
						ctx.json(mc.getAllTickets(ctx));
						});
			
			app.post("/changeTicket", ctx -> { //add to managerLanding.js
						mc.updateWhichStatus(ctx);
				
			});
			
			
						//possibly other app.post() to add for manager functions

			

			//employee home
			app.get("/employeeHome", ctx -> {
				if(ctx.sessionAttribute("user") != null) {
				ctx.req.getRequestDispatcher("employeeLanding.html").forward(ctx.req, ctx.res);
				} else {
					ctx.res.sendRedirect("/login");
				}
			});
			
			
			
			app.post("/newTicket", ctx -> { //add to managerLanding.js
				if(ctx.sessionAttribute("user") != null) { 
					ec.submitMyTicket(ctx);
				} else {
					ctx.res.sendRedirect("/login");
				}
			});
			

			
//			ctx.req.getRequestDispatcher("ticketLandingPage.html").forward(ctx.req, ctx.res);
//			ctx.redirect("/managerHome", 200);
//			
//			
//			
//			//employee home
//			ctx.req.getRequestDispatcher("changeTicketStatus.html").forward(ctx.req, ctx.res);
//			ctx.redirect("/employeeHome", 200);
		
						
			
			
			

		
			
				
			//endpoint for VIEW-TICKETS
				app.get("/viewTickets", ctx -> {
						if(checkSession(ctx)) {
							ctx.req.getRequestDispatcher("viewTickets.html").forward(ctx.req, ctx.res);
						} else {
							ctx.res.sendRedirect("/login");
						}
						ctx.json(ec.getAllMyTickets(ctx));
					});

			
				app.get("/dummy1", ctx -> {
					ctx.req.getRequestDispatcher("test.html").forward(ctx.req, ctx.res);	
				});
					
				app.post("/dummy2", ctx -> {	//this end point gets mentioned in xhttp obj in js!
					ctx.json(ec.getDummyList(ctx)); 
				});
					
				

			
//			//endpoint for LOGOUT
			app.get("/endSession", ctx -> 
				{  ctx.consumeSessionAttribute("user");
					ctx.redirect("/", 200);
				});	
			}
			}
		