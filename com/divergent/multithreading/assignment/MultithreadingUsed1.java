package com.divergent.multithreading.assignment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple Way to create thread
 * 
 * @author Divergent
 *
 */
public class MultithreadingUsed1 extends Thread {

	private final static Logger LOGGER = Logger.getLogger(MultithreadingUsed1.class.getName());

	public void run() {
		LOGGER.setLevel(Level.FINE);
		LOGGER.info("Thread Is Running");
	}

	public static void main(String[] args) {
		MultithreadingUsed1 t1 = new MultithreadingUsed1();
		t1.start();
	}

}
