package com.midterm.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Appointment {
	
	private static int idSeed=1;
	private int id;
	private LocalDateTime appTime;
	private String name;
	private String department;
	private String status;
	private String reason;
	private String assignedTo;
	
	public Appointment() {
		id=idSeed++;
	}
	

	public Appointment(LocalDateTime appTime, String name, String department, String status, String reason) {
		id=idSeed++;
		this.appTime = appTime;
		this.name = name;
		this.department = department;
		this.status = status;
		this.reason = reason;
	}

	public LocalDateTime getAppTime() {
		return appTime;
	}


	public void setAppTime(LocalDateTime appTime) {
		this.appTime = appTime;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}
	
    public String getFormatTime() {
        return appTime.format(DateTimeFormatter.ofPattern("yyyy-M-d hh:mm a"));
    }


	public String getAssignedTo() {
		return assignedTo;
	}


	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
    
    
	
	
	
	
}
