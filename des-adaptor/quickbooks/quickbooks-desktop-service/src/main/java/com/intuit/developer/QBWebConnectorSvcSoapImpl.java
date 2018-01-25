 package com.intuit.developer;
 
 import com.emob.des.client.DesClientInterface;
import com.emob.des.client.XslTransformer;
import com.emob.des.rest.model.IntegrationDetail;
import com.emob.des.rest.model.IntegrationDetailWrapper;
import com.emob.des.rest.model.QBDesktopDetails;
import com.emob.des.rest.model.QBWrapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.jws.WebService;
import javax.xml.transform.TransformerException;

import org.slf4j.LoggerFactory;
 
 @WebService(serviceName="QBWebConnectorSvc", portName="QBWebConnectorSvcSoap", targetNamespace="http://developer.intuit.com/", endpointInterface="com.intuit.developer.QBWebConnectorSvcSoap")
 public class QBWebConnectorSvcSoapImpl
   implements QBWebConnectorSvcSoap
 {
   private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(QBWebConnectorSvcSoapImpl.class.getName());
   private DesClientInterface desClient;
   IntegrationDetail detail;
   QBWrapper wrapper = null;
   org.slf4j.Logger logger = LoggerFactory.getLogger(QBWebConnectorSvcSoapImpl.class);
   public String userName = "";
   
   public String closeConnection(String ticket)
   {
     this.logger.info("Executing operation closeConnection");
     try
     {
       return "_return994816";
     }
     catch (Exception ex)
     {
       this.logger.error(String.valueOf(ex));
       throw new RuntimeException(ex);
     }
   }
   
   public String clientVersion(String strVersion)
   {
     this.logger.info("Executing operation clientVersion : " + strVersion);
     try
     {
       return "O:" + strVersion;
     }
     catch (Exception ex)
     {
       this.logger.error(String.valueOf(ex));
       throw new RuntimeException(ex);
     }
   }
   
   public String serverVersion(String strVersion)
   {
     this.logger.info("Executing operation serverVersion");
     try
     {
       return strVersion;
     }
     catch (Exception ex)
     {
       this.logger.error(String.valueOf(ex));
       throw new RuntimeException(ex);
     }
   }
   
   public String getLastError(String ticket)
   {
     this.logger.info("Executing operation getLastError");
     try
     {
       return "_return693957079";
     }
     catch (Exception ex)
     {
       this.logger.error(String.valueOf(ex));
       throw new RuntimeException(ex);
     }
   }
   
   public String sendRequestXML(String ticket, String strHCPResponse, String strCompanyFileName, String qbXMLCountry, int qbXMLMajorVers, int qbXMLMinorVers)
   {
     this.logger.info("Executing operation sendRequestXML");
     String _return = "_return893379063";
     try
     {
       if ((this.wrapper != null) && (this.wrapper.getList() != null) && (this.wrapper.getList().get(0) != null))
       {
         this.logger.info("----------qbxml request start ---------------------\n");
         this.logger.info(((QBDesktopDetails)this.wrapper.getList().get(0)).getQbxmlReguest());
         this.logger.info("----------qbxml request end -----------------------\n");
       }
       return ((QBDesktopDetails)this.wrapper.getList().get(0)).getQbxmlReguest();
     }
     catch (Exception ex)
     {
       this.logger.error(String.valueOf(ex));
       throw new RuntimeException(ex);
     }
   }
   
   public String connectionError(String ticket, String hresult, String message)
   {
     LOG.info("Executing operation connectionError");
     LOG.info(ticket);
     LOG.info(hresult);
     LOG.info(message);
     try
     {
       String evLogTxt = "WebMethod: connectionError() has been called by QBWebconnector";
       evLogTxt = evLogTxt + "Parameters received: ";
       evLogTxt = evLogTxt + "string ticket = " + ticket;
       evLogTxt = evLogTxt + "string hresult = " + hresult;
       evLogTxt = evLogTxt + "string message = " + message;
       
       String retVal = null;
       
 
       String QB_ERROR_WHEN_PARSING = "0x80040400";
       
       String QB_COULDNT_ACCESS_QB = "0x80040401";
       
       String QB_UNEXPECTED_ERROR = "0x80040402";
       if (hresult.trim().equals(QB_ERROR_WHEN_PARSING))
       {
         evLogTxt = evLogTxt + "HRESULT = " + hresult;
         evLogTxt = evLogTxt + "Message = " + message;
         retVal = "DONE";
       }
       else if (hresult.trim().equals(QB_COULDNT_ACCESS_QB))
       {
         evLogTxt = evLogTxt + "HRESULT = " + hresult;
         evLogTxt = evLogTxt + "Message = " + message;
         retVal = "DONE";
       }
       else if (hresult.trim().equals(QB_UNEXPECTED_ERROR))
       {
         evLogTxt = evLogTxt + "HRESULT = " + hresult;
         evLogTxt = evLogTxt + "Message = " + message;
         retVal = "DONE";
       }
       else
       {
         evLogTxt = evLogTxt + "HRESULT = " + hresult;
         evLogTxt = evLogTxt + "Message = " + message;
         retVal = "";
       }
       evLogTxt = evLogTxt + "Return values: ";
       evLogTxt = evLogTxt + "string retVal = " + retVal;
       
       return retVal;
     }
     catch (Exception ex)
     {
       this.logger.error(String.valueOf(ex));
       throw new RuntimeException(ex);
     }
   }
   
   public int receiveResponseXML(String ticket, String response, String hresult, String message)
   {
     this.logger.info("Executing operation receiveResponseXML");
     this.logger.info("Ticket :" + ticket);
     this.logger.info("Response Length : " + response.length());
     this.logger.info("Response : " + response);
     this.logger.info("Result : " + hresult);
     this.logger.info("Message : " + message);
     try
     {
       if (this.wrapper != null)
       {
         QBDesktopDetails qbDesktopDetails = (QBDesktopDetails)this.wrapper.getList().get(0);
         this.desClient.updateQBDesktopDetailsQBRef(String.valueOf(qbDesktopDetails.getId()), qbDesktopDetails.getName(), response, Boolean.valueOf(false));
         this.logger.info("----------qbxml response start ---------------------\n");
         this.logger.info(response);
         this.logger.info("----------qbxml response end -----------------------\n");
       }
       if(response.indexOf("<CustomerRet>") != -1){
    	   performUpdate(response);
       }
       return 100;
     }
     catch (Exception ex)
     {
       this.logger.error(String.valueOf(ex));
       throw new RuntimeException(ex);
     }
   }
   
   public ArrayOfString authenticate(String strUserName, String strPassword)
   {
     LOG.info("Executing operation authenticate");
     String _returnStringVal1 = "nvu";
     this.logger.info(strUserName);
     this.logger.info(strPassword);
     this.userName = strUserName;
     try
     {
       ArrayOfString _return = new ArrayOfString();
       List<String> _returnString = new ArrayList<String>();
       IntegrationDetailWrapper integrationwrapper = this.desClient.getIntegrationDetailByName(strUserName);
       if ((integrationwrapper != null) && (integrationwrapper.getList() != null) && (integrationwrapper.getList().size() > 0))
       {
         detail = (IntegrationDetail)integrationwrapper.getList().get(0);
         if ((detail.getQname().equals(strUserName)) && (detail.getPassword().equals(strPassword)))
         {
           logger.info("Valid User");
           this.wrapper = this.desClient.getDetailsByName(detail.getQname(), true);
           if ((this.wrapper != null) && (this.wrapper.getList() != null) && (this.wrapper.getList().size() > 0))
           {
             _returnStringVal1 = "1343206377";
             _returnString.add(_returnStringVal1);
             _returnString.add("");
           }
           else
           {
        	   logger.info("No data to exchange");
             _returnStringVal1 = "1343206377";
             _returnString.add(_returnStringVal1);
             _returnString.add("none");
           }
         }
       }
       _return.getString().addAll(_returnString);
       return _return;
     }
     catch (Exception ex)
     {
       this.logger.error(String.valueOf(ex));
       throw new RuntimeException(ex);
     }
   }
   
   public DesClientInterface getDesClient()
   {
     return this.desClient;
   }
  
   public void setDesClient(DesClientInterface desClient)
   {
     this.desClient = desClient;
   }
   
   private void performUpdate(String response){
	   try
	     {
	       if (detail != null){
	    	   String emobxslt = "";
	    	   String payload = "";
	           try
	           {
	             Map<String, String> env = System.getenv();
	             Properties prop = null;
	             String baseurl = "";
	             if (env != null) {
	               prop = readProperties((String)env.get("SERVICEMIX_HOME") + "/etc/qb.properties");
	             } else {
	               logger.info("Enviornment Variable is Null");
	             }
	             if (prop != null)
	             {
	               String emobXslPath = "";
	               if(response.indexOf("CustomerModRs") != -1){
	               emobXslPath = prop.getProperty("generic-qbcustomer-editsync");
	               }
	               if(response.indexOf("CustomerAddRs") != -1){
		               emobXslPath = prop.getProperty("generic-qbcustomer-addsync");
		           }
	               baseurl= prop.getProperty("base-url","https://www.fieldez.com");
	               if ((emobXslPath != null) && (!emobXslPath.isEmpty())) {
	            	   emobxslt = readFile(emobXslPath);
	               } else {
	                 logger.debug("cannot find the xslt path");
	               }
	               
	               if(emobxslt != null){
	            	   String pi = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
	            	   payload = createXML(emobxslt, response);
	            	   payload = pi+ payload;
	            	   logger.info("============customer integration payload start ==============");
	            	   logger.info(payload);
	            	   logger.info("============customer integration payload end ==============");
	            	   if (payload.indexOf("<customer>") != -1) {
	            		   desClient.postCustomers(baseurl, detail.getApiKey(),detail.getApiToken(), payload);
	            	   }else {
	            		   logger.info("no more customer data to sync");
	            	   }
	               }else{
	            	   logger.info("emobxslt is null");
	               }
	               
	             }
	             String lastSyncTime = getLastSyncTime(response);
	             if(!lastSyncTime.isEmpty()){
	            	 logger.info("last_sync_time : " + lastSyncTime);
	            	 desClient.updateLastsyncTime(detail.getQname(), detail.getPassword(),lastSyncTime);
	             }
	           }
	           catch (IOException e1)
	           {
	             logger.debug(e1.getMessage());
	           }
	       }
	       
	     }
	     catch (Exception ex)
	     {
	       this.logger.error(String.valueOf(ex));
	     }
   }
   
   private String readFile(String pathname) throws IOException {
		String lineSeparator = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer();
		BufferedReader in = new BufferedReader(new FileReader(pathname));
		try {
			String line = null;
			while ((line = in.readLine()) != null) {
				buf.append(line).append(lineSeparator);
			}
		} finally {
			in.close();
		}
		return buf.toString();
	}
	
	private Properties readProperties(String pathname) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(pathname);
			prop.load(input);
		} catch (IOException ex) {
			logger.error(String.valueOf(ex));
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
		return prop;
	}

	private String getLastSyncTime(String response) {
		String qbDate = "";
		if (response.indexOf("<TimeModified>") != -1) {
			int startIndex = response.indexOf("<TimeModified>") + 14;
			int lastIndex = response.indexOf("</TimeModified>");
			qbDate = response.substring(startIndex, lastIndex);
		} else {
			logger.debug("Nothing Modified In Current Time");
		}
		return qbDate;
	}

  private String createXML(String xslt, String xml)
  {
    XslTransformer xsltrans = new XslTransformer(); 
    StringWriter outputxml = new StringWriter();
    try
    {
      StringReader xmlStringReader = new StringReader(xml);
      StringReader xslStringReader = new StringReader(xslt);
      xsltrans.process(xmlStringReader, xslStringReader, outputxml);
    }
    catch (TransformerException e)
    {
      logger.error(e.getMessage());
    }
    logger.info("output String " + outputxml.toString());
    return outputxml.toString();
  }
}
