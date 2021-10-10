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
	
		
		
		public Integer getTickId() {
			return tickId;
		}
	
	
		public void setTickId(Integer tickId) {
			this.tickId = tickId;
		}
	
	
		public TicketStatus getNewStatus() {
			return newStatus;
		}
	
	
		public void setNewStatus(TicketStatus newStatus) {
			this.newStatus = newStatus;
		}
	
	
		public Calendar getDate() {
			return date;
		}
	
	
		public void setDate(Calendar date) {
			this.date = date;
		}
	
	
	
		//Adding these because of what you discovered about getting enum's to work with DAO methods
		public String getNewStatusString() {
		        return newStatus.name();
		    }
		

		public void setNewStatusString(String newStatus) {
		        this.newStatus = TicketStatus.valueOf(newStatus);
		    }
	


}
