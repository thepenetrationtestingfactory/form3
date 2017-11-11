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
public class BeneficiaryParty extends DebtorParty{

	private Integer account_type;

	public BeneficiaryParty(){
		super();
	}
	
/*
	public BeneficiaryParty(Integer account_type) {
		super();
		this.account_type = account_type;
	}
	*/

	public BeneficiaryParty(String account_number, String bank_id, String bank_id_code, String account_name,
			String account_number_code, String address, String name, Integer account_type) {
		super(account_number, bank_id, bank_id_code, account_name, account_number_code, address, name);
		this.account_type = account_type;
	}



	public Integer getAccount_type() {
		return account_type;
	}

	public void setAccount_type(Integer account_type) {
		this.account_type = account_type;
	}
	
	
}
