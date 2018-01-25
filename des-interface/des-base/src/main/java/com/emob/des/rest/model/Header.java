package com.emob.des.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orgId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="orgName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workflowId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workflowName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tickeNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="eventType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "orgId",
    "orgName",
    "workflowId",
    "workflowName",
    "tickeNo",
    "eventType",
    "integratedAdpater"
})
public class Header {

    protected String orgId;
    protected String orgName;
    protected String workflowId;
    protected String workflowName;
    protected String tickeNo;
    protected String eventType;
    protected String integratedAdpater;
 
    
    
    public Header() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	/**
     * Gets the value of the orgId property.
     * 
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * Sets the value of the orgId property.
     * 
     */
    public void setOrgId(String value) {
        this.orgId = value;
    }

    /**
     * Gets the value of the orgName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * Sets the value of the orgName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgName(String value) {
        this.orgName = value;
    }

    /**
     * Gets the value of the workflowId property.
     * 
     */
    public String getWorkflowId() {
        return workflowId;
    }

    /**
     * Sets the value of the workflowId property.
     * 
     */
    public void setWorkflowId(String value) {
        this.workflowId = value;
    }

    /**
     * Gets the value of the workflowName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowName() {
        return workflowName;
    }

    /**
     * Sets the value of the workflowName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowName(String value) {
        this.workflowName = value;
    }

    /**
     * Gets the value of the tickeNo property.
     * 
     */
    public String getTickeNo() {
        return tickeNo;
    }

    /**
     * Sets the value of the tickeNo property.
     * 
     */
    public void setTickeNo(String value) {
        this.tickeNo = value;
    }

    /**
     * Gets the value of the eventType property.
     * 
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Sets the value of the eventType property.
     * 
     */
    public void setEventType(String value) {
        this.eventType = value;
    }


    /**
     * Gets the value of the integratedAdpater property.
     * 
     */
	public String getIntegratedAdpater() {
		return integratedAdpater;
	}


	/**
     * Sets the value of the integratedAdpater property.
     * 
     */
	public void setIntegratedAdpater(String integratedAdpater) {
		this.integratedAdpater = integratedAdpater;
	}
}