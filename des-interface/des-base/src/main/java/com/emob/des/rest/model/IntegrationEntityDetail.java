package com.emob.des.rest.model;

public class IntegrationEntityDetail {
	private int id;
	private int orgId;
	private int workflowId;
	private int fieldezEntityId;
	private String externalEntityId;
	private String entityType;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;

	public IntegrationEntityDetail(int id, int orgId, int workflowId,
			int fieldezEntityId, String externalEntityId, String entityType) {
		super();
		this.id = id;
		this.orgId = orgId;
		this.workflowId = workflowId;
		this.fieldezEntityId = fieldezEntityId;
		this.externalEntityId = externalEntityId;
		this.entityType = entityType;
	}
	
	public IntegrationEntityDetail(int orgId, int workflowId,
			int fieldezEntityId, String externalEntityId, String entityType) {
		super();
		this.id = id;
		this.orgId = orgId;
		this.workflowId = workflowId;
		this.fieldezEntityId = fieldezEntityId;
		this.externalEntityId = externalEntityId;
		this.entityType = entityType;
	}

	public IntegrationEntityDetail(int id, int orgId, int workflowId,
			int fieldezEntityId, String externalEntityId, String entityType,
			String attribute1, String attribute2, String attribute3,
			String attribute4, String attribute5) {
		super();
		this.id = id;
		this.orgId = orgId;
		this.workflowId = workflowId;
		this.fieldezEntityId = fieldezEntityId;
		this.externalEntityId = externalEntityId;
		this.entityType = entityType;
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.attribute4 = attribute4;
		this.attribute5 = attribute5;
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
	public int getFieldezEntityId() {
		return fieldezEntityId;
	}
	public void setFieldezEntityId(int fieldezEntityId) {
		this.fieldezEntityId = fieldezEntityId;
	}
	public String getExternalEntityId() {
		return externalEntityId;
	}
	public void setExternalEntityId(String externalEntityId) {
		this.externalEntityId = externalEntityId;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
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
}
