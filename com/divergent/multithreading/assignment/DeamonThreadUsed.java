package com.divergent.multithreading.assignment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Check Daemon Thread set Daemon
 * 
 * @author Divergent
 *
 */
public class DeamonThreadUsed extends Thread {

	private final static Logger LOGGER = Logger.getLogger(DeamonThreadUsed.class.getName());

	public void run() {
		LOGGER.setLevel(Level.FINE);
		if (Thread.currentThread().isDaemon()) {
			LOGGER.info("Daemon Thread " + Thread.currentThread().getName());
		} else {
			LOGGER.info("User Thread " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		DeamonThreadUsed d1 = new DeamonThreadUsed();
		DeamonThreadUsed d2 = new DeamonThreadUsed();
		DeamonThreadUsed d3 = new DeamonThreadUsed();
		d2.setDaemon(true);
		d1.start();
		d2.start();
		d3.start();
	}

}
