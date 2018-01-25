package com.emob.des.qb.service;

import com.emob.des.qb.domain.QBContext;
import com.emob.des.rest.model.EventContext;

public interface QBConnector {
	public QBContext postCreateInvoice(QBContext context, EventContext eventContext);
	public QBContext postUpdateInvoice(QBContext context, EventContext eventContext);
	public QBContext postCreatePO(QBContext context, EventContext eventContext);
	public QBContext postUpdatePO(QBContext context, EventContext eventContext);
	public QBContext postCreateCustomer(QBContext context, EventContext eventContext);
	public QBContext postUpdateCustomer(QBContext context, EventContext eventContext);
	public QBContext postCreateItem(QBContext context, EventContext eventContext);
	public QBContext postUpdateItem(QBContext context, EventContext eventContext);
}