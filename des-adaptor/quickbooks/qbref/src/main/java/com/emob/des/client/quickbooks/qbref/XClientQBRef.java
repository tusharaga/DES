package com.emob.des.client.quickbooks.qbref;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.emob.des.qb.domain.QBContext;
import com.emob.des.qb.service.QBConnector;
import com.emob.des.rest.model.ComplaintIntegrationDTO;
import com.emob.des.rest.model.ComplaintLineItemDTO;
import com.emob.des.rest.model.EventContext;
import com.emob.des.rest.model.ExternalStatus;
import com.emob.des.rest.service.AbstractDESBundle;
import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Item;

public class XClientQBRef extends AbstractDESBundle {
	private QBConnector qbConnector;
	private String accessToken;
	private String accessTokenSecret ;
	private String realmID;
	
	public void post(QBContext qbContext, EventContext context) {
		if(qbConnector != null) {
			qbConnector.postCreateInvoice(qbContext, context);
		}
	}

	@Override
	public void postCreateComplaint(EventContext context) {

	}

	@Override
	public void postUpdateComplaint(EventContext context) {
		System.out.println("-- postUpdateComplaint invoked" + context);
	}

	@Override
	public void postCreateLineItem(EventContext context) {

	}

	@Override
	public void postUpdateLineItem(EventContext context) {

	}

	@Override
	public void postStatusUpdate(EventContext context) {
		System.out.println("-- postStatusUpdate invoked" + context);
		if(context != null) {
			context.setWorkflowId(0);
			ExternalStatus status = context.getExternalStatus();
			ComplaintIntegrationDTO complaint = status.getParentEntity();
			Set<ComplaintLineItemDTO> lineItems = complaint.getLineItems();
			
		//	ExternalComplaint complaint = context.getExternalComplaint();
			if(complaint != null && (lineItems != null && lineItems.size() > 0)) {
				System.out.println("-- postStatusUpdate invoked" + status);
				// create an invoice object and call QBConnector to post the invoice..
				Invoice invoice = new Invoice();
				List<Item> items = new ArrayList<Item>();
				for (ComplaintLineItemDTO cliDto : lineItems) {
					Item item = new Item();
					item.setName(cliDto.getExternalId());
					items.add(item);
				}
				
				/*List<Line> lines = new ArrayList<Line>();
				Line line = new Line();
				line.setDetailType(LineDetailTypeEnum.SALES_ITEM_LINE_DETAIL);
				line.setAmount(new BigDecimal(2000));
				SalesItemLineDetail lineDetail = new SalesItemLineDetail();
				ReferenceType referenceType = new ReferenceType();
				referenceType.setValue("1");
				//referenceType.setName("Pro");
				lineDetail.setItemRef(referenceType);
				line.setSalesItemLineDetail(lineDetail);*/
				Customer customer = new Customer();
				customer.setGivenName("Drew");
				/*lines.add(line);
				invoice.setLine(lines);*/
				QBContext qbContext = new QBContext(true);
				qbContext.setInvoice(invoice);
				qbContext.setCustomer(customer);
				post(qbContext, context);
			}
		}
	}

	public QBConnector getQbConnector() {
		return qbConnector;
	}

	public void setQbConnector(QBConnector qbConnector) {
		this.qbConnector = qbConnector;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}

	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}

	public String getRealmID() {
		return realmID;
	}

	public void setRealmID(String realmID) {
		this.realmID = realmID;
	}
}
