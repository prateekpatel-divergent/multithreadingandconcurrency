package com.divergent.stream.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Find The element into the list
 * 
 * @author Divergent
 *
 */
public class CollectionIterateStreamSample {
	private final static Logger LOGGER = Logger.getLogger(CollectionIterateStreamSample.class.getName());

	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(101, "Hair Oil", 180));
		list.add(new Product(102, "Shops", 550));
		list.add(new Product(103, "Clothes", 950));
		list.add(new Product(104, "Foods", 450));
		list.add(new Product(105, "Book", 150));
		list.stream().filter(p -> p.price == 450).forEach(p -> LOGGER.info("Product Name :" + p.name));

		// Print All Product price Sum
		LOGGER.info("Sum of All Price : " + list.stream().map(p -> p.price).reduce((sum, p) -> sum + p));

		// Print All Product price sum by collect method using summingDouble
		LOGGER.info("Sum of All Price : " + list.stream().collect(Collectors.summarizingDouble(p -> p.price)));

		// Print count of price
		long count = list.stream().filter(p -> p.price > 200).count();
		LOGGER.info("Count of Value : " + count);

	}

}
