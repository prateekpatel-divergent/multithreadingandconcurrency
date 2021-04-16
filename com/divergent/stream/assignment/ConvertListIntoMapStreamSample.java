package com.divergent.stream.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * List convert into map by stream
 * 
 * @author Divergent
 *
 */
public class ConvertListIntoMapStreamSample {

	private final static Logger LOGGER = Logger.getLogger(ConvertListIntoMapStreamSample.class.getName());

	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(101, "Hair Oil", 180));
		list.add(new Product(102, "Shops", 550));
		list.add(new Product(103, "Clothes", 950));
		list.add(new Product(104, "Foods", 450));
		list.add(new Product(105, "Book", 150));

		/**
		 * Convert list to map
		 */
		Map<Integer, String> map = list.stream().collect(Collectors.toMap(p -> p.id, p -> p.name));
		LOGGER.info("List to Map : " + map);

		/**
		 * Method Reference Used in Stream
		 */
		List<Float> lists = list.stream().filter(p -> p.price > 200).map(Product::getPrice)
				.collect(Collectors.toList());
		LOGGER.info("Price greater then 200 : " + lists);
	}

}
