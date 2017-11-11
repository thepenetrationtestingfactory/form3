package com.form3.service;

import java.util.List;

import com.form3.model.Payment;
import com.form3.model.PaymentDTO;

/**
 * Service interface to handle all CRUD operations for payments
 * @author jmg
 *
 */
public interface PaymentService {
	
	/**
	 * Retrieves the Payment which paymentId has been passed as parameter.
	 * @param paymentId
	 * @return
	 */
	Payment findOne(String paymentId);
	
	/**
	 * Retrieves the list of all Payments in the database
	 * @return
	 */
	List<Payment> findAll();
	
	/**
	 * Deletes the Payment which paymentId has been passed as parameter.
	 * @param paymentId
	 * @return true in case of successful deletion; otherwise, false
	 */
	boolean delete(String paymentId);
	
	/**
	 * Creates a new Payment from a PaymentDTO object
	 * @param payment
	 * @return
	 */
	Payment create(PaymentDTO payment);
	
	/**
	 * Updates the Payment which paymentId has been passed as parameter with the data provided by the DTO
	 * @param paymentId
	 * @param dto
	 * @return
	 */
	Payment update(String paymentId, PaymentDTO dto);
	
}
