/*******************************************************************************
 * Copyright (c) 2011 FieldEZ Technologies
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of
 * FieldEZ Technologies ("Confidential Information").  Thou shalt not
 * disclose such Confidential Information and shalt use it only in
 * accordance with the terms of the license agreement you entered into
 * with FieldEZ.
 ******************************************************************************/
package com.emob.des.rest.model;

import java.util.Date;

public class ComplaintScheduleDTO extends BaseDTO{
	
	private UserDTO assignee; //60
	private Date startTime;
	private Date endTime;
	private String startTimeStr;	
	public ComplaintScheduleDTO(int id, UserDTO assignee, Date startTime,
			Date endTime, String startTimeStr) {
		super(id);
		this.assignee = assignee;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startTimeStr = startTimeStr;
	}
	
	public ComplaintScheduleDTO() {
	
	}

	public ComplaintScheduleDTO(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}


	public UserDTO getAssignee() {
		return assignee;
	}
	public void setAssignee(UserDTO assignee) {
		this.assignee = assignee;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getStartTimeStr() {
		return startTimeStr;
	}
	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}
	
	
	

}
