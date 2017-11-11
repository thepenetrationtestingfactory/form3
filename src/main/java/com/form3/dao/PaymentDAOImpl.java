package com.form3.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dizitart.no2.objects.filters.ObjectFilters;
import org.springframework.stereotype.Component;

import com.form3.model.Payment;
import com.form3.utils.DataStore;

@Component
public class PaymentDAOImpl implements PaymentDAO{

	public Payment findOne(String paymentId) {
		return DataStore.getRepository().find(ObjectFilters.eq("id", paymentId)).firstOrDefault();
	}

	public List<Payment> findAll() {
		return new ArrayList<Payment>(DataStore.getRepository().find().toList());
	}

	public boolean delete(String paymentId) {
		return DataStore.getRepository().remove(ObjectFilters.eq("id", paymentId)).getAffectedCount() != 0 ? true : false;
	}

	public Payment insert(Payment payment) {
		// UUID id generated
		payment.setId(UUID.randomUUID().toString());
		
		DataStore.getRepository().insert(payment).getAffectedCount();
		return  findOne(payment.getId());
	}

	public boolean update(Payment payment) {
		if( findOne(payment.getId()) != null ){
			return DataStore.getRepository().update(payment).getAffectedCount() != 0 ? true : false;
		}else{
			return false;
		}		
		
	}

}
