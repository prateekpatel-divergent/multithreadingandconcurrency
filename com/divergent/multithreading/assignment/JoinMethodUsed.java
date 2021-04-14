package com.divergent.multithreading.assignment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Join method in thread j1 JoinMethodUsed
 * 
 * @author Divergent
 *
 */
public class JoinMethodUsed extends Thread {

	private final static Logger LOGGER = Logger.getLogger(JoinMethodUsed.class.getName());

	public void run() {
		LOGGER.setLevel(Level.FINE);
		for (int i = 0; i < 10; i++) {
			try {
				System.out.print(Thread.currentThread().getName());
				Thread.sleep(500);
			} catch (InterruptedException e) {
				LOGGER.info(e.getMessage());
			}
			System.out.println(" " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		JoinMethodUsed j1 = new JoinMethodUsed();
		JoinMethodUsed j2 = new JoinMethodUsed();
		JoinMethodUsed j3 = new JoinMethodUsed();

		j1.start();
		j2.start();
		j2.join();
		j3.start();
	}

}
