package com.example.demostream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DemoStream {

	public static void main(String[] args) {

		// values
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		stream.forEach(p -> System.out.print(p + " "));
		System.out.println();

		// stream of array elements
		Stream<Integer> stream1 = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		stream1.forEach(p -> System.out.print(p + " "));
		System.out.println();

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		Stream<Integer> stream3 = list.stream();
		stream3.forEach(p -> System.out.print(p + " "));
		System.out.println();

		// generate iterate
//		Stream<Date> stream4 = Stream.generate(() -> {
//			return new Date();
//		});
//		// stream4.forEach(p -> System.out.print(p + " "));
//		System.out.println();

		// tokens and chars
		IntStream stream5 = "12345_abcdefg".chars();
		stream5.forEach(p -> System.out.print(p + " "));
		System.out.println();

		// OR

		Stream<String> stream6 = Stream.of("A$B$C".split("\\$"));
		stream6.forEach(p -> System.out.print(p + " "));
		System.out.println();

		// converting to other ds
		Stream<Integer> stream7 = list.stream();
		List<Integer> evenNumbersList = stream7.filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.print(evenNumbersList);
	}
}
