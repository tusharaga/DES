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


public class ComplaintLineItemDTO extends BaseDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String externalId; //1
	
	private String type; //2
	
	private String quantity; //3
	
	private String unit; //4
	
	private String attribute1; //5
	
	private String attribute2; //6
	
	private String attribute3; //7
	
	private String attribute4; //8
	
	private String attribute5; //9
	
	private String attribute6;
	
	private String attribute7;
	
	private String attribute8;
	
	private String attribute9;
	
	private String attribute10;
	
	private String attribute11;
	
	private String attribute12;
	
	private String attribute13;
	
	private String attribute14;
	
	private String attribute15;
	
	private String attribute16;
	
	private String attribute17;
	
	private String attribute18;
	
	private String attribute19;
	
	private String attribute20;
	
	private String attribute21;
	
	private String attribute22;
	
	private String attribute23;
	
	private String attribute24;
	
	private String attribute25;
	
	private boolean deleted;	
	private String complaintExternalId;
	
	private int complaintWorkflowId;
	
	public ComplaintLineItemDTO(){}
	public ComplaintLineItemDTO(String externalId, String type,
			String quantity, String unit, String attribute1, String attribute2,
			String attribute3, String attribute4, String attribute5, String attribute6, String attribute7, String attribute8) {		
		this.externalId = externalId;
		this.type = type;
		this.quantity = quantity;
		this.unit = unit;
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.attribute4 = attribute4;
		this.attribute5 = attribute5;
		this.attribute6=attribute6;
		this.attribute7 = attribute7;
		this.attribute8=attribute8;
	}
	
	
	
	
	
public ComplaintLineItemDTO(String externalId, String type,
			String quantity, String unit, String attribute1, String attribute2,
			String attribute3, String attribute4, String attribute5,
			String attribute6, String attribute7, String attribute8,
			String attribute9, String attribute10, String attribute11,
			String attribute12, String attribute13, String attribute14,
			String attribute15, String attribute16, String attribute17,
			String attribute18, String attribute19, String attribute20,
			String attribute21, String attribute22, String attribute23,
			String attribute24, String attribute25,
			boolean deleted, String complaintExternalId) {
		super();
		this.externalId = externalId;
		this.type = type;
		this.quantity = quantity;
		this.unit = unit;
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.attribute4 = attribute4;
		this.attribute5 = attribute5;
		this.attribute6 = attribute6;
		this.attribute7 = attribute7;
		this.attribute8 = attribute8;
		this.attribute9 = attribute9;
		this.attribute10 = attribute10;
		this.attribute11 = attribute11;
		this.attribute12 = attribute12;
		this.attribute13 = attribute13;
		this.attribute14 = attribute14;
		this.attribute15 = attribute15;
		this.attribute16 = attribute16;
		this.attribute17 = attribute17;
		this.attribute18 = attribute18;
		this.attribute19 = attribute19;
		this.attribute20 = attribute20;
		this.attribute20 = attribute21;
		this.attribute20 = attribute22;
		this.attribute20 = attribute23;
		this.attribute20 = attribute24;
		this.attribute20 = attribute25;
		this.deleted = deleted;
		this.complaintExternalId = complaintExternalId;
	}
/*	public ComplaintLineItemDTO(com.emob.domain.dto.ComplaintLineItemDTO dto)
	{
		this.id = dto.getId();
		this.complaintExternalId = dto.getComplaintExternalId();
		this.type = dto.getComplaintType();
		this.quantity = dto.getComplaintQuantity();
		this.unit=dto.getComplaintUnit();
		this.attribute1=dto.getComplaintAttribute1();
		this.attribute2=dto.getComplaintAttribute2();
		this.attribute3=dto.getComplaintAttribute3();
		this.attribute4=dto.getComplaintAttribute4();
		this.attribute5=dto.getComplaintAttribute5();
	}*/
	

	
	public String getComplaintExternalId() {
		return complaintExternalId;
	}
	public int getComplaintWorkflowId() {
		return complaintWorkflowId;
	}
	public void setComplaintWorkflowId(int complaintWorkflowId) {
		this.complaintWorkflowId = complaintWorkflowId;
	}
	public void setComplaintExternalId(String complaintExternalId) {
		this.complaintExternalId = complaintExternalId;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
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
	public String getAttribute6() {
		return attribute6;
	}
	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}
	public String getAttribute7() {
		return attribute7;
	}
	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}
	public String getAttribute8() {
		return attribute8;
	}
	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}
	
	
	public String getAttribute9() {
		return attribute9;
	}
	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}
	public String getAttribute10() {
		return attribute10;
	}
	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}
	public String getAttribute11() {
		return attribute11;
	}
	public void setAttribute11(String attribute11) {
		this.attribute11 = attribute11;
	}
	public String getAttribute12() {
		return attribute12;
	}
	public void setAttribute12(String attribute12) {
		this.attribute12 = attribute12;
	}
	public String getAttribute13() {
		return attribute13;
	}
	public void setAttribute13(String attribute13) {
		this.attribute13 = attribute13;
	}
	public String getAttribute14() {
		return attribute14;
	}
	public void setAttribute14(String attribute14) {
		this.attribute14 = attribute14;
	}
	public String getAttribute15() {
		return attribute15;
	}
	public void setAttribute15(String attribute15) {
		this.attribute15 = attribute15;
	}
		
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getAttribute16() {
		return attribute16;
	}
	public void setAttribute16(String attribute16) {
		this.attribute16 = attribute16;
	}
	public String getAttribute17() {
		return attribute17;
	}
	public void setAttribute17(String attribute17) {
		this.attribute17 = attribute17;
	}
	public String getAttribute18() {
		return attribute18;
	}
	public void setAttribute18(String attribute18) {
		this.attribute18 = attribute18;
	}
	public String getAttribute19() {
		return attribute19;
	}
	public void setAttribute19(String attribute19) {
		this.attribute19 = attribute19;
	}
	public String getAttribute20() {
		return attribute20;
	}
	public void setAttribute20(String attribute20) {
		this.attribute20 = attribute20;
	}
	public String getAttribute21() {
		return attribute21;
	}
	public void setAttribute21(String attribute21) {
		this.attribute21 = attribute21;
	}
	public String getAttribute22() {
		return attribute22;
	}
	public void setAttribute22(String attribute22) {
		this.attribute22 = attribute22;
	}
	public String getAttribute23() {
		return attribute23;
	}
	public void setAttribute23(String attribute23) {
		this.attribute23 = attribute23;
	}
	public String getAttribute24() {
		return attribute24;
	}
	public void setAttribute24(String attribute24) {
		this.attribute24 = attribute24;
	}
	public String getAttribute25() {
		return attribute25;
	}
	public void setAttribute25(String attribute25) {
		this.attribute25 = attribute25;
	}
}
