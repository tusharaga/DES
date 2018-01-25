package com.qbd.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="QBXMLMsgsRs")
public class QBXMLMsgsRs {

	List<CustomerAddRs> customerResposeList = new ArrayList<CustomerAddRs>();

	@XmlElement(name="CustomerAddRs")
	public List<CustomerAddRs> getCustomerResposeList() {
		return customerResposeList;
	}

	public void setCustomerResposeList(List<CustomerAddRs> customerResposeList) {
		this.customerResposeList = customerResposeList;
	}
	
	
}
