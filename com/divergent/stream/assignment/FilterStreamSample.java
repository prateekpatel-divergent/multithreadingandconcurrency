package com.divergent.stream.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * filter used in this class
 * @author Divergent
 *
 */
public class FilterStreamSample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10200);
		list.add(20000);
		list.add(25000);
		list.add(35000);
		list.add(10000);
		list.stream().filter(find -> find > 15000).collect(Collectors.toList()).forEach(System.out::println);
	}

}
