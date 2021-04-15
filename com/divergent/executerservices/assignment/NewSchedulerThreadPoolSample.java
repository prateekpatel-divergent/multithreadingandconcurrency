package com.divergent.executerservices.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * newSchedulerThreadPool used for schedule for run thread some time after.
 * 
 * @author Divergent
 *
 */
public class NewSchedulerThreadPoolSample {

	final static Logger LOGGER = Logger.getLogger(NewSchedulerThreadPoolSample.class.getName());

	public static void main(String[] args) {
		ExecutorService service = Executors.newScheduledThreadPool(3);
		LOGGER.info("scheduler class get "+service.getClass());
		service.execute(new Runnable() {

			@Override
			public void run() {
				try {
					Long num = (long) (Math.random() / 30);
					LOGGER.info("Thread - " + Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(num);
					LOGGER.info("After sleep Thread - " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					LOGGER.info(e.getMessage());
				}
			}
		});
		LOGGER.info("Is shutdown "+ service.isShutdown());
		LOGGER.info("Check class "+service.getClass());
		service.shutdown();
	}

}
