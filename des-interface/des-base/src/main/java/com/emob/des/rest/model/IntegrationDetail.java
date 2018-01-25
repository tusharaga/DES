package com.emob.des.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="integrationDetail")
public class IntegrationDetail {
	private int id;
	private int orgId;
	private int workflowId;
	private String qbparent_xml;	
	private String service_type;
	private String qname;
	private String password;
	private String last_sync_time;
	private String apiKey;
	private String apiToken;

	public IntegrationDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public IntegrationDetail(int id, int orgId, int workflowId,
			String qbparent_xml,String service_type, String name,String password,String last_sync_time,String apiKey, String apiToken) {
		this.id = id;
		this.orgId = orgId;
		this.workflowId = workflowId;
		this.qbparent_xml = qbparent_xml;		
		this.service_type = service_type;
		this.qname=name;
		this.password = password;
		this.last_sync_time= last_sync_time;
		this.apiKey= apiKey;
		this.apiToken = apiToken;
	}

	public IntegrationDetail(int orgId, int workflowId,
			String qbparent_xml,String service_type, String name,String password,String last_sync_time,String apiKey, String apiToken) {
		this.orgId = orgId;
		this.workflowId = workflowId;
		this.qbparent_xml = qbparent_xml;
		this.service_type = service_type;
		this.qname = name;
		this.password = password;
		this.last_sync_time= last_sync_time;
		this.apiKey= apiKey;
		this.apiToken = apiToken;
	}

	@XmlElement(name="id")
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name="orgId")
	public int getOrgId() {
		return orgId;
	}


	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	@XmlElement(name="workflowId")
	public int getWorkflowId() {
		return workflowId;
	}


	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}

	@XmlElement(name="qbparentXml")
	public String getQbparent_xml() {
		return qbparent_xml;
	}


	public void setQbparent_xml(String qbparent_xml) {
		this.qbparent_xml = qbparent_xml;
	}


	@XmlElement(name="serviceType")
	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	@XmlElement(name="qname")
	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}
	
	@XmlElement(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLast_sync_time() {
		return last_sync_time;
	}

	public void setLast_sync_time(String last_sync_time) {
		this.last_sync_time = last_sync_time;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiToken() {
		return apiToken;
	}

	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}
	
	
}
