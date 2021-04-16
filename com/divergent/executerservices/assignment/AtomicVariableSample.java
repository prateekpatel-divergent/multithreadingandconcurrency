package com.divergent.executerservices.assignment;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * Counter class for count increament by 1 and Atomic interger used
 * 
 * @author Divergent
 *
 */
class Counter extends Thread {

	AtomicInteger atomicInt;

	public Counter() {
		atomicInt = new AtomicInteger();
	}

	public void run() {
		int max = 1000;
		for (int i = 0; i < max; i++) {
			atomicInt.addAndGet(max);
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

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		LOGGER.info("Atomic Counter is : " + c.atomicInt);
	}

}
