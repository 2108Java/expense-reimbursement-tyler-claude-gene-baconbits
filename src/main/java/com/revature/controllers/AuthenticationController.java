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
	public AuthenticationController() {
		super();
		}


	public static String authenticateUser(Context ctx) throws ServletException, IOException {
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");

		boolean authenticated = AuthenticationService.authenticate(username, password);
		
		if(authenticated) {
			//if authenticated, send to home page and give session credential
			Employee emp = EmployeeService.getUserByUsername(username);
			ctx.sessionAttribute("user", emp);
			ctx.sessionAttribute("empId", emp.getEmpId());
			if(emp.getIsManager()) {
				ctx.sessionAttribute("access", "manager");
			} else ctx.sessionAttribute("access", "employee");
				} else {
					ctx.res.setStatus(401);
					return "/login";
				}
			return "/landingPage";

	}
}

