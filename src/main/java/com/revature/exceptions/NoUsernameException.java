package com.revature.exceptions;

public class NoUsernameException extends Exception{
	
	public String message() {
		return "You need to enter a valid username.";
					
	}

}
