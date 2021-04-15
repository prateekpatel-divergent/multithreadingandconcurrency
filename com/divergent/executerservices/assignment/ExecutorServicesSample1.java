package com.divergent.executerservices.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * newSingleThreadExecutor method used in a class and using execute method for
 * excecution.
 * 
 * @author Divergent
 *
 */
public class ExecutorServicesSample1 {

	private final static Logger LOGGER = Logger.getLogger(ExecutorServicesSample1.class.getName());

	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(new Runnable() {

			@Override
			public void run() {
				LOGGER.info("Excecutor Service by executor method");
			}
		});
		
		service.submit(new Runnable() {
			
			@Override
			public void run() {
				LOGGER.info("Excecutor Service by submit method");
			}
		});
		
		service.shutdown();
	}

}
