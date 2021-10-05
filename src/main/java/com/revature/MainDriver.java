package com.revature;

import com.revature.service.RequestHandler;

import io.javalin.Javalin;

public class MainDriver {

	public static void main(String[] args) {

				
		Javalin app = Javalin.create(config ->
			  config.addStaticFiles(staticFiles -> 
			  {
			    staticFiles.directory = "/public";              // the directory where your files are located
			  }
			)).start(8000);		
	
		
		RequestHandler.setupEndPoints(app);
		
	}

	
}
