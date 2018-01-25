package com.emob.des.rest.model;

import java.io.Serializable;

public class IntegrationLog implements Serializable {
	private int id;
	private int orgId;
	private int workflowId;
	private String ticketId;
	private String url;
	private String event;
	private String activity;
	private boolean retry;
	private boolean success;
	private int retryCount;

	public IntegrationLog() {}
	
	public IntegrationLog(int id, int orgId, int workflowId, String ticketId, String url,
			String event, String activity, boolean retry, boolean success,
			int retryCount) {
		this.id = id;
		this.orgId = orgId;
		this.workflowId = workflowId;
		this.ticketId = ticketId;
		this.url = url;
		this.event = event;
		this.activity = activity;
		this.retry = retry;
		this.success = success;
		this.retryCount = retryCount;
	}
	
	public IntegrationLog(int orgId, int workflowId, String ticketId, String url,
			String event, String activity, boolean retry, boolean success,
			int retryCount) {
		this.orgId = orgId;
		this.workflowId = workflowId;
		this.ticketId = ticketId;
		this.url = url;
		this.event = event;
		this.activity = activity;
		this.retry = retry;
		this.success = success;
		this.retryCount = retryCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public int getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public boolean isRetry() {
		return retry;
	}
	public void setRetry(boolean retry) {
		this.retry = retry;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getRetryCount() {
		return retryCount;
	}
	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}
}
