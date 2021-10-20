package com.revature.models;

import java.util.Objects;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import com.revature.repo.*;

public class Ticket {

		//FIELDS
		private int id; //serial, primary key in database
		private int employeeId; //person who is requesting reimbursement, foreignkey
		private double amount; //on submission
		private String description; //provided by employee on submission
		private String type; //lodging, travel, food, or other
		private String status; //approved, pending, or rejected
		private String date;

			
		//CONSTRUCTORS
		public Ticket() {
			super();

		}


		public Ticket(int i, int j, double d, String string, String string2, String string3) {
			this.id = i;
			this.employeeId = j;
			this.amount = d;
			this.description = string;
			this.type = string2;
			this.status = string3;
			this.date = LocalDate.now().toString();		
			}




		public Ticket(int i, int j, double d, String string, String string2, String string3, String date) {
			this.id = i;
			this.employeeId = j;
			this.amount = d;
			this.description = string;
			this.type = string2;
			this.status = string3;
			this.date = LocalDate.now().toString();		
			}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getEmployeeId() {
			return employeeId;
		}


		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}


		public double getAmount() {
			return amount;
		}


		public void setAmount(double amount) {
			this.amount = amount;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}





		@Override
		public String toString() {
			return "TestTicket [id=" + id + ", employeeId=" + employeeId + ", amount=" + amount + ", description="
					+ description + ", type=" + type + ", status=" + status + ", date=" + date + "]";
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


	
}
