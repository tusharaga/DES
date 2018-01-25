package com.emob.des.rest.service;

import com.emob.des.rest.model.ClientAuth;

public interface DesAuthRepository {
	
	ClientAuth getClientAuth(int orgId, int workflowId);
	void updateClientAuth(ClientAuth clientAuth);
	
}
