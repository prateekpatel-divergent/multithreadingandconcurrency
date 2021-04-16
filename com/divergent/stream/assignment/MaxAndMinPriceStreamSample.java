package com.divergent.stream.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * In class we can find maximum and minimum value in list
 * 
 * @author Divergent
 *
 */
public class MaxAndMinPriceStreamSample {

	private final static Logger LOGGER = Logger.getLogger(CollectionIterateStreamSample.class.getName());

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(15200);
		list.add(25000);
		list.add(56000);
		list.add(78000);
		list.add(10000);
		list.add(55000);

		// Find Max in the Value List
		int maxPrice = list.stream().max((p1, p2) -> p1 > p2 ? 1 : -1).get();

		LOGGER.info("Maximum value : " + maxPrice);

		// Find Min int the Value List
		int minPrice = list.stream().max((p1, p2) -> p1 < p2 ? 1 : -1).get();

		LOGGER.info("Minimum value : " + minPrice);
	}

}
