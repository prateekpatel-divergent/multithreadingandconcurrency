package com.divergent.multithreading.assignment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * setPriority and setName used in that class
 * 
 * @author Divergent
 *
 */
public class ThreadPriorityUsed extends Thread {

	private final static Logger LOGGER = Logger.getLogger(ThreadPriorityUsed.class.getName());

	public void run() {
		LOGGER.setLevel(Level.FINE);
		LOGGER.fine("Thread Name : " + Thread.currentThread().getName());
		LOGGER.fine("Priority of thread :" + Thread.currentThread().getPriority());
	}

	public static void main(String[] args) {
		ThreadPriorityUsed t1 = new ThreadPriorityUsed();
		ThreadPriorityUsed t2 = new ThreadPriorityUsed();
		t1.setName("Ramu");
		t2.setName("Raju");
		t1.setPriority(MIN_PRIORITY);
		t2.setPriority(MAX_PRIORITY);
		t1.start();
		t2.start();
	}

}
