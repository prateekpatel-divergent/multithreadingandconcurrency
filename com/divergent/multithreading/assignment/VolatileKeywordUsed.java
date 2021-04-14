package com.divergent.multithreading.assignment;

import java.util.logging.Logger;

/**
 * Volatile keyword used for increase counter
 * 
 * @author Divergent
 *
 */
class VolatileData {
	private volatile int count = 0;

	public int getData() {
		return count;
	}

	public void increaseData() {
		++count;
	}
}

class VolatileThread extends Thread {

	private final static Logger LOGGER = Logger.getLogger(VolatileThread.class.getName());

	private final VolatileData data;

	public VolatileThread(VolatileData data) {
		this.data = data;
	}

	public void run() {
		int oldCount = data.getData();
		LOGGER.info("Thread " + Thread.currentThread().getId() + " old value " + oldCount);
		data.increaseData();
		int newCount = data.getData();
		LOGGER.info("Thread " + Thread.currentThread().getId() + " new value " + newCount);
	}
}

public class VolatileKeywordUsed {

	public static void main(String[] args) throws InterruptedException {
		VolatileData data = new VolatileData();
		VolatileThread thread = new VolatileThread(data);
		for (int i = 0; i < 2; i++) {
			thread.start();
		}
	}

}
