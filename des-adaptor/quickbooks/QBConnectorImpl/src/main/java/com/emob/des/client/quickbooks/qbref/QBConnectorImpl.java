package com.emob.des.client.quickbooks.qbref;

import static com.intuit.ipp.query.GenerateQuery.$;
import static com.intuit.ipp.query.GenerateQuery.select;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emob.des.qb.domain.QBContext;
import com.emob.des.qb.service.QBConnector;
import com.emob.des.rest.model.ClientAuth;
import com.emob.des.rest.model.EventContext;
import com.emob.des.rest.model.IntegrationEntityDetail;
import com.emob.des.rest.model.IntegrationEntitySearch;
import com.emob.des.rest.model.IntegrationResponse;
import com.emob.des.rest.model.ResponseType;
import com.emob.des.rest.service.DesAuthRepository;
import com.emob.des.rest.service.DesRepository;
import com.emob.des.rest.utils.StringUtils;
import com.intuit.ipp.core.Context;
import com.intuit.ipp.core.ServiceType;
import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Item;
import com.intuit.ipp.data.Line;
import com.intuit.ipp.data.LineDetailTypeEnum;
import com.intuit.ipp.data.PaymentMethod;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.SalesItemLineDetail;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.query.GenerateQuery;
import com.intuit.ipp.security.OAuthAuthorizer;
import com.intuit.ipp.services.DataService;
import com.intuit.ipp.services.QueryResult;

public class QBConnectorImpl implements QBConnector {

	private DesAuthRepository desAuthRepository;
	private DesRepository desRepository;

	private static Logger logger = LoggerFactory.getLogger(QBConnectorImpl.class);

	@Override
	public QBContext postCreateInvoice(QBContext qbcontext, EventContext eventContext) {
		Context context = getContext(eventContext);
		if(context != null) {
			DataService service = new DataService(context);
			Invoice invoice = qbcontext.getInvoice();
			Customer customer = qbcontext.getCustomer();
			List<Item> items = qbcontext.getItems();
			boolean createIfNotExists = qbcontext.isCreateIfNotExists();
			if(invoice != null && customer != null && items != null && items.size() > 0) {
				logger.debug("Invoice : " + invoice + ", Customer : " + customer + ", Item : " + items);
				setCustomerId(service, customer, eventContext, createIfNotExists);
				setItemId(service, items, createIfNotExists);
				// set customer ReferenceType in Invoice
				ReferenceType referenceType = new ReferenceType();
				referenceType.setValue(customer.getId());
				invoice.setCustomerRef(referenceType);
				List<Line> lines = new ArrayList<Line>();
				for (Item item : items) {
					// create a line 
					Line line = new Line();
					line.setDetailType(LineDetailTypeEnum.SALES_ITEM_LINE_DETAIL);
					// create SaleItemLineDetail
					SalesItemLineDetail lineDetail = new SalesItemLineDetail();
					ReferenceType itemReferenceType = new ReferenceType();
					referenceType.setValue(item.getId());
					lineDetail.setItemRef(itemReferenceType);
					line.setSalesItemLineDetail(lineDetail);
					lines.add(line);
				}
				try {
					invoice = service.add(invoice);
					qbcontext.setInvoice(invoice);
					eventContext.setIntegrationResponse(new IntegrationResponse(ResponseType.SUCCESS, invoice.getId()));
				} catch (FMSException e) {
					eventContext.setIntegrationResponse(new IntegrationResponse(ResponseType.SUCCESS, e.getMessage()));
				} catch (Exception e) {
					eventContext.setIntegrationResponse(new IntegrationResponse(ResponseType.ERROR, null));
				}
			} else {
				logger.error("Parameters passed are incorrect , Please recheck");
			}
		}
		return qbcontext;
	}

	@Override
	public QBContext postUpdateInvoice(QBContext context,
			EventContext eventContext) {
		return null;
	}

	@Override
	public QBContext postCreatePO(QBContext context, EventContext eventContext) {
		return null;
	}

	@Override
	public QBContext postUpdatePO(QBContext context, EventContext eventContext) {
		return null;
	}

	@Override
	public QBContext postCreateCustomer(QBContext qbContext,
			EventContext eventContext) {
		Context context = getContext(eventContext);
		if(context != null) {
			DataService service = new DataService(context);
			Customer customer = qbContext.getCustomer();
			PaymentMethod paymentMethod = qbContext.getPaymentMethod();
			String customerQbId = null;
			if(customer != null) {
				if(paymentMethod != null) {
					String paymentQbId = setpaymentMethodId(service, paymentMethod, eventContext, qbContext.isCreateIfNotExists());
					if(StringUtils.hasText(paymentQbId)) {
						ReferenceType referenceType = new ReferenceType();
						referenceType.setValue(paymentQbId);
						customer.setPaymentMethodRef(referenceType);
					}
				}
				IntegrationEntitySearch search = new IntegrationEntitySearch();
				search.setOrgId(eventContext.getOrgId());
				search.setWorkflowId(eventContext.getWorkflowId());
				search.setEntityType("QB_CUSTOMER");
				search.setFieldezEntityId(eventContext.getExternalComplaint() != null
						? eventContext.getExternalComplaint().getParentEntity().getCustomer().getId() : 0);
				IntegrationEntityDetail entityDetail = desRepository.getIntegrationEntityDetailByType(search);
				if(entityDetail != null)
					customerQbId = entityDetail.getExternalEntityId();
				else {
					customerQbId = setCustomerId(service, customer, eventContext, qbContext.isCreateIfNotExists());
					desRepository.createIntegrationEntityDetail(
							new IntegrationEntityDetail(eventContext.getOrgId(), eventContext.getWorkflowId(),
									eventContext.getExternalComplaint() != null
									? eventContext.getExternalComplaint().getParentEntity().getCustomer().getId() 
											: 0, customerQbId, "QB_CUSTOMER"));
				}
			}
			if(eventContext.getIntegrationResponse() == null && customerQbId != null) {
				eventContext.setIntegrationResponse(new IntegrationResponse(ResponseType.SUCCESS, customerQbId));
			}
		}
		return qbContext;
	}

	@Override
	public QBContext postUpdateCustomer(QBContext context,
			EventContext eventContext) {
		return null;
	}

	@Override
	public QBContext postCreateItem(QBContext context, EventContext eventContext) {
		return null;
	}

	@Override
	public QBContext postUpdateItem(QBContext context, EventContext eventContext) {
		return null;
	}

	private String setCustomerId(DataService service,Customer customer, EventContext eventContext, boolean createIfNotExists) {
		QueryResult result = null;
		String customerQbId = null;
		Customer customerProxy = GenerateQuery.createQueryEntity(Customer.class);
		String query = select($(customerProxy.getId()))
				.where($(customerProxy.getGivenName())
						.eq(customer.getGivenName())).generate();
		try {
			result = service.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(result != null) {
			List<Customer> customers = (List<Customer>) result.getEntities();
			if(customers != null && customers.size() > 0) {
				Customer qbCustomer = customers.get(0);
				customerQbId = qbCustomer.getId();
				logger.debug("Customer ID " + customerQbId);
			} 
		}

		if(!StringUtils.hasText(customerQbId)) {
			logger.debug("Customer not found...");
			if(createIfNotExists) {
				logger.debug("Creating Customer...");
				try {
					customer = service.add(customer);
					customerQbId = customer.getId();
					System.out.println("B: " + customerQbId);
					eventContext.setIntegrationResponse(new IntegrationResponse(ResponseType.SUCCESS, customer.getId()));
				} catch (FMSException e) {
					logger.error("FMSException " , e);
					eventContext.setIntegrationResponse(new IntegrationResponse(ResponseType.SUCCESS, e.getMessage()));
				}
			}
		}
		return customerQbId;
	}

	private void setItemId(DataService service,List<Item> items, boolean createIfNotExists) {
		for (Item item : items) {
			QueryResult result = null;
			String itemQbId;
			Item itemProxy = GenerateQuery.createQueryEntity(Item.class);
			String query = select($(itemProxy.getId()))
					.where($(itemProxy.getName())
							.eq(item.getName())).generate();
			try {
				result = service.executeQuery(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(result != null) {
				List<Item> qbItems = (List<Item>) result.getEntities();
				if(qbItems != null && qbItems.size() > 0) {
					Item qbitem = items.get(0);
					itemQbId = qbitem.getId();
					logger.debug("Customer ID " + item);
					item.setId(itemQbId);
				}
			} else {
				logger.debug("Item not found...");
				if(createIfNotExists) {
					logger.debug("Creating Item...");
					try {
						item = service.add(item);
					} catch (FMSException e) {
						logger.error("FMSException " , e);
					}
				}
			}
		}
	}


	private String setpaymentMethodId(DataService service, PaymentMethod paymentMethod
			, EventContext eventContext, boolean createIfNotExists ) {
		QueryResult result = null;
		String paymentMethodId = null;

		PaymentMethod paymentMethodProxy = GenerateQuery.createQueryEntity(PaymentMethod.class);
		String paymentMethodquery = select($(paymentMethodProxy.getId()))
				.where($(paymentMethodProxy.getName())
						.eq(paymentMethod.getName())).generate();

		try {
			result = service.executeQuery(paymentMethodquery);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(result != null) {
			List<PaymentMethod> paymentMethods  =  (List<PaymentMethod>) result.getEntities();
			if(paymentMethods != null && paymentMethods.size() > 0) {
				PaymentMethod qbPaymentMethod = paymentMethods.get(0);
				paymentMethodId = qbPaymentMethod.getId();
			}
		}

		if(!StringUtils.hasText(paymentMethodId)) {
			logger.debug("PaymentMethod not found...");
			if(createIfNotExists) {
				logger.debug("Creating PaymentMethod...");
				try {
					paymentMethod = service.add(paymentMethod);
					paymentMethodId = paymentMethod.getId();
					eventContext.setIntegrationResponse(new IntegrationResponse(ResponseType.SUCCESS, paymentMethodId));
				} catch (FMSException e) {
					logger.error("FMSException " , e);
					eventContext.setIntegrationResponse(new IntegrationResponse(ResponseType.SUCCESS, e.getMessage()));
				}
			}
		}
		return paymentMethodId;
	}

	private Context  getContext(EventContext  eventContext) {
		ClientAuth ca = desAuthRepository.getClientAuth(eventContext.getOrgId(), eventContext.getWorkflowId());
		System.out.println("ClientAuth" + ca);
		System.out.println("ClientAuth Expiry Date : " + ca.getExpiryDate());
		Date expiryDate = ca.getExpiryDate();
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, -2);
		Date dayBeforeYesterday = cal.getTime();
		Date now = new Date(); 

		if(expiryDate != null && (expiryDate.after(dayBeforeYesterday) && expiryDate.before(now))) {
			// if the token is expiring after day before yesterday but before currentdate
			// get the new tokens by calling the Quickbooks reconnect API
			System.out.println("ClientAuth is going to expire, reconnecting now ...");

		}
		OAuthAuthorizer oauth = new OAuthAuthorizer
				(ca.getAttribute2(), ca.getAttribute3(), ca.getAccessToken()
						,ca.getAccessTokenSecret());
		Context context = null;
		try {
			context = new Context(oauth, ca.getAttribute4(), ServiceType.QBO, ca.getAttribute1());
		} catch (FMSException e) {
			logger.error("FMSException " , e);
		}
		return context;
	}

	public DesAuthRepository getDesAuthRepository() {
		return desAuthRepository;
	}

	public void setDesAuthRepository(DesAuthRepository desAuthRepository) {
		this.desAuthRepository = desAuthRepository;
	}

	public DesRepository getDesRepository() {
		return desRepository;
	}

	public void setDesRepository(DesRepository desRepository) {
		this.desRepository = desRepository;
	}
}