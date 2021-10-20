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


	public String authenticateUser(Context ctx) throws ServletException, IOException {
		String username = ctx.req.getParameter("username");
		String password = ctx.req.getParameter("password");

			
			try {
			boolean authenticated = as.authenticate(username, password);
			
			if(authenticated) {
				//if authenticated, send to home page and give session credential
				this.emp = es.getUserByUsername(username);
				ctx.sessionAttribute("user", username);
				ctx.sessionAttribute("empId", emp.getEmpId());
				} 
				if(emp.getIsManager()) {
					ctx.sessionAttribute("access", "manager");
					ctx.redirect("/managerHome", 200);
				} else { 
					ctx.sessionAttribute("access", "employee");
					ctx.redirect("/employeeHome", 200);
					}
				} finally {
					ctx.res.setStatus(401);
					ctx.redirect("/login");
				}
			return "/login";
	}
}
	


