package com.divergent.multithreading.assignment;

import java.util.logging.Logger;

class TablesClass {

	private final static Logger LOGGER = Logger.getLogger(TablesClass.class.getName());

	void printMethod(int n) {
		synchronized (this) {
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
}

class MyThread12 extends Thread {
	TableClass t;

	MyThread12(TableClass t) {
		this.t = t;
	}

	public void run() {
		t.printMethod(5);
	}
}

class MyThread21 extends Thread {
	TableClass t;

	MyThread21(TableClass t) {
		this.t = t;
	}

	public void run() {
		t.printMethod(100);
	}
}

public class SynchronizedBlockUsed {

	public static void main(String[] args) {
		TableClass class1 = new TableClass();
		MyThread1 t1 = new MyThread1(class1);
		MyThread2 t2 = new MyThread2(class1);
		t1.start();
		t2.start();
	}

}
