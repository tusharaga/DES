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

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class ComplaintIntegrationDTO extends BaseDTO {	
	private String customerContactNo;		//1
	private String customerContact;			//2
	private String modelName; 				//3
	private String problemDescription;	    //4
	private String status; 					//5
	private String productName; 			//6
	private String productSerialNo;			//7
	private String productWarrantyType;		//8
	private String externalId;				//9
	private String specialInstructions;		//10
	private String remarks;					//11
	private String attribute1;				//12
	private String attribute2;				//13
	private String attribute3;				//14
	private String attribute4;				//15
	private String attribute5;				//16
	private String attribute6;				//17
	private String attribute7;				//18
	private String attribute8;				//19
	private String attribute9;				//20
	private String attribute10;				//21
	private String attribute11;				//22
	private String attribute12;				//23
	private String attribute13;				//24
	private String attribute14;				//25
	private String attribute15;				//26
	private String attribute16;				//27
	private String attribute17;				//28
	private String attribute18;				//29
	private String attribute19;				//30
	private String attribute20;				//31
	private String attribute21;
	private String attribute22;
	private String attribute23;
	private String attribute24;
	private String attribute25;
	private String attribute26;
	private String attribute27;
	private String attribute28;
	private String attribute29;
	private String attribute30;

	/**
	 * Customer Details
	 */

	private String name;
	private String middileName;	
	private String lastName;	
	private String address1;	
	private String address2;
	private String city;	
	private String state;		
	private String country;		
	private String pincode;		
	private String customerExternalId;	

	private Date appointmentTime;			//32
	private boolean activityAdded;			//33
	private CustomerDTO customer;			//34-41
	private Set<ComplaintLineItemDTO> lineItems;  //x
	private boolean deleted;				//42
	private Date createdDtae;
	private Date clientCreateTime;

	private Collection<ComplaintActivityDTO> activities; // hold
	private ComplaintStatusDTO complaintStatus;	//47-58
	private Collection<ComplaintScheduleDTO> scheduleSet; // 60
	private boolean attachments; //x
	private ComplaintIntegrationDTO parentComplaint;
	private ComplaintScheduleDTO currentSchedule;
	private WorkLocationDTO workLocationdto; 
	private ComplaintChangeType complainChangeType;  //x
	private int  statusFk=0;

	public void setCustomerDetails()
	{
		if(customer!=null)
		{
			this.name=customer.getName();
			this.lastName=customer.getLastName();
			this.middileName=customer.getMiddileName();
			this.address1=customer.getAddress1();			
			this.address2=customer.getAddress2();			
		}

	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMiddileName() {
		return middileName;
	}


	public void setMiddileName(String middileName) {
		this.middileName = middileName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getCustomerExternalId() {
		return customerExternalId;
	}


	public void setCustomerExternalId(String customerExternalId) {
		this.customerExternalId = customerExternalId;
	}


	public ComplaintIntegrationDTO getParentComplaint() {
		return parentComplaint;
	}


	public void setParentComplaint(ComplaintIntegrationDTO parentComplaint) {
		this.parentComplaint = parentComplaint;
	}


	public ComplaintScheduleDTO getCurrentSchedule() {
		return currentSchedule;
	}


	public void setCurrentSchedule(ComplaintScheduleDTO currentSchedule) {
		this.currentSchedule = currentSchedule;
	}

	public int getStatusFk() {
		return statusFk;
	}


	public void setStatusFk(int statusFk) {
		this.statusFk = statusFk;
	}


	public WorkLocationDTO getWorkLocationdto() {
		return workLocationdto;
	}


	public void setWorkLocationdto(WorkLocationDTO workLocationdto) {
		this.workLocationdto = workLocationdto;
	}


	public ComplaintIntegrationDTO(
			int id,
			String customerContactNo,
			String customerContact, 
			String modelName,
			String problemDescription, 
			String status, 
			String productName,
			String productSerialNo,
			String productWarrantyType,
			String externalId, 
			String specialInstructions, 
			String remarks,
			String attribute1, 
			String attribute2, 
			String attribute3,
			String attribute4, 
			String attribute5, 
			String attribute6,
			String attribute7, 
			String attribute8, 
			String attribute9,
			String attribute10, 
			String attribute11, 
			String attribute12,
			String attribute13,
			String attribute14, 
			String attribute15,
			String attribute16, 
			String attribute17, 
			String attribute18,
			String attribute19, 
			String attribute20, 
			String attribute21, 
			String attribute22, 
			String attribute23, 
			String attribute24, 
			String attribute25, 
			String attribute26, 
			String attribute27, 
			String attribute28, 
			String attribute29, 
			String attribute30, 
			Date appointmentTime,
			boolean activityAdded, 
			CustomerDTO customer,
			Set<ComplaintLineItemDTO> lineItems, 
			boolean deleted) {
		super(id);
		this.customerContactNo = customerContactNo;
		this.customerContact = customerContact;
		this.modelName = modelName;
		this.problemDescription = problemDescription;
		this.status = status;
		this.productName = productName;
		this.productSerialNo = productSerialNo;
		this.productWarrantyType = productWarrantyType;
		this.externalId = externalId;
		this.specialInstructions = specialInstructions;
		this.remarks = remarks;
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
		this.attribute21 = attribute21;
		this.attribute22 = attribute22;
		this.attribute23 = attribute23;
		this.attribute24 = attribute24;
		this.attribute25 = attribute25;
		this.attribute26 = attribute26;
		this.attribute27 = attribute27;
		this.attribute28 = attribute28;
		this.attribute29 = attribute29;
		this.attribute30 = attribute30;
		this.appointmentTime = appointmentTime;
		this.activityAdded = activityAdded;
		this.customer = customer;
		this.lineItems = lineItems;
		this.deleted = deleted;	

	}


	@XmlElementWrapper(name="lineItems")
	public Set<ComplaintLineItemDTO> getLineItems() {
		return lineItems;
	}


	public void setLineItems(Set<ComplaintLineItemDTO> lineItems) {
		this.lineItems = lineItems;
	}


	public ComplaintIntegrationDTO() {
		createAt = new Date();
		customer=new  CustomerDTO();
	}


	public String getCustomerContactNo() {
		return customerContactNo;
	}


	public void setCustomerContactNo(String customerContactNo) {
		this.customerContactNo = customerContactNo;
	}


	public String getCustomerContact() {
		return customerContact;
	}


	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public String getProblemDescription() {
		return problemDescription;
	}


	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductSerialNo() {
		return productSerialNo;
	}


	public void setProductSerialNo(String productSerialNo) {
		this.productSerialNo = productSerialNo;
	}


	public String getProductWarrantyType() {
		return productWarrantyType;
	}


	public void setProductWarrantyType(String productWarrantyType) {
		this.productWarrantyType = productWarrantyType;
	}


	public String getExternalId() {
		return externalId;
	}


	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}


	public String getSpecialInstructions() {
		return specialInstructions;
	}


	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
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


	public Date getAppointmentTime() {
		return appointmentTime;
	}


	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}


	public boolean isActivityAdded() {
		return activityAdded;
	}


	public void setActivityAdded(boolean activityAdded) {
		this.activityAdded = activityAdded;
	}

	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@XmlElement(name="Customer")
	public CustomerDTO getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	@XmlElementWrapper(name="activities")
	public Collection<ComplaintActivityDTO> getActivities() {
		return activities;
	}


	public void setActivities(Collection<ComplaintActivityDTO> activities) {
		this.activities = activities;
	}

	public ComplaintStatusDTO getComplaintStatus() {
		return complaintStatus;
	}


	public void setComplaintStatus(ComplaintStatusDTO complaintStatus) {
		this.complaintStatus = complaintStatus;
	}


	@XmlElementWrapper(name="schedules")
	public Collection<ComplaintScheduleDTO> getScheduleSet() {
		return scheduleSet;
	}


	public void setScheduleSet(Collection<ComplaintScheduleDTO> scheduleSet) {
		this.scheduleSet = scheduleSet;
	}

	public boolean isAttachments() {
		return attachments;
	}


	public void setAttachments(boolean attachments) {
		this.attachments = attachments;
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


	public String getAttribute26() {
		return attribute26;
	}


	public void setAttribute26(String attribute26) {
		this.attribute26 = attribute26;
	}


	public String getAttribute27() {
		return attribute27;
	}


	public void setAttribute27(String attribute27) {
		this.attribute27 = attribute27;
	}


	public String getAttribute28() {
		return attribute28;
	}


	public void setAttribute28(String attribute28) {
		this.attribute28 = attribute28;
	}


	public String getAttribute29() {
		return attribute29;
	}


	public void setAttribute29(String attribute29) {
		this.attribute29 = attribute29;
	}


	public String getAttribute30() {
		return attribute30;
	}


	public void setAttribute30(String attribute30) {
		this.attribute30 = attribute30;
	}


	public ComplaintChangeType getComplainChangeType() {
		return complainChangeType;
	}


	public void setComplainChangeType(ComplaintChangeType complainChangeType) {
		this.complainChangeType = complainChangeType;
	}

	public Date getCreatedDtae() {
		return createdDtae;
	}


	public void setCreatedDtae(Date createdDtae) {
		this.createdDtae = createdDtae;
	}

	public Date getClientCreateTime() {
		return clientCreateTime;
	}


	public void setClientCreateTime(Date clientCreateTime) {
		this.clientCreateTime = clientCreateTime;
	}
}
