package com.form3.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.form3.model.Payment;
import com.form3.model.PaymentDTO;
import com.form3.model.ResponseDTO;
import com.form3.service.PaymentService;


/**
 * REST API controller to handle all the CRUD requests related to Payments
 * @author jmg
 *
 */
@SuppressWarnings("restriction")
@RestController
@RequestMapping("/api/payments")
public class PaymentsApiController {

    private final static Logger logger = LoggerFactory.getLogger(PaymentsApiController.class);

    @Autowired
    private PaymentService service;
    
    
    
    @Resource(name = "paymentValidator")
    private Validator validator;
    
    @InitBinder("paymentDTO")
    public void initBinder(WebDataBinder binder) {
    	binder.addValidators(validator);
    }
    
    
    
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseDTO<List<Payment>> findAll() {
        logger.info("Retrieving all payments");
        return new ResponseDTO<List<Payment>>(null, service.findAll());
    }
    
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseDTO<Payment> find(@PathVariable String id, HttpServletResponse response) {
        logger.info("Retrieving payment with id = {}", id);
        
        Payment payment = service.findOne(id);
        String error = null;
        if( payment != null ){
        	response.setStatus(HttpStatus.OK.value());
        }else{
        	error = "Payment with id="+id+" not found";
        	response.setStatus(HttpStatus.NOT_FOUND.value());
        } 
        return new ResponseDTO<Payment>(error, payment);
        
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseDTO<Boolean> delete(@PathVariable String id, HttpServletResponse response) {
        logger.info("Deleting payment with id = {}", id);
        String error = null;
        boolean result = service.delete(id);
        if( result ){
        	response.setStatus(HttpStatus.OK.value());
        }else{
        	error = "Impossible to delete payment with id="+id;
        	response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        } 
        return new ResponseDTO<Boolean>(error, result);
    }
    
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseDTO<Payment> create(@Valid PaymentDTO paymentDTO, HttpServletResponse response) {
        logger.info("Creating payment={}", paymentDTO);
        
        String error = null;
        Payment payment = service.create(paymentDTO);
        if( payment != null ){
        	response.setStatus(HttpStatus.OK.value());
        }else{
        	error = "Impossible to create new payment";
        	response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        } 
        return new ResponseDTO<Payment>(error, payment);
    }
   
    @ResponseBody
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseDTO<Payment> update(@PathVariable String id, @Valid PaymentDTO paymentDTO, HttpServletResponse response) {
        logger.info("Updating payment with id={}", id);
        String error = null;
        Payment payment = service.update(id, paymentDTO);
        if( payment != null ){
        	response.setStatus(HttpStatus.OK.value());
        }else{
        	error = "Impossible to update payment with id="+id;
        	response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        } 
        return new ResponseDTO<Payment>(error, payment);
    }
    
    
    
}