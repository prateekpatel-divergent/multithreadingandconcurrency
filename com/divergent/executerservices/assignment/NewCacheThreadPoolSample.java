package com.divergent.executerservices.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class NewCacheThreadPoolSample {

	final static Logger LOGGER = Logger.getLogger(NewCacheThreadPoolSample.class.getName());

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 4; i++) {
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
		}
		service.shutdown();
	}

}
