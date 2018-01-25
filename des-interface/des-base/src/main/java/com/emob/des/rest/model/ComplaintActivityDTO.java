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

public class ComplaintActivityDTO extends BaseDTO implements Comparable<ComplaintActivityDTO>{
	private String action;
	private Date activityTime;
	private String location;
	private UserDTO actor;
	private String status;
	private String externalstatus;
	private String purpose;
	private String remarks;
	private double longitude = 0;
	private double latitude = 0;
	private String deviceNo;
	private boolean customerSign;	
	private String engAssigneeId;
	
	private int statusId;
	
	private String attribute1;	
	
	private String attribute2;
	
	private String attribute3;
	
	private String attribute4;
	
	private String attribute5;
	
	private String attribute6;
	
	private String attribute7;
	
	private String attribute8;
	
	private String attribute9;
	
	private String attribute10;
	
	private String attribute11;
	
	private String attribute12;
	
	private String attribute13;
	
	private String attribute14;
	
	private String attribute15;
	
	private ComplaintAttachmentDTO attachment;

	public ComplaintActivityDTO(int id, String action, Date activityTime, Date createAt,
			String location, UserDTO actor, String status, String externalstatus , String purpose,
			String remarks, double longitude, double latitude, String deviceNo,
			boolean customerSign,String attribute1,	 String attribute2,
			 String attribute3,
			 String attribute4,
			 String attribute5,
			 String attribute6,
			 String attribute7,
			 String attribute8,
			 String attribute9,
			 String attribute10,
			 String attribute11,
			 String attribute12,
			 String attribute13,
			 String attribute14,
			 String attribute15) {
		super(id);
		this.action = action;
		this.activityTime = activityTime;
		this.createAt = createAt;
		this.location = location;
		this.actor = actor;
		this.status = status;
		this.externalstatus=externalstatus;
		this.purpose = purpose;
		this.remarks = remarks;
		this.longitude = longitude;
		this.latitude = latitude;
		this.deviceNo = deviceNo;
		this.customerSign = customerSign;		
		this.attribute1=attribute1;
		this.attribute2=attribute2;
		this.attribute3=attribute3;
		this.attribute4=attribute4;
		this.attribute5=attribute5;
		this.attribute6=attribute6;
		this.attribute7=attribute7;
		this.attribute8=attribute8;
		this.attribute9=attribute9;
		this.attribute10=attribute10;
		this.attribute11=attribute11;
		this.attribute12=attribute12;
		this.attribute13=attribute13;
		this.attribute14=attribute14;		
		this.attribute15=attribute15;
		
	}
	
	
	

	public int getStatusId() {
		return statusId;
	}




	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}




	public ComplaintActivityDTO() {	
		// TODO Auto-generated constructor stub
	}



	public ComplaintActivityDTO(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}



	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public UserDTO getActor() {
		return actor;
	}

	public void setActor(UserDTO actor) {
		this.actor = actor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public boolean isCustomerSign() {
		return customerSign;
	}

	public void setCustomerSign(boolean customerSign) {
		this.customerSign = customerSign;
	}

	public ComplaintAttachmentDTO getAttachment() {
		return attachment;
	}

	public void setAttachment(ComplaintAttachmentDTO attachment) {
		this.attachment = attachment;
	}

	public String getEngAssigneeId() {
		return engAssigneeId;
	}

	public void setEngAssigneeId(String engAssigneeId) {
		this.engAssigneeId = engAssigneeId;
	}

	@Override
	public int compareTo(ComplaintActivityDTO o) {
		return ((Integer)this.id).compareTo(o.id); 
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute4() {
		return attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getAttribute5() {
		return attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public String getAttribute6() {
		return attribute6;
	}

	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}

	public String getAttribute7() {
		return attribute7;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	public String getAttribute8() {
		return attribute8;
	}

	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}

	public String getAttribute9() {
		return attribute9;
	}

	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}

	public String getAttribute10() {
		return attribute10;
	}

	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}

	public String getAttribute11() {
		return attribute11;
	}

	public void setAttribute11(String attribute11) {
		this.attribute11 = attribute11;
	}

	public String getAttribute12() {
		return attribute12;
	}

	public void setAttribute12(String attribute12) {
		this.attribute12 = attribute12;
	}

	public String getAttribute13() {
		return attribute13;
	}

	public void setAttribute13(String attribute13) {
		this.attribute13 = attribute13;
	}

	public String getAttribute14() {
		return attribute14;
	}

	public void setAttribute14(String attribute14) {
		this.attribute14 = attribute14;
	}

	public String getAttribute15() {
		return attribute15;
	}

	public void setAttribute15(String attribute15) {
		this.attribute15 = attribute15;
	}

	public String getExternalstatus() {
		return externalstatus;
	}

	public void setExternalstatus(String externalstatus) {
		this.externalstatus = externalstatus;
	}
	
	

}
