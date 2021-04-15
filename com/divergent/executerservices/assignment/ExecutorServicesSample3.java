package com.divergent.executerservices.assignment;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;


/**
 * newSingleThreadExexcutor used invokeAll method in callable interface
 * 
 * @author Divergent
 *
 */
public class ExecutorServicesSample3 {

	final static Logger LOGGER = Logger.getLogger(ExecutorServicesSample3.class.getName());

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Set<Callable<String>> set = new HashSet<Callable<String>>();
		set.add(new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				return "Callable 1";
			}
		});
		
		set.add(new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				return "Callable 2";
			}
		});
		
		set.add(new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				return "Callable 3";
			}
		});
		
		List<Future<String>> futures = service.invokeAll(set);
		
		futures.forEach((future)->{
			try {
				LOGGER.info("future used for get "+future.get());
			} catch (InterruptedException|ExecutionException e) {
				LOGGER.info(e.getMessage());
			} 
		});
		service.shutdown();
	}

}
