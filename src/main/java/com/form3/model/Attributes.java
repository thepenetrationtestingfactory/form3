package com.form3.model;

public class Attributes {

	private String amount;
	private String currency;
	private String end_to_end_reference;
	private String numeric_reference;
	private String payment_id;
	private String payment_purpose;
    private String processing_date;
    private String reference;
    private SCHEME payment_scheme;
    private TYPE payment_type;
    private SCHEME_SUBTYPE scheme_payment_sub_type;
    private SCHEME_TYPE scheme_payment_type;
    
    private SponsorParty sponsor_party;
    private DebtorParty debtor_party;
    private BeneficiaryParty beneficiary_party;
    
	
	private ChargesInformation charges_information;
	private Fx fx;
    
      
    

    public Attributes(){}
	public Attributes(String amount, BeneficiaryParty beneficiary_party, ChargesInformation charges_information,
			String currency, DebtorParty debtor_party, String end_to_end_reference, Fx fx, String numeric_reference,
			String payment_id, String payment_purpose, SCHEME payment_scheme, TYPE payment_type,
			String processing_date, String reference, SCHEME_SUBTYPE scheme_payment_sub_type,
			SCHEME_TYPE scheme_payment_type, SponsorParty sponsor_party) {
		super();
		this.amount = amount;
		this.beneficiary_party = beneficiary_party;
		this.charges_information = charges_information;
		this.currency = currency;
		this.debtor_party = debtor_party;
		this.end_to_end_reference = end_to_end_reference;
		this.fx = fx;
		this.numeric_reference = numeric_reference;
		this.payment_id = payment_id;
		this.payment_purpose = payment_purpose;
		this.payment_scheme = payment_scheme;
		this.payment_type = payment_type;
		this.processing_date = processing_date;
		this.reference = reference;
		this.scheme_payment_sub_type = scheme_payment_sub_type;
		this.scheme_payment_type = scheme_payment_type;
		this.sponsor_party = sponsor_party;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public BeneficiaryParty getBeneficiary_party() {
		return beneficiary_party;
	}

	public void setBeneficiary_party(BeneficiaryParty beneficiary_party) {
		this.beneficiary_party = beneficiary_party;
	}

	public ChargesInformation getCharges_information() {
		return charges_information;
	}

	public void setCharges_information(ChargesInformation charges_information) {
		this.charges_information = charges_information;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public DebtorParty getDebtor_party() {
		return debtor_party;
	}

	public void setDebtor_party(DebtorParty debtor_party) {
		this.debtor_party = debtor_party;
	}

	public String getEnd_to_end_reference() {
		return end_to_end_reference;
	}

	public void setEnd_to_end_reference(String end_to_end_reference) {
		this.end_to_end_reference = end_to_end_reference;
	}

	public Fx getFx() {
		return fx;
	}

	public void setFx(Fx fx) {
		this.fx = fx;
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

	public SponsorParty getSponsor_party() {
		return sponsor_party;
	}

	public void setSponsor_party(SponsorParty sponsor_party) {
		this.sponsor_party = sponsor_party;
	}
    
    
    
}
