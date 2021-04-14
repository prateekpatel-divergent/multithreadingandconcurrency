package com.divergent.multithreading.assignment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sleep method used for send to block state
 * 
 * @author Divergent
 *
 */
public class SleepThreadUsed extends Thread {

	private final static Logger LOGGER = Logger.getLogger(SleepThreadUsed.class.getName());

	public void run() {
		LOGGER.setLevel(Level.FINE);
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				LOGGER.info(e.getMessage());
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		SleepThreadUsed t1 = new SleepThreadUsed();
		SleepThreadUsed t2 = new SleepThreadUsed();
		t1.start();
		t2.start();
	}

}
