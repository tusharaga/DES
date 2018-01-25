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
import java.util.Map;

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
 *         &lt;element name="workflow" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "workflow",
    "attributes",
    "parentEntity"
})
@XmlRootElement(name = "fieldez")
public class ExternalComplaint {

	@XmlElement
	protected Header header;
	
    @XmlElement(required = true)
    protected String workflow;
    
    @XmlElement(required = true)
    protected ExternalComplaint.Attributes attributes;
    
   
    @XmlTransient
    private boolean isUpdate;
    
   
    
    @XmlTransient
    private String activityRemarks;
    
    @XmlTransient
    private String complaintStatus;
    
    @XmlTransient
    private int complaintStatusId;
    
    @XmlAttribute
    protected String api;
    
    @XmlAttribute
    protected double version;
    
    
   
    @XmlElement(name="parentEntity")
    private ComplaintIntegrationDTO parentEntity;
    
    
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

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public int getComplaintStatusId() {
		return complaintStatusId;
	}

	public void setComplaintStatusId(int complaintStatusId) {
		this.complaintStatusId = complaintStatusId;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public String getActivityRemarks() {
		return activityRemarks;
	}

	public void setActivityRemarks(String activityRemarks) {
		this.activityRemarks = activityRemarks;
	}

	/**
     * Gets the value of the workflow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflow() {
        return workflow;
    }

    /**
     * Sets the value of the workflow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflow(String value) {
        this.workflow = value;
    }

    /**
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalComplaint.Attributes }
     *     
     */
    public ExternalComplaint.Attributes getAttributes() {
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
    public void setAttributes(ExternalComplaint.Attributes value) {
        this.attributes = value;
    }   

	public boolean isUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	@Override
	public String toString() {
		return "ExternalComplaint [workflow=" + workflow + ", attributes="
				+ attributes + ", isUpdate="
				+ isUpdate + "]";
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

        protected List<ExternalComplaint.Attributes.Attribute> attribute;
        
        
        

        public void setAttribute(List<ExternalComplaint.Attributes.Attribute> attribute) {
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
        public List<ExternalComplaint.Attributes.Attribute> getAttribute() {
            if (attribute == null) {
                attribute = new ArrayList<ExternalComplaint.Attributes.Attribute>();
            }
            return this.attribute;
        }

        
        @Override
		public String toString() {
			return "Attributes [attribute=" + attribute + "]";
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


			@Override
			public String toString() {
				return "Attribute [value=" + value + ", name=" + name + "]";
			}
            
            

        }

    }

}
