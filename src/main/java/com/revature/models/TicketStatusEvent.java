package com.revature.models;

import java.util.Calendar;

public class TicketStatusEvent {

	//FIELDS
	private Integer tickId;
	private TicketStatus newStatus;
	private Calendar date;
	
	
	//CONSTRUCTORS
	public TicketStatusEvent() {
		super();
	}


	public TicketStatusEvent(Integer tickId, TicketStatus newStatus, Calendar date) {
		super();
		this.tickId = tickId;
		this.newStatus = newStatus;
		this.date = date;
	}

	
	
}
