package com.emob.des.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="qbDesktopDetails")
public class QBDesktopDetails {
	private int id;
	private int orgId;
	private String name;
	private String qbxmlReguest;
	private String qbxmlResponse;
	private Boolean qb_active;
	private Boolean emob_active;
	
	public QBDesktopDetails() {
		// TODO Auto-generated constructor stub
	}

	public QBDesktopDetails(int id, int orgId, String name,
			String qbxmlReguest, String qbxmlResponse, Boolean qb_active, Boolean emob_active) {
		this.id = id;
		this.orgId = orgId;
		this.name = name;
		this.qbxmlReguest = qbxmlReguest;
		this.qbxmlResponse = qbxmlResponse;
		this.qb_active = qb_active;
		this.emob_active = emob_active;
	}

	public QBDesktopDetails(int orgId, String name, String qbxmlReguest,
			String qbxmlResponse,Boolean qb_active, Boolean emob_active) {
		this.orgId = orgId;
		this.name = name;
		this.qbxmlReguest = qbxmlReguest;
		this.qbxmlResponse = qbxmlResponse;
		this.qb_active = qb_active;
		this.emob_active = emob_active;
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

	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="qbxmlReguest")
	public String getQbxmlReguest() {
		return qbxmlReguest;
	}

	public void setQbxmlReguest(String qbxmlReguest) {
		this.qbxmlReguest = qbxmlReguest;
	}

	@XmlElement(name="qbxmlResponse")
	public String getQbxmlResponse() {
		return qbxmlResponse;
	}

	public void setQbxmlResponse(String qbxmlResponse) {
		this.qbxmlResponse = qbxmlResponse;
	}

	@XmlElement(name="qbActive")
	public Boolean getQb_active() {
		return qb_active;
	}

	public void setQb_active(Boolean qb_active) {
		this.qb_active = qb_active;
	}

	@XmlElement(name="emobActive")
	public Boolean getEmob_active() {
		return emob_active;
	}

	public void setEmob_active(Boolean emob_active) {
		this.emob_active = emob_active;
	}


}