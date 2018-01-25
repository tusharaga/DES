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
package com.emob.des.rest.service;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.emob.des.rest.model.FieldEZResponse;


@Path("/des")
public interface FieldEZEndPointService {

	@POST
	@Path("/workFlow/{workflowId}/event/{type}/ticketNo/{ticketNo}/activity/{activity}")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public FieldEZResponse postDes(
			@PathParam("workflowId") String workflowId,
			@PathParam("type") String type,
			@PathParam("ticketNo") String ticketNo,
			@PathParam("activity") String activity, 
			String payLoad
			);
	
}