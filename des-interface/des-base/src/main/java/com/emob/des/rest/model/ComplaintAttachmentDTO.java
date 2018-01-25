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


public class ComplaintAttachmentDTO extends BaseDTO{	
	private String type;
	private String name;
	private long size;
	private String description;
	private byte[] data;
	
	public ComplaintAttachmentDTO() {
		// TODO Auto-generated constructor stub
	}
	public ComplaintAttachmentDTO(int id, String type, String name, long size,
			String description, byte[] data) {
		super(id);
		this.type = type;
		this.name = name;
		this.size = size;
		this.description = description;
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
}
