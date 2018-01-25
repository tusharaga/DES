package com.emob.des.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="IntegrationDetailWrapper")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class IntegrationDetailWrapper {
	List<IntegrationDetail> list;

	@XmlElement(name="integrationDetail")
	public List<IntegrationDetail> getList() {
		return list;
	}

	public void setList(List<IntegrationDetail> list) {
		this.list = list;
	}
}
