package com.revature.exceptions;

public class WrongPasswordException extends Exception{

	public String message() {
		return "Please re-enter your password";
	}
}
