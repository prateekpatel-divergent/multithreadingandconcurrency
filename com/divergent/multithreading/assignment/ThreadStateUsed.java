package com.divergent.multithreading.assignment;

import java.util.logging.Logger;

/**
 * State of Thread
 * 
 * @author Divergent
 *
 */
public class ThreadStateUsed extends Thread{

	private final static Logger LOGGER = Logger.getLogger(ThreadStateUsed.class.getName());

	public void run() {
		try {
			Thread.sleep(500);
			LOGGER.info("Running State " + Thread.currentThread().getState());
		} catch (InterruptedException e) {
			LOGGER.info(e.getMessage());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadStateUsed t1 = new ThreadStateUsed();
		LOGGER.info("Run State " + Thread.currentThread().getState());
		t1.start();
		t1.interrupt();
		LOGGER.info("Interrupt state " + Thread.currentThread().getState());
	}

}
