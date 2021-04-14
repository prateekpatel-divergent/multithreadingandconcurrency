package com.divergent.multithreading.assignment;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * Await and signalAll methods used in this class
 * 
 * @author Divergent
 *
 */
public class ConditionUsedMulti implements Runnable {

	private final static Logger LOGGER = Logger.getLogger(ConditionUsedMulti.class.getName());

	public void run() {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		lock.lock();
		try {
			condition.await();
			LOGGER.info("Await is done Condition");
		} catch (InterruptedException e) {
			LOGGER.info(e.getMessage());
		} finally {
			lock.unlock();
		}

		lock.lock();
		try {
			condition.signalAll();
			LOGGER.info("SignalAll Method lock");
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ConditionUsedMulti multi = new ConditionUsedMulti();
		Thread t1 = new Thread(multi);
		t1.start();
	}

}

// In this program lock is not unlock and program is not terminated.