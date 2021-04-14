package com.divergent.multithreading.assignment;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * ReentrantLock Used in this class
 * 
 * @author Divergent
 *
 */
public class ReentrantLockUsed {

	private final static Logger LOGGER = Logger.getLogger(ReentrantLockUsed.class.getName());

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		LockUsed used = new LockUsed(lock);
		new Thread(used, "Thread-1").start();
	}

}

/**
 * Runnable implement Class for lock acquire.
 * 
 * @author Divergent
 *
 */
class LockUsed implements Runnable {

	private final static Logger LOGGER = Logger.getLogger(ReentrantLockUsed.class.getName());

	ReentrantLock lock;

	public LockUsed(ReentrantLock lock) {
		this.lock = lock;
	}

	public void run() {
		LOGGER.info(Thread.currentThread().getName() + " is Waiting to get the lock");
		lock.lock();
		LOGGER.info(Thread.currentThread().getName() + " has got the lock.");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			LOGGER.info(e.getMessage());
		}
		LOGGER.info(Thread.currentThread().getName() + " has released the lock.");
		lock.unlock();
	}
}