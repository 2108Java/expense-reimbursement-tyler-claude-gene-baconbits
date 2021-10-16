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
import com.revature.repo.TicketDaoImpl;

public class TicketHistoryDaoImpl implements TicketHistoryDao {

	ConnectionDispatch dispatch = new ConnectionDispatch();
	TicketDao tDao = new TicketDaoImpl();
	
	Connection conn;
	Employee emp;
	Ticket ticket;
	
	
	@Override
	public boolean insertTicketStatus(int ticketId) {
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
			tDao.selectAllTickets();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return goodOps;
	}


	@Override
	public boolean updateStatusToRejected(int ticketId) {
		boolean goodOps = false;
		
		String sql = "UPDATE ticket_hisory SET t_status = ? AND date = CURRENT_DATE WHERE ticket_id = ?";
		
		try {
			
			dispatch.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, TicketStatus.REJECTED.name());
			ps.setInt(2, ticketId);
			
			goodOps = ps.execute();
			tDao.selectAllTickets();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return goodOps;
	}


	@Override
	public boolean updateStatusToApproved(int ticketId) {
		boolean goodOps = false;
		
		String sql = "UPDATE ticket_hisory SET t_status = ? AND date = CURRENT_DATE WHERE ticket_id = ?";
		
try {
			
			dispatch.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, TicketStatus.APPROVED.name());
			ps.setInt(2, ticketId);
			
			goodOps = ps.execute();
			tDao.selectAllTickets();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return goodOps;
	}


	@Override
	public boolean updateStatusToPending(int ticketId) {
		boolean goodOps = false;
		
		String sql = "UPDATE ticket_hisory SET t_status = ? AND date = CURRENT_DATE WHERE ticket_id = ?";
		
try {
			
			dispatch.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, TicketStatus.PENDING.name());
			ps.setInt(2, ticketId);
			
			goodOps = ps.execute();
			tDao.selectAllTickets();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return goodOps;
	}

	

	

}