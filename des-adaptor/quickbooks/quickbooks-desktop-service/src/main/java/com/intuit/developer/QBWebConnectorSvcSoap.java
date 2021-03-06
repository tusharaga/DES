package com.intuit.developer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2014-10-14T10:49:44.663+05:30
 * Generated source version: 2.7.12
 * 
 */
@WebService(targetNamespace = "http://developer.intuit.com/", name = "QBWebConnectorSvcSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface QBWebConnectorSvcSoap {

    @WebResult(name = "closeConnectionResult", targetNamespace = "http://developer.intuit.com/")
    @RequestWrapper(localName = "closeConnection", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.CloseConnection")
    @WebMethod(action = "http://developer.intuit.com/closeConnection")
    @ResponseWrapper(localName = "closeConnectionResponse", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.CloseConnectionResponse")
    public java.lang.String closeConnection(
        @WebParam(name = "ticket", targetNamespace = "http://developer.intuit.com/")
        java.lang.String ticket
    );

    @WebResult(name = "clientVersionResult", targetNamespace = "http://developer.intuit.com/")
    @RequestWrapper(localName = "clientVersion", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.ClientVersion")
    @WebMethod(action = "http://developer.intuit.com/clientVersion")
    @ResponseWrapper(localName = "clientVersionResponse", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.ClientVersionResponse")
    public java.lang.String clientVersion(
        @WebParam(name = "strVersion", targetNamespace = "http://developer.intuit.com/")
        java.lang.String strVersion
    );

    @WebResult(name = "serverVersionResult", targetNamespace = "http://developer.intuit.com/")
    @RequestWrapper(localName = "serverVersion", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.ServerVersion")
    @WebMethod(action = "http://developer.intuit.com/serverVersion")
    @ResponseWrapper(localName = "serverVersionResponse", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.ServerVersionResponse")
    public java.lang.String serverVersion(
        @WebParam(name = "strVersion", targetNamespace = "http://developer.intuit.com/")
        java.lang.String strVersion
    );

    @WebResult(name = "getLastErrorResult", targetNamespace = "http://developer.intuit.com/")
    @RequestWrapper(localName = "getLastError", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.GetLastError")
    @WebMethod(action = "http://developer.intuit.com/getLastError")
    @ResponseWrapper(localName = "getLastErrorResponse", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.GetLastErrorResponse")
    public java.lang.String getLastError(
        @WebParam(name = "ticket", targetNamespace = "http://developer.intuit.com/")
        java.lang.String ticket
    );

    @WebResult(name = "sendRequestXMLResult", targetNamespace = "http://developer.intuit.com/")
    @RequestWrapper(localName = "sendRequestXML", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.SendRequestXML")
    @WebMethod(action = "http://developer.intuit.com/sendRequestXML")
    @ResponseWrapper(localName = "sendRequestXMLResponse", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.SendRequestXMLResponse")
    public java.lang.String sendRequestXML(
        @WebParam(name = "ticket", targetNamespace = "http://developer.intuit.com/")
        java.lang.String ticket,
        @WebParam(name = "strHCPResponse", targetNamespace = "http://developer.intuit.com/")
        java.lang.String strHCPResponse,
        @WebParam(name = "strCompanyFileName", targetNamespace = "http://developer.intuit.com/")
        java.lang.String strCompanyFileName,
        @WebParam(name = "qbXMLCountry", targetNamespace = "http://developer.intuit.com/")
        java.lang.String qbXMLCountry,
        @WebParam(name = "qbXMLMajorVers", targetNamespace = "http://developer.intuit.com/")
        int qbXMLMajorVers,
        @WebParam(name = "qbXMLMinorVers", targetNamespace = "http://developer.intuit.com/")
        int qbXMLMinorVers
    );

    @WebResult(name = "connectionErrorResult", targetNamespace = "http://developer.intuit.com/")
    @RequestWrapper(localName = "connectionError", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.ConnectionError")
    @WebMethod(action = "http://developer.intuit.com/connectionError")
    @ResponseWrapper(localName = "connectionErrorResponse", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.ConnectionErrorResponse")
    public java.lang.String connectionError(
        @WebParam(name = "ticket", targetNamespace = "http://developer.intuit.com/")
        java.lang.String ticket,
        @WebParam(name = "hresult", targetNamespace = "http://developer.intuit.com/")
        java.lang.String hresult,
        @WebParam(name = "message", targetNamespace = "http://developer.intuit.com/")
        java.lang.String message
    );

    @WebResult(name = "receiveResponseXMLResult", targetNamespace = "http://developer.intuit.com/")
    @RequestWrapper(localName = "receiveResponseXML", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.ReceiveResponseXML")
    @WebMethod(action = "http://developer.intuit.com/receiveResponseXML")
    @ResponseWrapper(localName = "receiveResponseXMLResponse", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.ReceiveResponseXMLResponse")
    public int receiveResponseXML(
        @WebParam(name = "ticket", targetNamespace = "http://developer.intuit.com/")
        java.lang.String ticket,
        @WebParam(name = "response", targetNamespace = "http://developer.intuit.com/")
        java.lang.String response,
        @WebParam(name = "hresult", targetNamespace = "http://developer.intuit.com/")
        java.lang.String hresult,
        @WebParam(name = "message", targetNamespace = "http://developer.intuit.com/")
        java.lang.String message
    );

    @WebResult(name = "authenticateResult", targetNamespace = "http://developer.intuit.com/")
    @RequestWrapper(localName = "authenticate", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.Authenticate")
    @WebMethod(action = "http://developer.intuit.com/authenticate")
    @ResponseWrapper(localName = "authenticateResponse", targetNamespace = "http://developer.intuit.com/", className = "com.intuit.developer.AuthenticateResponse")
    public com.intuit.developer.ArrayOfString authenticate(
        @WebParam(name = "strUserName", targetNamespace = "http://developer.intuit.com/")
        java.lang.String strUserName,
        @WebParam(name = "strPassword", targetNamespace = "http://developer.intuit.com/")
        java.lang.String strPassword
    );
}
