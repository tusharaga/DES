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
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

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
 *         &lt;element name="ticketNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="action" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="actionOn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="actor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attributes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="attribute" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;attribute name="api" type="{http://www.w3.org/2001/XMLSchema}string" />
 *         &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @author Kamakshya
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"header",		
    "ticketNo",
    "status",
    "fieldezStatus",
    "action",
    "actionOn",
    "createTime",
    "latitude",
    "longitude",
    "deviceNo",
    "actor",   
    "attributes",
    "parentEntity"
})
@XmlRootElement(name = "fieldez")
public class ExternalStatus {
	
	@XmlElement
	protected Header header;	
    @XmlElement(required = true)
    protected String ticketNo;
    @XmlElement
    protected String status;
    @XmlElement
    protected String fieldezStatus;
    @XmlElement
    protected String action;    
    @XmlElement
    protected String actionOn;    
    @XmlElement
    protected String createTime;    
    @XmlElement
    protected String latitude;    
    @XmlElement
    protected String longitude;
    @XmlElement
    protected String deviceNo;
    @XmlElement
    protected String actor;   
    
    @XmlAttribute
    protected String api;
    
    @XmlAttribute
    protected double version;
    
    @XmlElement(required = true)
    protected ExternalStatus.Attributes attributes;
 
    @XmlElement(name="parentEntity")
    private ComplaintIntegrationDTO parentEntity;
   
	public ExternalStatus() {
	}
	
	
	public ExternalStatus(
			String ticketNo, 
			String status, 
			String fieldezStatus,
			String action, 
			String actionOn, 
			String createTime, 
			String latitude,
			String longitude, 
			String deviceNo, 
			String actor) {
		this.ticketNo = ticketNo;
		this.status = status;
		this.fieldezStatus = fieldezStatus;
		this.action = action;
		this.actionOn = actionOn;
		this.createTime = createTime;
		this.latitude = latitude;
		this.longitude = longitude;
		this.deviceNo = deviceNo;
		this.actor = actor;
	}

	public ComplaintIntegrationDTO getParentEntity() {
		return parentEntity;
	}


	public void setParentEntity(ComplaintIntegrationDTO parentEntity) {
		this.parentEntity = parentEntity;
	}


	/**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

	public String getFieldezStatus() {
		return fieldezStatus;
	}
	public void setFieldezStatus(String fieldezStatus) {
		this.fieldezStatus = fieldezStatus;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDeviceNo() {
		return deviceNo;
	}
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getActionOn() {
		return actionOn;
	}
	public void setActionOn(String actionOn) {
		this.actionOn = actionOn;
	}
		
	public String getApi() {
		return api;
	}


	public void setApi(String api) {
		this.api = api;
	}


	public double getVersion() {
		return version;
	}


	public void setVersion(double d) {
		this.version = d;
	}

	/**
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalComplaint.Attributes }
     *     
     */
    public ExternalStatus.Attributes getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalComplaint.Attributes }
     *     
     */
    public void setAttributes(ExternalStatus.Attributes value) {
        this.attributes = value;
    }


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
     *         &lt;element name="attribute" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "attribute"
    })
    public static class Attributes {

        protected List<ExternalStatus.Attributes.Attribute> attribute;
        
        
        

        public void setAttribute(List<ExternalStatus.Attributes.Attribute> attribute) {
			this.attribute = attribute;
		}


		/**
         * Gets the value of the attribute property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the attribute property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAttribute().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExternalComplaint.Attributes.Attribute }
         * 
         * 
         */
        public List<ExternalStatus.Attributes.Attribute> getAttribute() {
            if (attribute == null) {
                attribute = new ArrayList<ExternalStatus.Attributes.Attribute>();
            }
            return this.attribute;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Attribute {

            @XmlValue
            protected String value;
            @XmlAttribute
            protected String name;
            
            public Attribute(){}
            

            public Attribute(String value, String name) {
				super();
				this.value = value;
				this.name = name;
			}

			/**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

        }
        
        

		@Override
		public String toString() {
			return "Attributes [attribute=" + attribute + "]";
		}
		
		

    }

}
