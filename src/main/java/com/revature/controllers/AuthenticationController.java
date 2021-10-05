package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;

import com.revature.models.Employee;
import com.revature.service.AuthenticationService;
import com.revature.service.EmployeeService;
import com.revature.service.UserService;

import io.javalin.http.Context;




public class AuthenticationController {

	
	
	//FIELDS
	private AuthenticationService authServ;
	private UserService userServ;
	
	//CONSTRUCTORS
	public AuthenticationController(AuthenticationService authServ, UserService userServ) {
		super();
		this.authServ = authServ;
		this.userServ = userServ;
		}


	public void authenticateUser(Context ctx) throws ServletException, IOException {
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");

		boolean authenticated = authServ.authenticate(username, password);
		
		if(authenticated) {
			//if authenticated, send to home page and give session credential
			Employee emp = userServ.getUserByUsername(username);
			ctx.sessionAttribute("user", emp);
			
			if(emp.getIsManager()) {
				ctx.sessionAttribute("access", "manager");
			} else ctx.sessionAttribute("access", "employee");
			ctx.res.sendRedirect("/landingPage");
		
				} else {
					ctx.res.setStatus(401);
				}
		

	}
}

