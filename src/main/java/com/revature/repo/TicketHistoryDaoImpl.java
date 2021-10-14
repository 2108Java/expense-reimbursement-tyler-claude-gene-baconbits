package com.revature.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;

import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.models.TicketStatus;
import com.revature.utilities.ConnectionDispatch;

public class TicketHistoryDaoImpl implements TicketHistoryDao {

	ConnectionDispatch dispatch = new ConnectionDispatch();
	TicketDao tDao = new TicketDaoImp();
	
	Connection conn;
	Employee emp;
	Ticket ticket;
	
	
	@Override
	public boolean insertTimeStamp(int ticketId) {
		boolean goodOps = false;
		
		String status = TicketStatus.PENDING.name();
		
		TimeZone tzone = TimeZone.getTimeZone("America/Los_Angeles"); // Pacific Standard Time.
		Calendar time = Calendar.getInstance(tzone);
		
		
		String sql = "INSERT INTO ticket_history(ticket_id, ticket_status, date) VALUES (?, ?, CURRENT_DATE)";
		// Gets today's date in SQL. Unfortunately with no Time.
		
		try {
			
			dispatch.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, ticketId);
			ps.setString(2, status);
			
			
			goodOps = ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return goodOps;
	}

	@Override
	 public void selectATimeStamp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectYourOwnTimeStamp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectEmployeeTimeStamp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectAllTimeStamps() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteTimeStamp() {
		// TODO Auto-generated method stub
		return false;
	}

}
