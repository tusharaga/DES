package com.emob.des.rest.model;

public class EventContext {
	private String type, ticketNo, activity;
	private ExternalComplaint externalComplaint;
	private ExternalLineItem externalLineItem;
	private ExternalStatus externalStatus;
	private Header header;
	int orgId, workflowId;
	private IntegrationLogDetail integrationLogDetail;
	private IntegrationResponse integrationResponse;
	
	public EventContext() {
		// Default Constructor
	}
	
	public EventContext(int orgId, int workflowId, String type,
			String ticketNo, String activity, IntegrationLogDetail integrationLogDetail) {
		this.orgId = orgId;
		this.workflowId = workflowId;
		this.type = type;
		this.ticketNo = ticketNo;
		this.activity = activity;
		this.integrationLogDetail = integrationLogDetail;
	}
	
	public EventContext(int orgId, int workflowId, String type,
			String ticketNo, String activity,ExternalComplaint externalComplaint,IntegrationLogDetail integrationLogDetail) {
		this(orgId, workflowId, type, ticketNo, activity, integrationLogDetail);
		this.externalComplaint = externalComplaint;
	}

	public EventContext(int orgId, int workflowId, String type,
			String ticketNo, String activity,ExternalLineItem externalLineItem,IntegrationLogDetail integrationLogDetail) {
		this(orgId, workflowId, type, ticketNo, activity,integrationLogDetail);
		this.externalLineItem = externalLineItem;
	}

	public EventContext(int orgId, int workflowId, String type,
			String ticketNo, String activity,ExternalStatus externalStatus,IntegrationLogDetail integrationLogDetail) {
		this(orgId, workflowId, type, ticketNo, activity, integrationLogDetail);
		this.externalStatus = externalStatus;
	}
	
	public EventContext(Header header) {
		super();
		this.header = header;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public ExternalComplaint getExternalComplaint() {
		return externalComplaint;
	}

	public void setExternalComplaint(ExternalComplaint externalComplaint) {
		this.externalComplaint = externalComplaint;
	}

	public ExternalLineItem getExternalLineItem() {
		return externalLineItem;
	}

	public void setExternalLineItem(ExternalLineItem externalLineItem) {
		this.externalLineItem = externalLineItem;
	}

	public ExternalStatus getExternalStatus() {
		return externalStatus;
	}

	public void setExternalStatus(ExternalStatus externalStatus) {
		this.externalStatus = externalStatus;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public IntegrationLogDetail getIntegrationLogDetail() {
		return integrationLogDetail;
	}

	public void setIntegrationLogDetail(IntegrationLogDetail integrationLogDetail) {
		this.integrationLogDetail = integrationLogDetail;
	}

	public IntegrationResponse getIntegrationResponse() {
		return integrationResponse;
	}

	public void setIntegrationResponse(IntegrationResponse integrationResponse) {
		this.integrationResponse = integrationResponse;
	}
}
