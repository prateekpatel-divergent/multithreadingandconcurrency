package com.divergent.executerservices.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

/**
 * ThreadPoolsize get by getPoolSize method
 * 
 * @author Divergent
 *
 */
public class ThreadPoolSizeSample {

	final static Logger LOGGER = Logger.getLogger(ThreadPoolSizeSample.class.getName());

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) service;
		LOGGER.info("Size of Pool " + poolExecutor.getPoolSize());
		for (int i = 0; i <= 5; i++) {
			service.submit(new Runnable() {

				@Override
				public void run() {
					LOGGER.info("Thread - " + Thread.currentThread().getName());
				}
			});
		}
		service.shutdown();
	}

}
