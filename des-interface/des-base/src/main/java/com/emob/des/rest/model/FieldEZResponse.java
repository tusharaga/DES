package com.emob.des.rest.model;

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

import java.util.Collection;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="fieldezResponce")
public class FieldEZResponse {
	@XmlAttribute
	private String api = "createCall";
	private int id;
	private String responseCode;
	private String responseMesssage;
	private String externalId;
	private Collection<String> valMessages;
	
	
	
	
	
	public FieldEZResponse(String api, String responseCode,
			String responseMesssage, String externalId) {
		super();
		this.api = api;
		this.responseCode = responseCode;
		this.responseMesssage = responseMesssage;
		this.externalId = externalId;
	}

	public FieldEZResponse() {
		
	}
	
	public FieldEZResponse(String api, String responseCode, 
			String responseMessage,
			Collection<String> valMessages) {
		this(api, -1, responseCode, responseMessage, valMessages);
	}
	
	public FieldEZResponse(String api, String responseCode,int id) {
		this(api, id, responseCode, responseCode, null);
	}
	
	public FieldEZResponse(String api, String responseCode, 
			String responseMessage) {
		this(api, -1, responseCode, responseMessage, null);
	}
	
	
	public FieldEZResponse(String api, int id, String responseCode, 
			String responseMessage,
			Collection<String> valMessages) {
		this.api = api;
		this.id = id;
		this.responseCode = responseCode;
		this.responseMesssage = responseMessage;
		this.valMessages = valMessages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMesssage() {
		return responseMesssage;
	}

	public void setResponseMesssage(String responseMesssage) {
		this.responseMesssage = responseMesssage;
	}
	
	
	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
	@XmlElementWrapper(name="validationErrors")
	@XmlElement(name="validationError")
	public Collection<String> getValMessages() {
		return valMessages;
	}

	public void setValMessages(Collection<String> valMessages) {
		this.valMessages = valMessages;
	}

	@Override
	public String toString() {
		return "FieldEZResponse [api=" + api + ", id=" + id + ", responseCode="
				+ responseCode + ", responseMesssage=" + responseMesssage
				+ ", externalId=" + externalId + ", valMessages=" + valMessages
				+ "]";
	}	
	
	
}
