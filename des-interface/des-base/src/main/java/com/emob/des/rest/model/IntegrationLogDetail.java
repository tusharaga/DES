package com.emob.des.rest.model;

import java.io.Serializable;

public class IntegrationLogDetail implements Serializable {

	private IntegrationLog integrationLog;
	private String requestBody;
	private String responseBody;
	
	public IntegrationLogDetail() {}
	
	public IntegrationLogDetail(IntegrationLog integrationLog,
			String requestBody, String responseBody) {
		this.integrationLog = integrationLog;
		this.requestBody = requestBody;
		this.responseBody = responseBody;
	}
	public IntegrationLogDetail(int id,int integrationLogId,
			String requestBody, String responseBody) {
		this.requestBody = requestBody;
		this.responseBody = responseBody;
	}
	
	public IntegrationLog getIntegrationLog() {
		return integrationLog;
	}
	public void setIntegrationLog(IntegrationLog integrationLog) {
		this.integrationLog = integrationLog;
	}
	public String getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	public String getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
}
