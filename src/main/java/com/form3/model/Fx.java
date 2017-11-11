package com.form3.model;

/*
 "fx": {
          "contract_reference": "FX123",
          "exchange_rate": "2.00000",
          "original_amount": "200.42",
          "original_currency": "USD"
        },
 */

public class Fx {

	private String contract_reference;
	private String exchange_rate;
	private String original_amount;
	private String original_currency;
	
	public Fx(){}
	
	public Fx(String contract_reference, String exchange_rate, String original_amount, String original_currency) {
		super();
		this.contract_reference = contract_reference;
		this.exchange_rate = exchange_rate;
		this.original_amount = original_amount;
		this.original_currency = original_currency;
	}

	public String getContract_reference() {
		return contract_reference;
	}

	public void setContract_reference(String contract_reference) {
		this.contract_reference = contract_reference;
	}

	public String getExchange_rate() {
		return exchange_rate;
	}

	public void setExchange_rate(String exchange_rate) {
		this.exchange_rate = exchange_rate;
	}

	public String getOriginal_amount() {
		return original_amount;
	}

	public void setOriginal_amount(String original_amount) {
		this.original_amount = original_amount;
	}

	public String getOriginal_currency() {
		return original_currency;
	}

	public void setOriginal_currency(String original_currency) {
		this.original_currency = original_currency;
	}
	
	
}
