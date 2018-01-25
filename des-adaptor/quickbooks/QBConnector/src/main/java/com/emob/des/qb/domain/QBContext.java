package com.emob.des.qb.domain;

import java.util.List;

import com.intuit.ipp.core.Context;
import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Item;
import com.intuit.ipp.data.PaymentMethod;

public class QBContext {
	private Context context;
	private Customer customer;
	private Invoice invoice;
	private List<Item> items;
	private PaymentMethod paymentMethod;
	
	private String accessToken;
	private String accessTokenSecret ;
	private String realmID;
	private boolean createIfNotExists;
	
	
	public QBContext() {
		// TODO Auto-generated constructor stub
	}
	
	public QBContext(String accessToken, String accessTokenSecret,
			String realmID) {
		this.accessToken = accessToken;
		this.accessTokenSecret = accessTokenSecret;
		this.realmID = realmID;
	}
	
	public QBContext(boolean createIfNotExists) {
		this.createIfNotExists = createIfNotExists;
	}
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
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

	public boolean isCreateIfNotExists() {
		return createIfNotExists;
	}

	public void setCreateIfNotExists(boolean createIfNotExists) {
		this.createIfNotExists = createIfNotExists;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}