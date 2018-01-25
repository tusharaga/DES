package com.emob.des.rest.service;

import java.util.List;

import com.emob.des.rest.model.EventContext;
import com.emob.des.rest.model.IntegrationDetail;
import com.emob.des.rest.model.IntegrationDetailWrapper;
import com.emob.des.rest.model.IntegrationEntityDetail;
import com.emob.des.rest.model.IntegrationEntitySearch;
import com.emob.des.rest.model.IntegrationLogDetail;
import com.emob.des.rest.model.QBWrapper;



public interface DesRepository {
	void createIntegrationlog(IntegrationLogDetail integrationLogDetail);
	void updateResponse(EventContext eventContext);
	List<IntegrationLogDetail> findFailedRequests();
	boolean isPreviousAttempsFailed(String tickedNo, int orgId);
	void createIntegrationEntityDetail(IntegrationEntityDetail integrationDetail);
	IntegrationEntityDetail getIntegrationEntityDetailByType(IntegrationEntitySearch entitySearch);
	IntegrationDetail getIntegrationDetailByOrgId(String orgId);
	
	IntegrationDetailWrapper getIntegrationDetailByName(String name);
	QBWrapper getQBDetailsByOrgId(String orgId);	
	QBWrapper getQBDetailsByName(String name);
	QBWrapper getQBDetailsByName(String name, Boolean qbactive);	
	void saveQBDesktopDetails(String orgId, String name, String qbxmlReguest,String qbxmlResponse,boolean qb_active,Boolean emob_active);	
	void updateQBDesktopDetailsQBRef(String id, String name, String qbxmlResponse,Boolean qb_active);
	void updateQBDesktopDetailsEmobRef(String id, String name, String qbxmlResponse,Boolean emob_active);
	void updateLastsyncTime(String name,String password,String timeStamp);
}
