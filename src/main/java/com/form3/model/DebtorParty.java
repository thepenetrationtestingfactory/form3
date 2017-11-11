package com.form3.model;

/*
"debtor_party": {
          "account_name": "EJ Brown Black",
          "account_number_code": "IBAN",
          "address": "10 Debtor Crescent Sourcetown NE1",
          "name": "Emelia Jane Brown"
        },
      
*/
public class DebtorParty extends SponsorParty {

	private String account_name;
    private String account_number_code;
	private String address;
	private String name;
	
	public DebtorParty(){}

	/*
	public DebtorParty(String account_name, String account_number_code, String address, String name) {
		super();
		this.account_name = account_name;
		this.account_number_code = account_number_code;
		this.address = address;
		this.name = name;
	}*/

	public DebtorParty(String account_number, String bank_id, String bank_id_code,
			String account_name, String account_number_code, String address, String name) {
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
