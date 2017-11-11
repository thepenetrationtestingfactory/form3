package com.form3.model;

import java.util.ArrayList;
import java.util.List;

/*
 "charges_information": {
          "bearer_code": "SHAR",
          "sender_charges": [
            {
              "amount": "5.00",
              "currency": "GBP"
            },
            {
              "amount": "10.00",
              "currency": "USD"
            }
          ],
          "receiver_charges_amount": "1.00",
          "receiver_charges_currency": "USD"
        },
 */
public class ChargesInformation {
	private String bearer_code;
	private String receiver_charges_amount;
	private String receiver_charges_currency;
	private List<Charge> sender_charges = new ArrayList<Charge>();
	
	
	
	public ChargesInformation(){}
	public ChargesInformation(String bearer_code, String receiver_charges_amount, String receiver_charges_currency,
			List<Charge> sender_charges) {
		super();
		this.bearer_code = bearer_code;
		this.receiver_charges_amount = receiver_charges_amount;
		this.receiver_charges_currency = receiver_charges_currency;
		this.sender_charges = sender_charges;
	}


	

	public String getBearer_code() {
		return bearer_code;
	}

	public void setBearer_code(String bearer_code) {
		this.bearer_code = bearer_code;
	}

	public String getReceiver_charges_amount() {
		return receiver_charges_amount;
	}

	public void setReceiver_charges_amount(String receiver_charges_amount) {
		this.receiver_charges_amount = receiver_charges_amount;
	}

	public String getReceiver_charges_currency() {
		return receiver_charges_currency;
	}

	public void setReceiver_charges_currency(String receiver_charges_currency) {
		this.receiver_charges_currency = receiver_charges_currency;
	}

	public List<Charge> getSender_charges() {
		return sender_charges;
	}

	public void setSender_charges(List<Charge> sender_charges) {
		this.sender_charges = sender_charges;
	}

	

}
