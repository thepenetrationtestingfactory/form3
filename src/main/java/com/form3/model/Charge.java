package com.form3.model;

public class Charge {

	private String amount;
	private String currency;
	
	public Charge(){}
	public Charge(String amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
