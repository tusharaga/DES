package com.qbd.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="QBXML")
public class QBXML {

	private QBXMLMsgsRs qbxmlMsgsRs;

	@XmlElement(name="QBXMLMsgsRs")
	public QBXMLMsgsRs getQbxmlMsgsRs() {
		return qbxmlMsgsRs;
	}

	public void setQbxmlMsgsRs(QBXMLMsgsRs qbxmlMsgsRs) {
		this.qbxmlMsgsRs = qbxmlMsgsRs;
	}
	
	
}
