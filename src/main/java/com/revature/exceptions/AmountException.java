package com.revature.exceptions;

public class AmountException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String message() {
		return "You have written a negative amount. \n Please write a valid amount.";
	}

}
