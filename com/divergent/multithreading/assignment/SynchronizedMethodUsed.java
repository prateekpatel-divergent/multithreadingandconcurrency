package com.divergent.multithreading.assignment;

import java.util.logging.Logger;

/**
 * Synchronized method used
 * 
 * @author Divergent
 *
 */
class TableClass {

	private final static Logger LOGGER = Logger.getLogger(TableClass.class.getName());

	synchronized void printMethod(int n) {
		for (int i = 1; i <= 10; i++) {
			LOGGER.info(" " + n * i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				LOGGER.info(e.getMessage());
			}
		}
	}
}

class MyThread1 extends Thread {
	TableClass t;

	MyThread1(TableClass t) {
		this.t = t;
	}

	public void run() {
		t.printMethod(5);
	}
}

class MyThread2 extends Thread {
	TableClass t;

	MyThread2(TableClass t) {
		this.t = t;
	}

	public void run() {
		t.printMethod(100);
	}
}

public class SynchronizedMethodUsed {

	public static void main(String[] args) {
		TableClass class1 = new TableClass();
		MyThread1 t1 = new MyThread1(class1);
		MyThread2 t2 = new MyThread2(class1);
		t1.start();
		t2.start();
	}

}
