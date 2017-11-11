package com.form3.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.form3.model.Payment;
import com.form3.model.ResponseDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * 
 * Integration test class for {@link com.form3.controller.PaymentsApiControllerTest}
 * 
 * This class does not run as part of the maven test phase and to be run the server has to be running
 * 
 * @author jmg
 *
 */
public class PaymentsApiControllerTest {

	private static final RestTemplate restTemplate = new RestTemplate();
	private static final String REST_API_URL = "http://localhost:8090/api/payments/";

	
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		ResponseEntity<?> response;
		List<Payment> payments = new ArrayList<Payment>();
		ResponseDTO<List<Payment>> responseDTOList;
		ResponseDTO<Payment> responseDTOSingle;
		
		/****************************************************************
		 * Testing findAll
		 ****************************************************************/
		System.out.println("Testing findAl");
		
		response = restTemplate.getForEntity(REST_API_URL, String.class);
		responseDTOList = gson.fromJson((String)response.getBody(), new TypeToken<ResponseDTO<List<Payment>>>(){}.getType());
		payments = (List<Payment>) responseDTOList.getData();
		
		
		int initialPayments = payments.size();
		String initialLastPaymentId = payments.get(initialPayments-1).getId();
		
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));		
		assertNull(responseDTOList.getError());
		assertNotNull(responseDTOList.getData());
		assertTrue( initialPayments > 0);
		
		
		/****************************************************************
		 * Testing findOne - payment found
		 ****************************************************************/
		System.out.println("Testing findOne - payment found");
				
		response = restTemplate.getForEntity(REST_API_URL + initialLastPaymentId, String.class);
		responseDTOSingle = gson.fromJson((String)response.getBody(), new TypeToken<ResponseDTO<Payment>>(){}.getType());
		Payment payment = (Payment) responseDTOSingle.getData();
		
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));		
		assertNull(responseDTOSingle.getError());
		assertNotNull(responseDTOSingle.getData());
		assertEquals("Payment", payment.getType());
		assertEquals("743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb", payment.getOrganisation_id());
		
		
		/****************************************************************
		 * Testing findOne - payment not found
		 ****************************************************************/
		System.out.println("Testing findOne - payment not found");
		String paymentIdNotInDB = "abcd";
		boolean exception = false;
		try{
			response = restTemplate.getForEntity(REST_API_URL + paymentIdNotInDB, String.class);
		}catch (HttpClientErrorException e) {
			exception = true;
			assertEquals("404 Not Found", e.getMessage());
		}
		assertTrue(exception);		
		
		
		/****************************************************************
		 * Testing create - successful
		 ****************************************************************/
		System.out.println("Testing create - successful");
		
		restTemplate.postForLocation(REST_API_URL + "create", createCorrectPayment());
		
		// Finding all again
		response = restTemplate.getForEntity(REST_API_URL, String.class);
		responseDTOList = gson.fromJson((String)response.getBody(), new TypeToken<ResponseDTO<List<Payment>>>(){}.getType());
		payments = (List<Payment>) responseDTOList.getData();
		
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));		
		assertNull(responseDTOList.getError());
		assertNotNull(responseDTOList.getData());
		
		// The last payment in the list is the just created payment
		String currentLastPaymentId = payments.get(payments.size()-1).getId();
		int currentPayments = payments.size();
		
		assertEquals(currentPayments, initialPayments + 1);
		assertNotEquals(initialLastPaymentId, currentLastPaymentId);
		
		
		/****************************************************************
		 * Testing create - unsuccessful
		 ****************************************************************/
		System.out.println("Testing create - unsuccessful");
		
		exception = false;
		try{
			restTemplate.postForLocation(REST_API_URL + "create", createIncorrectPayment());
		}catch (HttpClientErrorException e) {
			exception = true;
			assertEquals("400 Bad Request", e.getMessage());
		}
		assertTrue(exception);		
		
		// Finding all again to check no new payment has been created
		responseDTOList = gson.fromJson((String)response.getBody(), new TypeToken<ResponseDTO<List<Payment>>>(){}.getType());
		payments = (List<Payment>) responseDTOList.getData();
		
		int newCurrentPayments = payments.size();
		assertEquals(currentPayments, newCurrentPayments);
		
		
		
		/****************************************************************
		 * Testing update last payment in the list - successful
		 ****************************************************************/
		System.out.println("Testing update last payment in the list - successful");
		
		MultiValueMap<String, String> updatedPayment = createCorrectPayment();
		updatedPayment.set("organisation_id","UPDATED ORG ID");
		
		restTemplate.put(REST_API_URL + "update/"+currentLastPaymentId, updatedPayment);
		
		// Finding current last payment
		response = restTemplate.getForEntity(REST_API_URL + currentLastPaymentId, String.class);
		responseDTOSingle = gson.fromJson((String)response.getBody(), new TypeToken<ResponseDTO<Payment>>(){}.getType());
		payment = (Payment) responseDTOSingle.getData();
		
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));		
		assertNull(responseDTOSingle.getError());
		assertNotNull(responseDTOSingle.getData());
		assertEquals("UPDATED ORG ID", payment.getOrganisation_id());
		
		
		/****************************************************************
		 * Testing update last payment in the list - unsuccessful - bad request
		 ****************************************************************/
		System.out.println("Testing update last payment in the list - unsuccessful - bad request");
		
		exception = false;
		try{
			restTemplate.put(REST_API_URL + "update/"+currentLastPaymentId, createIncorrectPayment());
		}catch (HttpClientErrorException e) {
			exception = true;
			assertEquals("400 Bad Request", e.getMessage());
		}
		assertTrue(exception);		
		
		
		/****************************************************************
		 * Testing update last payment in the list - unsuccessful - not found
		 ****************************************************************/
		System.out.println("Testing update last payment in the list - unsuccessful - not found");
		exception = false;
		try{
			restTemplate.put(REST_API_URL + "update/"+"abcd", createCorrectPayment());
		}catch (HttpServerErrorException e) {
			exception = true;
			assertEquals("500 Server Error", e.getMessage());
		}
		assertTrue(exception);		
		
		
		/****************************************************************
		 * Testing delete last payment in the list - success
		 ****************************************************************/
		System.out.println("Testing delete last payment in the list - success");
		
		restTemplate.delete(REST_API_URL + "delete/"+currentLastPaymentId);
		
		// Finding all again to check payment has been removed
		response = restTemplate.getForEntity(REST_API_URL, String.class);
		responseDTOList = gson.fromJson((String)response.getBody(), new TypeToken<ResponseDTO<List<Payment>>>(){}.getType());
		payments = (List<Payment>) responseDTOList.getData();
		
		newCurrentPayments = payments.size();
		assertEquals(currentPayments-1, newCurrentPayments);
		
		
		/****************************************************************
		 * Testing delete non existing payment
		 ****************************************************************/
		System.out.println("Testing delete non existing payment");
		
		exception = false;
		try{
			restTemplate.delete(REST_API_URL + "delete/"+"abcd");			
		}catch (HttpServerErrorException e) {
			exception = true;
			assertEquals("500 Server Error", e.getMessage());
		}
		assertTrue(exception);	
		
	}
	
	/**
	 * A payment with all attributes different than null is considered valid payment
	 * @return
	 */
	private static MultiValueMap<String, String> createCorrectPayment(){
		MultiValueMap<String, String> payment = new LinkedMultiValueMap<String, String>();
		payment.add("type", "Payment");
		payment.add("version", "0");
		payment.add("organisation_id", "743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb");
		payment.add("amount", "100.21");
		//Benefit party			
		payment.add("bp_account_name", "W Owens");
		payment.add("bp_account_number", "31926819");
		payment.add("bp_account_number_code", "BBAN");
		payment.add("bp_account_type", "0");/****************/
		payment.add("bp_address", "1 The Beneficiary Localtown SE2");
		payment.add("bp_bank_id", "403000");
		payment.add("bp_bank_id_code", "GBDSC");
		payment.add("bp_name", "Wilfred Jeremiah Owens");
		
		payment.add("bearer_code", "SHAR");
		payment.add("amount1", "5.00");
		payment.add("currency1", "GBP");
		payment.add("amount2", "10.00");
		payment.add("currency2", "USD");
		payment.add("receiver_charges_amount", "1.00");
		payment.add("receiver_charges_currency", "USD");
		payment.add("currency", "GBP");
		//Debtor patry
		payment.add("dp_account_name", "EJ Brown Black");
		payment.add("dp_account_number", "GB29XABC10161234567801");
		payment.add("dp_account_number_code", "IBAN");
		payment.add("dp_address", "10 Debtor Crescent Sourcetown NE1");
		payment.add("dp_bank_id", "203301");
		payment.add("dp_bank_id_code", "GBDSC");
		payment.add("dp_name", "Emelia Jane Brown");
		
		payment.add("end_to_end_reference", "Wil piano Jan");
		payment.add("contract_reference", "FX123");
		payment.add("exchange_rate", "2.00000");
		payment.add("original_amount", "200.42");
		payment.add("original_currency", "USD");
		payment.add("numeric_reference", "1002001");
		payment.add("payment_id", "123456789012345678");
		payment.add("payment_purpose", "Paying for goods/services");
		payment.add("payment_scheme", "FPS");
		payment.add("payment_type", "Credit");
		payment.add("processing_date", "2017-01-18");
		payment.add("reference", "Payment for Em's piano lessons");
		payment.add("scheme_payment_sub_type", "InternetBanking");
		payment.add("scheme_payment_type", "ImmediatePayment");
	    //Sponsor party
		payment.add("sp_account_number", "56781234");
		payment.add("sp_bank_id", "123123");
		payment.add("sp_bank_id_code", "GBDSC");
	    
	        
	    return payment;
	}
	
	/**
	 * An incorrect payment is that payment with not all attributes
	 * @return
	 */
	private static MultiValueMap<String, String> createIncorrectPayment(){
		MultiValueMap<String, String> payment = new LinkedMultiValueMap<String, String>();
		payment.add("type", "Payment");
			        
	    return payment;
	}
}