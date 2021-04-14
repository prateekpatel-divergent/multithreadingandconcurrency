package com.divergent.multithreading.assignment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * UncaughtExceptionHandler used in the below Class
 * 
 * @author Divergent
 *
 */
public class UncaughtExceptionHandlerUsed extends Thread {

	private final static Logger LOGGER = Logger.getLogger(UncaughtExceptionHandlerUsed.class.getName());
	public void run() {
		throw new RuntimeException();
	}

	public static void main(String[] args) {
		UncaughtExceptionHandlerUsed t1 = new UncaughtExceptionHandlerUsed();
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				LOGGER.setLevel(Level.FINE);
				LOGGER.info(t1 + " Throw exception " + e);
			}
		});
		t1.start();
	}

}
