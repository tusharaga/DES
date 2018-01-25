package com.emob.des.rest.model;

public class IntegrationResponse {
	
	private String responseMessage;
	private ResponseType responseType;

	public IntegrationResponse(ResponseType responseType, String responseMessage) {
		this.responseMessage = responseMessage;
		this.responseType = responseType;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}
	
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public ResponseType getResponseType() {
		return responseType;
	}

	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}
}
