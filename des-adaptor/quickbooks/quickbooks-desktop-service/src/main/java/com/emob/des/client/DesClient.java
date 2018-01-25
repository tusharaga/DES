package com.emob.des.client;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emob.des.rest.model.IntegrationDetailWrapper;
import com.emob.des.rest.model.QBWrapper;
import com.emob.des.rest.service.DesRepository;

public class DesClient implements DesClientInterface {

	public static String baseUrl= "http://localhost:8181/cxf/";
	public static Logger logger = LoggerFactory.getLogger(DesClient.class);
	//http://localhost:8080/spring-cxf-rest/services/
	
	public DesClient() {
		logger.info("initializing des client");
	}
	
	public DesRepository desRepository ;//= new DesRepositoryImpl() ;
	
	public DesRepository getDesRepository() {
		return desRepository;
	}


	public void setDesRepository(DesRepository desRepository) {
		this.desRepository = desRepository;
	}


	public QBWrapper getDetailsByOrgId(String orgId){
		QBWrapper wrapper = null;
		try
        {
			wrapper = desRepository.getQBDetailsByOrgId(orgId);
        } catch (Exception e) {
        	
            logger.error(e.getMessage());
        }
		return wrapper;
    }

	
	public IntegrationDetailWrapper getIntegrationDetailByName(String userName){
		IntegrationDetailWrapper wrapper=null;
		try
        {
           wrapper = desRepository.getIntegrationDetailByName(userName);
              
        }catch (Exception e) {
        	 logger.error(e.getMessage());
        }
		return wrapper;
	}
	
	public QBWrapper getDetailsByName(String name){
		QBWrapper wrapper = null;
		try
        {     wrapper = desRepository.getQBDetailsByName(name);
        } catch (Exception e) {
        	 logger.error(e.getMessage());
        }
		return wrapper;
    }
	
	public QBWrapper getDetailsByName(String name,boolean qb_active){
		QBWrapper wrapper = null;
		try {  
			wrapper = desRepository.getQBDetailsByName(name,qb_active);
        } catch (Exception e) {
        	 logger.error(e.getMessage());
        }
		return wrapper;
    }
	
	public void updateQBDesktopDetailsQBRef(String id, String name, String qbxmlResponse,Boolean qb_active){
		try
        {
			desRepository.updateQBDesktopDetailsQBRef(id, name, qbxmlResponse, qb_active);     
        } catch (Exception e) {
        	 logger.error(e.getMessage());
        }
    }


	@Override
	public void updateLastsyncTime(String name, String password, String last_sync_time) {
		desRepository.updateLastsyncTime(name, password,last_sync_time);		
	}


	@Override
	public void postCustomers(String baseUrl, String apiKey, String apiToken,
			String payload) {
		String output = "";
		try{
//			apiKey="nat2299";
//			apiToken="test123";
//            url = "https://www.fieldez.com/emob/api/customer/integration/?apiKey="+apiKey+"&apiToken="+apiToken;
			String url = baseUrl + "/emob/api/customer/integration/?apiKey="+apiKey+"&apiToken="+apiToken;
            logger.info("url : " + url);
            HttpClient client = new HttpClient();
            PostMethod mPost = new PostMethod(url);
            Header mtHeader = new Header();
            StringRequestEntity inputEntity = new StringRequestEntity(payload,"application/xml","UTF-8");
            mtHeader.setName("content-type");
            mtHeader.setValue("application/xml");
            mtHeader.setName("accept");
            mtHeader.setValue("application/xml");
            mPost.addRequestHeader(mtHeader);
            mPost.setRequestEntity(inputEntity);
            client.executeMethod(mPost);
            output = mPost.getResponseBodyAsString( );
            mPost.releaseConnection( );
            logger.info("post customerintegration output : " + output);
        }catch(Exception e){
        logger.error("Error Message while sending the request to Emob :" + e.getMessage());
        }
		
	}
	
	
}
