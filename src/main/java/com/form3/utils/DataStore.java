package com.form3.utils;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.form3.model.Payment;


/**
 * Singleton used to init the NoSQL database and the Payment repository within the database.
 * The Nitrite database is stored in file system: DB_PATH
 * @author jmg
 *
 */
public class DataStore {
	
	private final static Logger logger = LoggerFactory.getLogger(DataStore.class);
	private final static String DB_PATH = "/tmp/form3.db";
	
	
	private static ObjectRepository<Payment> repository;
	private static Nitrite db;
	
	
	public static ObjectRepository<Payment> getRepository(){
		if( repository == null){
			repository = initDB();
		}		
		return repository;
	}
		
	
	private static ObjectRepository<Payment> initDB() {
		logger.info("Data base initialization ...");
		db = Nitrite.builder().compressed().filePath(DB_PATH).openOrCreate("user", "password");

		logger.info("Creating object repository ...");
		repository = db.getRepository(Payment.class);
		
		return repository;
	}
	
	
	public static void closeRepository(){
		logger.info("Closing repository ...");
		repository.close();		
	}
	
	public static void closeDB(){
		logger.info("Closing data base ...");
		db.close();
	}
	
	public static void dropRepository(){
		logger.info("Dropping repository ...");
		repository.drop();			
	}
}
