package com.fieldez.interceptor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.Headers;

public class EnableCORSInterceptor extends AbstractPhaseInterceptor<Message> {

    public EnableCORSInterceptor() {
        super(Phase.PRE_PROTOCOL);
    }

    public void handleMessage(Message message) throws Fault {
        Map<String, List<String>> headers = Headers.getSetProtocolHeaders(message);
        try {
            //Access-Control-Allow-Origin:* Access-Control-Allow-Methods:POST,GET
            headers.put("Access-Control-Allow-Origin", Arrays.asList("*"));
            headers.put("Access-Control-Allow-Methods", Arrays.asList("POST", "GET"));
        } catch (Exception ce) {
            throw new Fault(ce);
        }
    }
}