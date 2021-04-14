package com.divergent.multithreading.assignment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * In which we can implement Runnable interface implements and create thread.
 * 
 * @author Divergent
 *
 */
public class MultithreadRunnableUsed implements Runnable {

	private final static Logger LOGGER = Logger.getLogger(MultithreadRunnableUsed.class.getName());

	public void run() {
		LOGGER.setLevel(Level.FINE);
		LOGGER.info("Runnable Implements");
	}

	public static void main(String[] args) {
		MultithreadRunnableUsed r1 = new MultithreadRunnableUsed();
		Thread t1 = new Thread(r1);
		t1.start();
		r1.run();
	}

}
