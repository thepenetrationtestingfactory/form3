package com.form3.model;

/*
"debtor_party": {
          "account_name": "EJ Brown Black",
          "account_number": "GB29XABC10161234567801",
          "account_number_code": "IBAN",
          "address": "10 Debtor Crescent Sourcetown NE1",
          "bank_id": "203301",
          "bank_id_code": "GBDSC",
          "name": "Emelia Jane Brown"
        },
        
        "beneficiary_party": {
          "account_name": "W Owens",
          "account_number": "31926819",
          "account_number_code": "BBAN",
          "account_type": 0,
          "address": "1 The Beneficiary Localtown SE2",
          "bank_id": "403000",
          "bank_id_code": "GBDSC",
          "name": "Wilfred Jeremiah Owens"
        },
        "sponsor_party": {
          "account_number": "56781234",
          "bank_id": "123123",
          "bank_id_code": "GBDSC"
        }
*/
public class SponsorParty {

	private String account_number;
	private String bank_id;
	private String bank_id_code;
	
	public SponsorParty(){}
	public SponsorParty(String account_number, String bank_id, String bank_id_code) {
		super();
		this.account_number = account_number;
		this.bank_id = bank_id;
		this.bank_id_code = bank_id_code;
	}
	
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	public String getBank_id_code() {
		return bank_id_code;
	}
	public void setBank_id_code(String bank_id_code) {
		this.bank_id_code = bank_id_code;
	}
	
	
}
