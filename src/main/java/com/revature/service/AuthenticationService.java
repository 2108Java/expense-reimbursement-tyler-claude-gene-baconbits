package com.revature.service;

public interface AuthenticationService {

	public boolean verify(String username);
	
	public boolean authenticate(String username, String password);
	
}
