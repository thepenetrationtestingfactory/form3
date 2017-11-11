package com.form3.model;

/*
        
        "beneficiary_party": {
          "account_name": "W Owens",
          "account_number_code": "BBAN",
          "account_type": 0,
          "address": "1 The Beneficiary Localtown SE2",
          "name": "Wilfred Jeremiah Owens"
        }
*/
public class ClientParty extends SponsorParty{

	private String account_name;
	private String account_number_code;
	private String address;
	private String name;
	
	public ClientParty(String account_number, String bank_id, String bank_id_code, String account_name,
			String account_number_code, String address, String name) {
		super(account_number, bank_id, bank_id_code);
		this.account_name = account_name;
		this.account_number_code = account_number_code;
		this.address = address;
		this.name = name;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getAccount_number_code() {
		return account_number_code;
	}

	public void setAccount_number_code(String account_number_code) {
		this.account_number_code = account_number_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
		
}
