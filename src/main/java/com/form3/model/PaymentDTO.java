package com.form3.model;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO class to wrap all the attributes necessary to instantiate a Payment object
 * @author jmg
 *
 */
public class PaymentDTO {

	private String type; 
	private String organisation_id; 
	/*Attributes*/ 
	private String amount; 
	private String currency; 
	private String end_to_end_reference; 
	private String numeric_reference; 
	private String payment_id; 
	private String payment_purpose;
	private SCHEME payment_scheme; 
	private TYPE payment_type; 
	private String processing_date; 
	private String reference;
	private SCHEME_SUBTYPE scheme_payment_sub_type; 
	private SCHEME_TYPE scheme_payment_type; 
	/*SponsorParty*/
	private String sp_account_number; 
	private String sp_bank_id; 
	private String sp_bank_id_code; 
	/*DebtorParty*/
	private String dp_account_number; 
	private String dp_bank_id; 
	private String dp_bank_id_code; 
	private String dp_account_name; 
	private String dp_account_number_code; 
	private String dp_address; 
	private String dp_name; 
	/*BeneficiaryParty*/
	private String bp_account_number; 
	private String bp_bank_id; 
	private String bp_bank_id_code; 
	private String bp_account_name; 
	private String bp_account_number_code; 
	private String bp_address; 
	private String bp_name; 
	private Integer bp_account_type;
	private String bearer_code; 
	private String receiver_charges_amount; 
	private String receiver_charges_currency; 
	private String amount1; 
	private String currency1; 
	private String amount2; 
	private String currency2; 
	private String contract_reference; 
	private String exchange_rate; 
	private String original_amount; 
	private String original_currency;
	
	public PaymentDTO(){}
	
	public PaymentDTO(String type, String organisation_id, String amount, String currency, String end_to_end_reference,
			String numeric_reference, String payment_id, String payment_purpose, SCHEME payment_scheme,
			TYPE payment_type, String processing_date, String reference, SCHEME_SUBTYPE scheme_payment_sub_type,
			SCHEME_TYPE scheme_payment_type, String sp_account_number, String sp_bank_id, String sp_bank_id_code,
			String dp_account_number, String dp_bank_id, String dp_bank_id_code, String dp_account_name,
			String dp_account_number_code, String dp_address, String dp_name, String bp_account_number,
			String bp_bank_id, String bp_bank_id_code, String bp_account_name, String bp_account_number_code,
			String bp_address, String bp_name, Integer bp_account_type, String bearer_code,
			String receiver_charges_amount, String receiver_charges_currency, String amount1, String currency1,
			String amount2, String currency2, String contract_reference, String exchange_rate, String original_amount,
			String original_currency) {
		super();
		this.type = type;
		this.organisation_id = organisation_id;
		this.amount = amount;
		this.currency = currency;
		this.end_to_end_reference = end_to_end_reference;
		this.numeric_reference = numeric_reference;
		this.payment_id = payment_id;
		this.payment_purpose = payment_purpose;
		this.payment_scheme = payment_scheme;
		this.payment_type = payment_type;
		this.processing_date = processing_date;
		this.reference = reference;
		this.scheme_payment_sub_type = scheme_payment_sub_type;
		this.scheme_payment_type = scheme_payment_type;
		this.sp_account_number = sp_account_number;
		this.sp_bank_id = sp_bank_id;
		this.sp_bank_id_code = sp_bank_id_code;
		this.dp_account_number = dp_account_number;
		this.dp_bank_id = dp_bank_id;
		this.dp_bank_id_code = dp_bank_id_code;
		this.dp_account_name = dp_account_name;
		this.dp_account_number_code = dp_account_number_code;
		this.dp_address = dp_address;
		this.dp_name = dp_name;
		this.bp_account_number = bp_account_number;
		this.bp_bank_id = bp_bank_id;
		this.bp_bank_id_code = bp_bank_id_code;
		this.bp_account_name = bp_account_name;
		this.bp_account_number_code = bp_account_number_code;
		this.bp_address = bp_address;
		this.bp_name = bp_name;
		this.bp_account_type = bp_account_type;
		this.bearer_code = bearer_code;
		this.receiver_charges_amount = receiver_charges_amount;
		this.receiver_charges_currency = receiver_charges_currency;
		this.amount1 = amount1;
		this.currency1 = currency1;
		this.amount2 = amount2;
		this.currency2 = currency2;
		this.contract_reference = contract_reference;
		this.exchange_rate = exchange_rate;
		this.original_amount = original_amount;
		this.original_currency = original_currency;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOrganisation_id() {
		return organisation_id;
	}
	public void setOrganisation_id(String organisation_id) {
		this.organisation_id = organisation_id;
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
	public String getEnd_to_end_reference() {
		return end_to_end_reference;
	}
	public void setEnd_to_end_reference(String end_to_end_reference) {
		this.end_to_end_reference = end_to_end_reference;
	}
	public String getNumeric_reference() {
		return numeric_reference;
	}
	public void setNumeric_reference(String numeric_reference) {
		this.numeric_reference = numeric_reference;
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public String getPayment_purpose() {
		return payment_purpose;
	}
	public void setPayment_purpose(String payment_purpose) {
		this.payment_purpose = payment_purpose;
	}
	public SCHEME getPayment_scheme() {
		return payment_scheme;
	}
	public void setPayment_scheme(SCHEME payment_scheme) {
		this.payment_scheme = payment_scheme;
	}
	public TYPE getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(TYPE payment_type) {
		this.payment_type = payment_type;
	}
	public String getProcessing_date() {
		return processing_date;
	}
	public void setProcessing_date(String processing_date) {
		this.processing_date = processing_date;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public SCHEME_SUBTYPE getScheme_payment_sub_type() {
		return scheme_payment_sub_type;
	}
	public void setScheme_payment_sub_type(SCHEME_SUBTYPE scheme_payment_sub_type) {
		this.scheme_payment_sub_type = scheme_payment_sub_type;
	}
	public SCHEME_TYPE getScheme_payment_type() {
		return scheme_payment_type;
	}
	public void setScheme_payment_type(SCHEME_TYPE scheme_payment_type) {
		this.scheme_payment_type = scheme_payment_type;
	}
	public String getSp_account_number() {
		return sp_account_number;
	}
	public void setSp_account_number(String sp_account_number) {
		this.sp_account_number = sp_account_number;
	}
	public String getSp_bank_id() {
		return sp_bank_id;
	}
	public void setSp_bank_id(String sp_bank_id) {
		this.sp_bank_id = sp_bank_id;
	}
	public String getSp_bank_id_code() {
		return sp_bank_id_code;
	}
	public void setSp_bank_id_code(String sp_bank_id_code) {
		this.sp_bank_id_code = sp_bank_id_code;
	}
	
	public String getDp_account_number() {
		return dp_account_number;
	}

	public void setDp_account_number(String dp_account_number) {
		this.dp_account_number = dp_account_number;
	}

	public String getDp_bank_id() {
		return dp_bank_id;
	}

	public void setDp_bank_id(String dp_bank_id) {
		this.dp_bank_id = dp_bank_id;
	}

	public String getDp_bank_id_code() {
		return dp_bank_id_code;
	}

	public void setDp_bank_id_code(String dp_bank_id_code) {
		this.dp_bank_id_code = dp_bank_id_code;
	}

	public String getDp_account_name() {
		return dp_account_name;
	}

	public void setDp_account_name(String dp_account_name) {
		this.dp_account_name = dp_account_name;
	}

	public String getDp_account_number_code() {
		return dp_account_number_code;
	}

	public void setDp_account_number_code(String dp_account_number_code) {
		this.dp_account_number_code = dp_account_number_code;
	}

	public String getDp_address() {
		return dp_address;
	}

	public void setDp_address(String dp_address) {
		this.dp_address = dp_address;
	}

	public String getDp_name() {
		return dp_name;
	}

	public void setDp_name(String dp_name) {
		this.dp_name = dp_name;
	}

	public String getBp_account_number() {
		return bp_account_number;
	}
	public void setBp_account_number(String bp_account_number) {
		this.bp_account_number = bp_account_number;
	}
	public String getBp_bank_id() {
		return bp_bank_id;
	}
	public void setBp_bank_id(String bp_bank_id) {
		this.bp_bank_id = bp_bank_id;
	}
	public String getBp_bank_id_code() {
		return bp_bank_id_code;
	}
	public void setBp_bank_id_code(String bp_bank_id_code) {
		this.bp_bank_id_code = bp_bank_id_code;
	}
	public String getBp_account_name() {
		return bp_account_name;
	}
	public void setBp_account_name(String bp_account_name) {
		this.bp_account_name = bp_account_name;
	}
	public String getBp_account_number_code() {
		return bp_account_number_code;
	}
	public void setBp_account_number_code(String bp_account_number_code) {
		this.bp_account_number_code = bp_account_number_code;
	}
	public String getBp_address() {
		return bp_address;
	}
	public void setBp_address(String bp_address) {
		this.bp_address = bp_address;
	}
	public String getBp_name() {
		return bp_name;
	}
	public void setBp_name(String bp_name) {
		this.bp_name = bp_name;
	}
	public Integer getBp_account_type() {
		return bp_account_type;
	}
	public void setBp_account_type(Integer bp_account_type) {
		this.bp_account_type = bp_account_type;
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
	public String getAmount1() {
		return amount1;
	}
	public void setAmount1(String amount1) {
		this.amount1 = amount1;
	}
	public String getCurrency1() {
		return currency1;
	}
	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}
	public String getAmount2() {
		return amount2;
	}
	public void setAmount2(String amount2) {
		this.amount2 = amount2;
	}
	public String getCurrency2() {
		return currency2;
	}
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
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
	
	/**
	 * Creates a new Payment from all the attributes within this object
	 * @return
	 */
	public Payment convert(){
		Fx fx = new Fx(contract_reference, exchange_rate, original_amount, original_currency);
		Charge charge1 = new Charge(amount1, currency1);
		Charge charge2 = new Charge(amount2, currency2);
		List<Charge> sender_charges = new ArrayList<Charge>();
		sender_charges.add(charge1);
		sender_charges.add(charge2);
		ChargesInformation charges_information = new ChargesInformation(bearer_code, receiver_charges_amount, receiver_charges_currency, sender_charges);
		BeneficiaryParty beneficiary_party = new BeneficiaryParty(bp_account_number, bp_bank_id, bp_bank_id_code, bp_account_name, bp_account_number_code, bp_address, bp_name, bp_account_type);
		DebtorParty debtor_party = new DebtorParty(dp_account_number, dp_bank_id, dp_bank_id_code, dp_account_name, dp_account_number_code, dp_address, dp_name);
		SponsorParty sponsor_party = new SponsorParty(sp_account_number, sp_bank_id, sp_bank_id_code);
		Attributes attributes = new Attributes(original_amount, beneficiary_party, charges_information, original_currency, debtor_party, end_to_end_reference, fx, numeric_reference, payment_id, payment_purpose, payment_scheme, payment_type, processing_date, contract_reference, scheme_payment_sub_type, scheme_payment_type, sponsor_party);
		
		return new Payment(type, organisation_id, attributes);
	}

	@Override
	public String toString() {
		return "PaymentDTO [type=" + type + ", organisation_id=" + organisation_id + ", amount=" + amount
				+ ", currency=" + currency + ", end_to_end_reference=" + end_to_end_reference + ", numeric_reference="
				+ numeric_reference + ", payment_id=" + payment_id + ", payment_purpose=" + payment_purpose
				+ ", payment_scheme=" + payment_scheme + ", payment_type=" + payment_type + ", processing_date="
				+ processing_date + ", reference=" + reference + ", scheme_payment_sub_type=" + scheme_payment_sub_type
				+ ", scheme_payment_type=" + scheme_payment_type + ", sp_account_number=" + sp_account_number
				+ ", sp_bank_id=" + sp_bank_id + ", sp_bank_id_code=" + sp_bank_id_code + ", dp_account_number="
				+ dp_account_number + ", dp_bank_id=" + dp_bank_id + ", dp_bank_id_code=" + dp_bank_id_code
				+ ", dp_account_name=" + dp_account_name + ", dp_account_number_code=" + dp_account_number_code
				+ ", dp_address=" + dp_address + ", dp_name=" + dp_name + ", bp_account_number=" + bp_account_number
				+ ", bp_bank_id=" + bp_bank_id + ", bp_bank_id_code=" + bp_bank_id_code + ", bp_account_name="
				+ bp_account_name + ", bp_account_number_code=" + bp_account_number_code + ", bp_address=" + bp_address
				+ ", bp_name=" + bp_name + ", bp_account_type=" + bp_account_type + ", bearer_code=" + bearer_code
				+ ", receiver_charges_amount=" + receiver_charges_amount + ", receiver_charges_currency="
				+ receiver_charges_currency + ", amount1=" + amount1 + ", currency1=" + currency1 + ", amount2="
				+ amount2 + ", currency2=" + currency2 + ", contract_reference=" + contract_reference
				+ ", exchange_rate=" + exchange_rate + ", original_amount=" + original_amount + ", original_currency="
				+ original_currency + "]";
	}
	
	
}
