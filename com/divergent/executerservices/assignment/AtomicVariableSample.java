package com.divergent.executerservices.assignment;

import java.util.logging.Logger;

/**
 * Counter class for count increament by 1
 * 
 * @author Divergent
 *
 */
class Counter extends Thread {
	int count = 0;

	public void run() {
		int max = 1;
		for (int i = 0; i < max; i++) {
			count++;
		}
	}
}

/**
 * Atomic variable used in this class
 * 
 * @author Divergent
 *
 */
public class AtomicVariableSample {

	final static Logger LOGGER = Logger.getLogger(AtomicVariableSample.class.getName());

	public static void main(String[] args) throws InterruptedException {
		Counter c = new Counter();
		Thread t1 = new Thread(c, "First");
		Thread t2 = new Thread(c, "Second");
		Thread t3 = new Thread(c, "Third");
		Thread t4 = new Thread(c, "Fourth");

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		t1.join();
		t2.join();
		t3.join();
		t4.join();

		LOGGER.info("Counter is " + c.count);
	}

}
