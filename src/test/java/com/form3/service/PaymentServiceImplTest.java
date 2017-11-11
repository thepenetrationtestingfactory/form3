package com.form3.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.form3.dao.PaymentDAO;
import com.form3.dao.PaymentDAOImpl;
import com.form3.model.Payment;
import com.form3.model.PaymentDTO;
import com.form3.model.SCHEME;
import com.form3.model.SCHEME_SUBTYPE;
import com.form3.model.SCHEME_TYPE;
import com.form3.model.TYPE;
import com.form3.utils.DataStore;
import com.form3.utils.DataStoreUtil;

/**
 * Unit tests for {@link com.form3.service.PaymentServiceImpl}
 */
public class PaymentServiceImplTest {

	private static PaymentServiceImpl service;
	
	
	@BeforeClass
    public static void setUp() {
		service = new PaymentServiceImpl();
		PaymentDAO dao = new PaymentDAOImpl();
		service.setDao(dao);
		
		DataStoreUtil.populateDB();
	}
	@AfterClass
	public static void tearDown(){
		DataStore.dropRepository();
		DataStore.closeDB();
	}
	
	@Test
	public void testFindAll(){
		assertTrue(service.findAll().size() > 0);
	}
	
	@Test
	public void testFind(){
		Payment payment = service.findAll().get(0);
		String paymentId = payment.getId();
		
		assertEquals(SCHEME.FPS, payment.getAttributes().getPayment_scheme());
		assertEquals(TYPE.Credit, payment.getAttributes().getPayment_type());
		assertEquals(SCHEME_TYPE.ImmediatePayment, payment.getAttributes().getScheme_payment_type());
		assertEquals(SCHEME_SUBTYPE.InternetBanking, payment.getAttributes().getScheme_payment_sub_type());
		
		assertNotNull(service.findOne(paymentId));
		assertNull(service.findOne("nonExistingPaymentId"));
	}
	
	@Test
	public void testCreate(){
		String expectedValue = "TEST ACCOUNT NAME";
		PaymentDTO dto = new PaymentDTO();
		dto.setDp_account_name(expectedValue);
		Payment payment = service.create(dto);
		
		assertNotNull(payment);
		assertNotNull(payment.getId());
		assertEquals(expectedValue, payment.getAttributes().getDebtor_party().getAccount_name());
	}
	
	@Test
	public void testUpdate(){
		Payment payment = service.findAll().get(0);
		String old_Bp_address = payment.getAttributes().getBeneficiary_party().getAddress();
		String expectedValue = "NEW TEST ADDRESS";
		
		PaymentDTO dto = new PaymentDTO();
		dto.setBp_address(expectedValue);
		
		payment = service.update(payment.getId(), dto);
		String new_Bp_address = payment.getAttributes().getBeneficiary_party().getAddress();
		
		assertEquals(expectedValue, new_Bp_address);
		assertNotEquals(new_Bp_address, old_Bp_address);
	}
	
	@Test
	public void testDelete(){
		List<Payment> payments = service.findAll();
		// Expected amount of payments is current payments minus the deleted payment
		int expectedValue = payments.size() - 1;
		String paymentId = payments.get(0).getId();
		
		service.delete(paymentId);
		
		assertEquals(expectedValue, service.findAll().size());
	}
	
}
