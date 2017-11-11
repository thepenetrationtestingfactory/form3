package com.form3.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.form3.model.PaymentDTO;


/**
 * Validator for check all Payment attributes are present 
 * @author jmg
 *
 */
@Component("paymentValidator")
public class PaymentValidator implements Validator {

	private final static Logger logger = LoggerFactory.getLogger(PaymentValidator.class);
	
	
    public boolean supports(Class<?> clazz) {
    	return PaymentDTO.class == clazz;
    }

    public void validate(Object target, Errors errors) {
    	logger.info("Payment validation starts ...");
    	if (!errors.hasFieldErrors()) {
    		PaymentDTO payment = (PaymentDTO)target;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organisation_id", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currency", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "end_to_end_reference", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numeric_reference", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "payment_id", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "payment_purpose", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "payment_scheme", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "payment_type", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "processing_date", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reference", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "scheme_payment_sub_type", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "scheme_payment_type", "validation.empty", "Can't be empty");
        	//SponsorParty
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sp_account_number", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sp_bank_id", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sp_bank_id_code", "validation.empty", "Can't be empty");
        	//DebtorParty
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dp_account_number", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dp_bank_id", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dp_bank_id_code", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dp_account_name", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dp_account_number_code", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dp_address", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dp_name", "validation.empty", "Can't be empty");
        	//BeneficiaryParty
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bp_account_number", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bp_bank_id", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bp_bank_id_code", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bp_account_name", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bp_account_number_code", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bp_address", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bp_name", "validation.empty", "Can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bp_account_type", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bearer_code", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_charges_amount", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver_charges_currency", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount1", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currency1", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount2", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currency2", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contract_reference", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "exchange_rate", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "original_amount", "validation.empty", "Can't be empty");
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "original_currency", "validation.empty", "Can't be empty");

        }
    	logger.info("Payment validation completed.");
    }
    
}
