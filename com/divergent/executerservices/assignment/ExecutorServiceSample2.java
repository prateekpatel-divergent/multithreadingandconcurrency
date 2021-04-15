package com.divergent.executerservices.assignment;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * set collection with callable interface use invokeAny method.
 * 
 * @author Divergent
 *
 */
public class ExecutorServiceSample2 {

	final static Logger LOGGER = Logger.getLogger(ExecutorServiceSample2.class.getName());

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Set<Callable<String>> set = new HashSet<>();
		set.add(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "callable 1";
			}
		});

		set.add(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "callable 2";
			}
		});

		String result = service.invokeAny(set);
		LOGGER.info("Result " + result);
		service.shutdown();
	}

}
