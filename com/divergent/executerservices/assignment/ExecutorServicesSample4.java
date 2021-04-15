package com.divergent.executerservices.assignment;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;

/**
 * DefaultThreadFactory Method used
 * 
 * @author Divergent
 *
 */
public class ExecutorServicesSample4 {

	final static Logger LOGGER = Logger.getLogger(ExecutorServicesSample4.class.getName());

	public static void main(String[] args) {
		ThreadFactory factory = Executors.defaultThreadFactory();
		Thread t = factory.newThread(new Runnable() {

			@Override
			public void run() {
				LOGGER.info("Running Thread......");
			}
		});
		t.start();
	}

}
