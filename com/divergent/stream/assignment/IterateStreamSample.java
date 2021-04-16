package com.divergent.stream.assignment;

import java.util.stream.Stream;

/**
 * iterate method for print 5 table and in this mathed stream iterate any number
 * of times
 * 
 * @author Divergent
 *
 */
public class IterateStreamSample {

	public static void main(String[] args) {
		Stream.iterate(1, element -> element + 1).filter(element -> element % 5 == 0).limit(10)
				.forEach(System.out::println);
	}

}
