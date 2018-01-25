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

public class CustomerDTO extends BaseDTO{
	
	private String name;		//34
	private String address1;	//35
	private String address2;	//36
	private String city;		//37
	private String state;		//38
	private String country;		//39
	private String pincode;		//40
	private String customerExternalId;	//41
	
	private String middileName;
	
	private String lastName;
	
	
	public CustomerDTO(){}
	public CustomerDTO( String name, String address1, String address2,
			String city, String state,String country, String pincode,
			String customerExternalId,String middileName, String lastName) {
		
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state=state;
		this.country = country;
		this.pincode = pincode;
		this.customerExternalId = customerExternalId;
		this.middileName=middileName;
		this.lastName=lastName;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCity(String city) {
		this.city = city;
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
	
	

}
