package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;

import com.revature.models.Employee;
import com.revature.service.AuthenticationService;
import com.revature.service.EmployeeService;

import io.javalin.http.Context;




public class AuthenticationController {

	
	
	//FIELDS
	private AuthenticationService as = new AuthenticationService();
	private Employee emp = new Employee();
	private EmployeeService es = new EmployeeService();
	
	//CONSTRUCTORS
	public AuthenticationController() {
		super();
		}


	public void authenticateUser(Context ctx) throws ServletException, IOException {
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");

		try {
			
			try {
			boolean authenticated = as.authenticate(username, password);
			System.out.println(authenticated);
			if(authenticated) {
				//if authenticated, send to home page and give session credential
				this.emp = es.getUserByUsername(username);
				ctx.sessionAttribute("user", username);
				ctx.sessionAttribute("empId", emp.getEmpId());
				ctx.json(emp);
			} 
				if(emp.getIsManager()) {
					ctx.sessionAttribute("access", "manager");
					ctx.req.getRequestDispatcher("changeTicketStatus.html").forward(ctx.req, ctx.res);
				} else { ctx.sessionAttribute("access", "employee");
					ctx.req.getRequestDispatcher("landingPage.html").forward(ctx.req, ctx.res);
					} 
				} finally {
						ctx.res.setStatus(401);
						ctx.redirect("/login"); 
						 ctx.json(emp); }
							}
			 catch (Exception e) { e.printStackTrace();}
	}
	}


