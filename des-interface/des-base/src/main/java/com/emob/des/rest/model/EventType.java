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

import java.util.HashMap;
import java.util.Map;

public enum EventType {	

	INTERNAL_CREATE_TICKET,
	EXTERNAL_CREATE_TICKET,
	INTERNAL_UPDATE_TICKET,
	EXTERNAL_UPDATE_TICKET,
	INTERNAL_STATUS_UPDATE,
	EXTERNAL_STATUS_UPDATE,
	EXTERNAL_ATTACHMENT,
	INTERNAL_ATTACHMENT,
	EXTERNAL_ATTENDANCE,
	INTERNAL_ATTENDANCE,
	INTERNAL_SCHEDULE,
	EXTERNAL_SCHEDULE,
	EXTERNAL_CREATE_ITEM,
	EXTERNAL_UPDATE_ITEM,	
	INTERNAL_CREATE_ITEM,
	INTERNAL_UPDATE_ITEM,
	INTERNAL_CREATE_CUSTOMER,
	INTERNAL_UPDATE_CUSTOMER;

	private static Map<String, EventType> lookUp = null;
	private int eventIntegrationPosition;

	static {
		lookUp = new HashMap<String, EventType>();
		for (EventType ev : values()) {
			lookUp.put(ev.name(), ev);
		}
	}
	public int getEventIntegrationPosition() {
		return eventIntegrationPosition;
	}

	public static EventType getEventType(String eventType) {
		return lookUp.get(eventType);
	}
}
