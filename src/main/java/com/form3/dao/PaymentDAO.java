package com.form3.dao;

import java.util.List;

import com.form3.model.Payment;

/**
 * DAO interface to handle all CRUD operations for payments
 * @author jmg
 *
 */
public interface PaymentDAO {

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
	 * Inserts a new Payment into db
	 * @param payment
	 * @return
	 */
	Payment insert(Payment payment);
	
	/**
	 * Updates the Payment passed as parameter
	 * @param payment
	 * @return
	 */
	boolean update(Payment payment);
	
}
