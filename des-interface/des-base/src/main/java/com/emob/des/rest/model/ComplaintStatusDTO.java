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


public class ComplaintStatusDTO extends BaseDTO{
	
	private String status; //47
	private String description; //48
	private int statusOrder; //49
	private String nextActions; //50
	private String action; //51
	private boolean endStatus; //52
	private String remarksLabel; //53
	private int captureCustomerSign; //54
	private String schedulerColor; //55
	private int roleType; //56
	private boolean mandatoryRemarks; //57
	private String remarksTemplate; //58
	private String externalStatus;	
	
	public ComplaintStatusDTO() {		
	}

	public ComplaintStatusDTO(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatusOrder() {
		return statusOrder;
	}
	public void setStatusOrder(int statusOrder) {
		this.statusOrder = statusOrder;
	}
	public String getNextActions() {
		return nextActions;
	}
	public void setNextActions(String nextActions) {
		this.nextActions = nextActions;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public boolean isEndStatus() {
		return endStatus;
	}
	public void setEndStatus(boolean endStatus) {
		this.endStatus = endStatus;
	}
	public String getRemarksLabel() {
		return remarksLabel;
	}
	public void setRemarksLabel(String remarksLabel) {
		this.remarksLabel = remarksLabel;
	}
	public int getCaptureCustomerSign() {
		return captureCustomerSign;
	}

	public void setCaptureCustomerSign(int captureCustomerSign) {
		this.captureCustomerSign = captureCustomerSign;
	}

	public String getSchedulerColor() {
		return schedulerColor;
	}
	public void setSchedulerColor(String schedulerColor) {
		this.schedulerColor = schedulerColor;
	}
	public int getRoleType() {
		return roleType;
	}
	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}
	public boolean isMandatoryRemarks() {
		return mandatoryRemarks;
	}
	public void setMandatoryRemarks(boolean mandatoryRemarks) {
		this.mandatoryRemarks = mandatoryRemarks;
	}
	public String getRemarksTemplate() {
		return remarksTemplate;
	}
	public void setRemarksTemplate(String remarksTemplate) {
		this.remarksTemplate = remarksTemplate;
	}
	public String getExternalStatus() {
		return externalStatus;
	}
	public void setExternalStatus(String externalStatus) {
		this.externalStatus = externalStatus;
	}
	
	

}
