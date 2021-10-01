package com.revature.repo;

public interface TicketHistoryDao {
	
	// Creates a new timestamp
	
	public boolean insertTimeStamp();
	
	// Selects a timestamp
	
	public void selectATimeStamp();
	
	// Select an your own timestamp
	
	public void selectYourOwnTimeStamp();
	
	// Select an employee's timestamp
	
	public void selectEmployeeTimeStamp();
	
	// Selects all the timestamps
	
	public void selectAllTimeStamps();
	
	// Updates with a new timestamp
	
	/* public void updateWithNewTimeStamp();*/
	
	// Delete a time stamp
	
	public boolean deleteTimeStamp();
	

}
