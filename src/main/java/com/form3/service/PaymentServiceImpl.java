package com.form3.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.form3.dao.PaymentDAO;
import com.form3.model.Payment;
import com.form3.model.PaymentDTO;

@Component
public class PaymentServiceImpl implements PaymentService {
	
	private final static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Autowired
	private PaymentDAO dao;
	
	public Payment findOne(String paymentId) {
		Payment payment = dao.findOne(paymentId);
		if( payment == null ){
			logger.warn("Payment with id={} not found", paymentId);
		}
		return payment;
	}

	public List<Payment> findAll() {
		return dao.findAll();
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public boolean delete(String paymentId) {
		boolean result = dao.delete(paymentId);
		if( result ){
			logger.info("Payment with id={} deleted successfully", paymentId);
		}else{
			logger.error("Impossible to delete payment with id={}", paymentId);
		}
		return result;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public Payment create(PaymentDTO dto){
		if( dto != null ){
			Payment payment = dto.convert();
			
			payment = dao.insert(payment);
			if( payment != null ){
				logger.info("Payment with id={} created successfully", payment.getId());
			}else{
				logger.error("Impossible to create payment");
			}
			return payment;
			
		}else{
			logger.error("Payment can't be null");
			return null;
		}	
	}
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public synchronized Payment update(String id, PaymentDTO dto) {
		if( dto != null ){
			Payment payment = findOne(id);
			
			if( payment != null ){
				// Update all attributes from the dto
				payment = dto.convert();
				// Keeping the id
				payment.setId(id);
				
				boolean result = dao.update(payment);
				if( result ){
					logger.info("Payment with id={} updated successfully", id);
				}else{
					logger.error("Impossible to update payment with id={}", id);
				}
				return findOne(id);
			}else{
				logger.error("Impossible to update payment with id={}", id);
				return null;
			}						
		}else{
			logger.error("Payment can't be null");
			return null;
		}
			
	}

	
	
	// This method is just for testing purpose
	public void setDao(PaymentDAO dao) {
		this.dao = dao;
	}
	
}
