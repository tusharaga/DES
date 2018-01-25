package com.emob.des.rest.service;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emob.des.rest.model.EventContext;
import com.emob.des.rest.model.EventType;
import com.emob.des.rest.model.ExternalComplaint;
import com.emob.des.rest.model.ExternalLineItem;
import com.emob.des.rest.model.ExternalStatus;
import com.emob.des.rest.model.FieldEZResponse;
import com.emob.des.rest.model.IntegrationLog;
import com.emob.des.rest.model.IntegrationLogDetail;


public abstract class AbstractDESBundle implements FieldEZEndPointService{
	
	private static Logger logger = LoggerFactory.getLogger(AbstractDESBundle.class);
	private DesRepository desRepository;
	private String orgId;
	String uri = "http://localhost:8181/cxf/{orgId}/des";

	@Override
	public FieldEZResponse postDes( String workflowId,String type,
			String ticketNo, String activity,String payLoad) {
		System.out.println("---invoking postDes, Type : " + type);
		System.out.println("---invoking postDes, PayLoad : " + payLoad);
		// create integration detail here and save it to the DB
		postDES(workflowId, type, ticketNo, activity, payLoad);
		return new FieldEZResponse(type, "200", "posted to des");
	}

	public void postDES(String workflowId, String type,String ticketNo, String activity, String payLoad) {
		// if any previous request for the same ticket failed, keep it in DB and send later

		boolean previousFailed = desRepository.isPreviousAttempsFailed(ticketNo, Integer.parseInt(orgId));
		IntegrationLogDetail logDetail = createIntegrationLog(workflowId, type, ticketNo, activity, payLoad, previousFailed);
		if(previousFailed) {
			return;
		}
		postEvent(workflowId, type, ticketNo, activity, payLoad,logDetail);		
	}

	/*
	 * private method that converts the payload to respective Object, 
	 * and calls the method according to the eventType.
	 */

	protected void postEvent(String wfId, String type,String ticketNo, String activity, String payLoad,IntegrationLogDetail logDetail) {
		logger.debug("---involking postEvent, JaxBMarshalling...");
		JAXBContext jaxbContext;
		Unmarshaller jaxbUnmarshaller = null;
		ExternalComplaint complaint = null;
		ExternalLineItem lineItem = null;
		ExternalStatus status = null;
		EventContext eventContext = null;
		
		try {
			EventType et = EventType.getEventType(type);
			if(et != null) {
				int orgId = Integer.parseInt(getOrgId());
				int workflowId = (wfId != null && wfId.length() > 0) ? Integer.parseInt(wfId) : 0;
				switch (et) {
				case INTERNAL_CREATE_TICKET:
					jaxbContext = JAXBContext.newInstance(ExternalComplaint.class);
					jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					complaint = (ExternalComplaint) jaxbUnmarshaller.unmarshal(new StringReader(payLoad));
					eventContext = new EventContext(orgId, workflowId,type,ticketNo,activity,complaint, logDetail);
					postCreateComplaint(eventContext);
					break;

				case EXTERNAL_CREATE_TICKET:
					jaxbContext = JAXBContext.newInstance(ExternalComplaint.class);
					jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					complaint = (ExternalComplaint) jaxbUnmarshaller.unmarshal(new StringReader(payLoad));
					eventContext = new EventContext(orgId, workflowId,type,ticketNo,activity,complaint, logDetail);
					postCreateComplaint(eventContext);
					break;

				case EXTERNAL_UPDATE_TICKET:
					jaxbContext = JAXBContext.newInstance(ExternalComplaint.class);
					jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					complaint = (ExternalComplaint) jaxbUnmarshaller.unmarshal(new StringReader(payLoad));
					eventContext = new EventContext(orgId, workflowId,type,ticketNo,activity,complaint, logDetail);
					postUpdateComplaint(eventContext);
					break;

				case INTERNAL_UPDATE_TICKET:
					jaxbContext = JAXBContext.newInstance(ExternalComplaint.class);
					jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					complaint = (ExternalComplaint) jaxbUnmarshaller.unmarshal(new StringReader(payLoad));
					eventContext = new EventContext(orgId, workflowId,type,ticketNo,activity,complaint, logDetail);					
					postUpdateComplaint(eventContext);
					break;

				case INTERNAL_STATUS_UPDATE:
					jaxbContext = JAXBContext.newInstance(ExternalStatus.class);
					jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					status = (ExternalStatus) jaxbUnmarshaller.unmarshal(new StringReader(payLoad));	
					eventContext = new EventContext(orgId, workflowId,type,ticketNo,activity,status, logDetail);
					postStatusUpdate(eventContext);
					break;

				case EXTERNAL_STATUS_UPDATE:
					jaxbContext = JAXBContext.newInstance(ExternalStatus.class);
					jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					status = (ExternalStatus) jaxbUnmarshaller.unmarshal(new StringReader(payLoad));	
					eventContext = new EventContext(orgId, workflowId,type,ticketNo,activity,status, logDetail);
					postStatusUpdate(eventContext);
					break;

				case EXTERNAL_CREATE_ITEM:
					jaxbContext = JAXBContext.newInstance(ExternalLineItem.class);
					jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					lineItem = (ExternalLineItem) jaxbUnmarshaller.unmarshal(new StringReader(payLoad));	
					eventContext = new EventContext(orgId, workflowId,type,ticketNo,activity,lineItem, logDetail);
					postCreateLineItem(eventContext);
					break;

				case INTERNAL_CREATE_ITEM:
					jaxbContext = JAXBContext.newInstance(ExternalLineItem.class);
					jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					lineItem = (ExternalLineItem) jaxbUnmarshaller.unmarshal(new StringReader(payLoad));	
					eventContext = new EventContext(orgId, workflowId,type,ticketNo,activity,lineItem, logDetail);
					postCreateLineItem(eventContext);
					break;

				case EXTERNAL_UPDATE_ITEM:
					jaxbContext = JAXBContext.newInstance(ExternalLineItem.class);
					jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					lineItem = (ExternalLineItem) jaxbUnmarshaller.unmarshal(new StringReader(payLoad));	
					eventContext = new EventContext(orgId, workflowId,type,ticketNo,activity,lineItem, logDetail);
					postUpdateLineItem(eventContext);
					break;

				case INTERNAL_UPDATE_ITEM:
					jaxbContext = JAXBContext.newInstance(ExternalLineItem.class);
					jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					lineItem = (ExternalLineItem) jaxbUnmarshaller.unmarshal(new StringReader(payLoad));	
					eventContext = new EventContext(orgId, workflowId,type,ticketNo,activity,lineItem, logDetail);
					postUpdateLineItem(eventContext);
					break;

				default:
					break;
				}
				// update response here
				logger.debug("---involking update response...");
				desRepository.updateResponse(eventContext);
			}
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}
	}
	public abstract void postCreateComplaint(EventContext context);	
	public abstract void postUpdateComplaint(EventContext context);
	public abstract void postCreateLineItem(EventContext context);	
	public abstract void postUpdateLineItem(EventContext context);	
	public abstract void postStatusUpdate(EventContext context);


	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgId(){
		return orgId;
	}

	public DesRepository getDesRepository() {
		return desRepository;
	}

	public void setDesRepository(DesRepository desRepository) {
		this.desRepository = desRepository;
	}

	private IntegrationLogDetail createIntegrationLog(String workflowId,
			String type, String ticketNo, String activity, String payLoad, boolean previousFailed){
		logger.debug("---involking Create integration log , previousFailed : " + previousFailed);
		String url = uri.replace("{orgId}", orgId);
		int workflowIdInt = workflowId != null && workflowId.length() > 0 ? Integer.parseInt(workflowId) : 0;
		IntegrationLog log = null;
		if(previousFailed) 
			log = new IntegrationLog(Integer.parseInt(orgId),workflowIdInt, ticketNo, url, type, activity, true, false, 0);
		else 
			log = new IntegrationLog(Integer.parseInt(orgId),workflowIdInt, ticketNo, url, type, activity, false, false, 0);
		IntegrationLogDetail logDetail = new IntegrationLogDetail(log, payLoad, null);
		desRepository.createIntegrationlog(logDetail);
		return logDetail;
	}
}
