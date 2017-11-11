package com.form3.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.form3.model.InputJSON;
import com.form3.model.Payment;
import com.google.gson.Gson;

/**
 * Utility class used for populating the data base with the Payments found in the JSON located in JSON_URL
 * 
 * @author jmg
 *
 */
public class DataStoreUtil {

	private final static Logger logger = LoggerFactory.getLogger(DataStoreUtil.class);

	private final static String JSON_URL = "http://mockbin.org/bin/41ca3269-d8c4-4063-9fd5-f306814ff03f";
	
	private static List<Payment> getPaymentsFromJSON() {
		String stringifyJSON = null;
		List<Payment> payments = new ArrayList<Payment>();
		String errorMsg = null;
		try {
			URL url = new URL(JSON_URL);
			InputStream is = url.openStream();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] buf = new byte[4096];
			int n;
			while ((n = is.read(buf)) >= 0)
				os.write(buf, 0, n);
			os.close();
			is.close();

			stringifyJSON = os.toString();
			
			InputJSON inputJSON = new Gson().fromJson(stringifyJSON, InputJSON.class);
			payments = new ArrayList<Payment>(inputJSON.getData());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			errorMsg = e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			errorMsg = e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg = e.getMessage();
		}
		
		if( errorMsg != null ){
			logger.error("Exception while getting payments from {}. Exception message: {}", JSON_URL, errorMsg);
		}
		
		return payments;
	}

	/**
	 * Populates the database in case it is empty
	 */
	public static void populateDB(){
		
		if( DataStore.getRepository().find().size() == 0){
			logger.info("Inserting payments into data base ...");
			
			List<Payment> payments = getPaymentsFromJSON();
			for( Payment payment : payments ){
				DataStore.getRepository().insert(payment);
			}
			logger.info("{} payments inserted into data base ...", payments.size());
		}		
		
	}
}
