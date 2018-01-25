package com.qbd.response;

import javax.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="CustomerAddRs")
public class CustomerAddRs {
	
	private String statusCode;
	private String statusSeverity;
	private String statusMessage;
	
	@XmlAttribute(name="statusCode")
	public String getStatusCode() {
		return statusCode;
	}
		
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	@XmlAttribute(name="statusSeverity")
	public String getStatusSeverity() {
		return statusSeverity;
	}
	public void setStatusSeverity(String statusSeverity) {
		this.statusSeverity = statusSeverity;
	}
	
	@XmlAttribute(name="statusMessage")
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	
}
