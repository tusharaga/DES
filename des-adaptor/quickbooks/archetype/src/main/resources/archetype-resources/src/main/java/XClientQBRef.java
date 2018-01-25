#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.emob.des.qb.domain.QBContext;
import com.emob.des.qb.service.QBConnector;
import com.emob.des.rest.model.EventContext;
import com.emob.des.rest.model.ExternalComplaint;
import com.emob.des.rest.service.AbstractDESBundle;
import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Line;
import com.intuit.ipp.data.LineDetailTypeEnum;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.SalesItemLineDetail;

public class XClientQBRef extends AbstractDESBundle {
	private QBConnector qbConnector;
	private String accessToken;
	private String accessTokenSecret ;
	private String realmID;
	
	public void post(QBContext qbContext) {
		if(qbConnector != null) {
			qbConnector.postInvoice(qbContext);
		}
	}

	@Override
	public void postCreateComplaint(EventContext context) {

	}

	@Override
	public void postUpdateComplaint(EventContext context) {
		System.out.println("-- postUpdateComplaint invoked" + context);
		if(context != null) {
			ExternalComplaint complaint = context.getExternalComplaint();
			if(complaint != null) {
				System.out.println("-- postUpdateComplaint invoked" + complaint);
				// create an invoice object and call QBConnector to post the invoice..
				Invoice invoice = new Invoice();
				List<Line> lines = new ArrayList<Line>();
				Line line = new Line();
				line.setDetailType(LineDetailTypeEnum.SALES_ITEM_LINE_DETAIL);
				line.setAmount(new BigDecimal(2000));
				SalesItemLineDetail lineDetail = new SalesItemLineDetail();
				ReferenceType referenceType = new ReferenceType();
				referenceType.setValue("1");
				//referenceType.setName("Pro");
				lineDetail.setItemRef(referenceType);
				line.setSalesItemLineDetail(lineDetail);
				Customer customer = new Customer();
				customer.setGivenName("Drew");
				lines.add(line);
				invoice.setLine(lines);
				QBContext qbContext = new QBContext(accessToken, accessTokenSecret,realmID);
				qbContext.setInvoice(invoice);
				qbContext.setCustomer(customer);
				post(qbContext);
			}
		}
	}

	@Override
	public void postCreateLineItem(EventContext context) {

	}

	@Override
	public void postUpdateLineItem(EventContext context) {

	}

	@Override
	public void postStatusUpdate(EventContext context) {

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
