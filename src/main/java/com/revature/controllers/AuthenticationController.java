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
//		String map = ctx.formParams("username","password");
		
		String un = ctx.formParam("username");
		String pw = ctx.formParam("password");
			System.out.println("the username: " + un + " and the pass: " + pw); // returns null, but why?
			System.out.println(ctx.formParamMap()); // returns map with values from html
			
			try {
			boolean authenticated = as.authenticate(un, pw);
			
			if(authenticated) {
				//if authenticated, send to home page and give session credential
				this.emp = es.getUserByUsername(un);
				ctx.sessionAttribute("user", un);
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
//			return "/login";
	}
}
	


