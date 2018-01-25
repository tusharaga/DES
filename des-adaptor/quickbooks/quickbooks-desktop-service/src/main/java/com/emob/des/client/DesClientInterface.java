package com.emob.des.client;

import com.emob.des.rest.model.IntegrationDetailWrapper;
import com.emob.des.rest.model.QBWrapper;

public interface DesClientInterface {

	public QBWrapper getDetailsByOrgId(String orgId);
	public IntegrationDetailWrapper getIntegrationDetailByName(String userName);
	public QBWrapper getDetailsByName(String name);
	public QBWrapper getDetailsByName(String name,boolean qb_active);
	public void updateQBDesktopDetailsQBRef(String id, String name, String qbxmlResponse,Boolean qb_active);
	public void updateLastsyncTime(String name,String password,String last_sync_time);
	public void postCustomers(String url, String apiKey, String apiToken, String payload);
	
}
