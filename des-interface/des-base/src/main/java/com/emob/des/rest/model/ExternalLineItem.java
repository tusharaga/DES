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
 *         &lt;element name="ticketItems">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ticketItem" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="attributes">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="attribute" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;simpleContent>
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/extension>
 *                                           &lt;/simpleContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
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
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"header",	
    "ticketNo",
    "ticketItems",
    "parentEntity"
})
@XmlRootElement(name = "fieldez")
public class ExternalLineItem {

	@XmlElement
	protected Header header;

    @XmlElement(required = true)
    protected String ticketNo;
    
    @XmlElement(required = true)
    protected ExternalLineItem.TicketItems ticketItems;
    
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


	/**
     * Gets the value of the ticketNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketNo() {
        return ticketNo;
    }

    /**
     * Sets the value of the ticketNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketNo(String value) {
        this.ticketNo = value;
    }

    /**
     * Gets the value of the ticketItems property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalLineItem.TicketItems }
     *     
     */
    public ExternalLineItem.TicketItems getTicketItems() {
        return ticketItems;
    }

    /**
     * Sets the value of the ticketItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalLineItem.TicketItems }
     *     
     */
    public void setTicketItems(ExternalLineItem.TicketItems value) {
        this.ticketItems = value;
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
     *         &lt;element name="ticketItem" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="attributes">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="attribute" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
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
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ticketItem"
    })
    public static class TicketItems {

        @XmlElement(required = true)
        protected List<ExternalLineItem.TicketItems.TicketItem> ticketItem;

        
        
        
        
        public TicketItems() {
		
		}

        
		public TicketItems(List<TicketItem> ticketItem) {
			super();
			this.ticketItem = ticketItem;
		}





		/**
         * Gets the value of the ticketItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ticketItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTicketItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExternalLineItem.TicketItems.TicketItem }
         * 
         * 
         */
        public List<ExternalLineItem.TicketItems.TicketItem> getTicketItem() {
            if (ticketItem == null) {
                ticketItem = new ArrayList<ExternalLineItem.TicketItems.TicketItem>();
            }
            return this.ticketItem;
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
         *         &lt;element name="attributes">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="attribute" maxOccurs="unbounded">
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
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "attributes"
        })
        public static class TicketItem {
        	
        	@XmlAttribute
        	protected boolean deleted=false;
        	
            @XmlElement(required = true)
            protected ExternalLineItem.TicketItems.TicketItem.Attributes attributes;
            
            @XmlTransient
            private Exception ex;
            
            @XmlTransient
            private String externalId;
            
            @XmlTransient
            private boolean isUpdate;
            
          
            public boolean isDeleted() {
				return deleted;
			}

			public void setDeleted(boolean deleted) {
				this.deleted = deleted;
			}

			public boolean isUpdate() {
				return isUpdate;
			}

			public void setUpdate(boolean isUpdate) {
				this.isUpdate = isUpdate;
			}

			public String getExternalId() {
				return externalId;
			}

			public void setExternalId(String externalId) {
				this.externalId = externalId;
			}

			public Exception getEx() {
				return ex;
			}

			public void setEx(Exception ex) {
				this.ex = ex;
			}

			/**
             * Gets the value of the attributes property.
             * 
             * @return
             *     possible object is
             *     {@link ExternalLineItem.TicketItems.TicketItem.Attributes }
             *     
             */
            public ExternalLineItem.TicketItems.TicketItem.Attributes getAttributes() {
                return attributes;
            }

            /**
             * Sets the value of the attributes property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExternalLineItem.TicketItems.TicketItem.Attributes }
             *     
             */
            public void setAttributes(ExternalLineItem.TicketItems.TicketItem.Attributes value) {
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
             *         &lt;element name="attribute" maxOccurs="unbounded">
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

                @XmlElement(required = true)
                protected List<ExternalLineItem.TicketItems.TicketItem.Attributes.Attribute> attribute;

                
                
                public Attributes() {
					
				}

                
                

				public Attributes(List<Attribute> attribute) {
					super();
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
                 * {@link ExternalLineItem.TicketItems.TicketItem.Attributes.Attribute }
                 * 
                 * 
                 */
                public List<ExternalLineItem.TicketItems.TicketItem.Attributes.Attribute> getAttribute() {
                    if (attribute == null) {
                        attribute = new ArrayList<ExternalLineItem.TicketItems.TicketItem.Attributes.Attribute>();
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

                    public Attribute(String value2, String key) {
						
                    	this.value=value2;
                    	this.name=key;
					}
                    
                    

					public Attribute() {
						
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

            }

        }

    }

}
