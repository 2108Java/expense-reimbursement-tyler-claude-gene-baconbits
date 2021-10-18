package com.revature;

import com.revature.controllers.RequestHandler;

import io.javalin.Javalin;

public class MainDriver {

	public static void main(String[] args) {

				
		Javalin app = Javalin.create(config ->
			  config.addStaticFiles(staticFiles -> 
			  {
			    staticFiles.directory = "/public";  // the directory where your files are located in src>main>resources
			  }
			)).start(8000);	//dao will be on Gene's RDS; front-end will be hosted on Tyler's EC2	
	
		
		RequestHandler rh = new RequestHandler();
		
		rh.setupEndPoints(app);
		
	}

	
}
