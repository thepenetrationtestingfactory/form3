package com.form3.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.form3.utils.DataStore;
import com.form3.utils.DataStoreUtil;

public class ContextListener implements ServletContextListener {

	
	private final static Logger logger = LoggerFactory.getLogger(ContextListener.class);

	
	public void contextInitialized(ServletContextEvent contextEvent) {
		logger.info("Initializing the context ...");
			
		DataStoreUtil.populateDB();
	}

	public void contextDestroyed(ServletContextEvent contextEvent) {		
		logger.info("Finishing the context ...");
		
		DataStore.closeDB();
	}

	
}