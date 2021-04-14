package com.divergent.multithreading.assignment;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interrupt used for thread interrupt
 * 
 * @author Divergent
 *
 */
public class InterruptedUsed extends Thread {

	private final static Logger LOGGER = Logger.getLogger(InterruptedUsed.class.getName());

	public void run() {
		LOGGER.setLevel(Level.FINE);
		try {
			System.out.println(Thread.currentThread().isInterrupted());
			Thread.sleep(200);
		} catch (InterruptedException e) {
			LOGGER.info(e.getMessage());
		}
		LOGGER.info("Thread Running");
	}

	public static void main(String[] args) {
		InterruptedUsed t1 = new InterruptedUsed();
		t1.start();
		t1.interrupt();
	}

}
