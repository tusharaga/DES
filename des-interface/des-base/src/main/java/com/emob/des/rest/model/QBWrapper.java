package com.emob.des.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="QBWrapper")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class QBWrapper {

	List<QBDesktopDetails> list = new ArrayList<QBDesktopDetails>();

	@XmlElement(name="qbDesktopDetails")
	public List<QBDesktopDetails> getList() {
		return list;
	}

	public void setList(List<QBDesktopDetails> list) {
		this.list = list;
	}
	
	
}
