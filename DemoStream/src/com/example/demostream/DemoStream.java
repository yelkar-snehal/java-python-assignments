package com.example.demostream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

		// collect to list
		Stream<Integer> stream7 = list.stream();
		List<Integer> evenNumbersList = stream7.filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.print(evenNumbersList);
		System.out.println();

		// to array
		Stream<Integer> stream8 = list.stream();
		Integer[] evenNumbersArr = stream8.filter(i -> i % 2 == 0).toArray(Integer[]::new);
		for (Integer i : evenNumbersArr) {
			System.out.print(i + " ");
		}
		System.out.println();

		// operations
		List<String> fruits = new ArrayList<String>(
				Arrays.asList("Apple", "Apricots", "Avacados", "Bananas", "Mangoes", "Pears", "Oranges"));

		// intermediate operations
		// returns streams

		// usage of method reference
		// filter
		fruits.stream().filter((s) -> s.startsWith("A")).forEach(System.out::println);
		System.out.println();

		// map
		fruits.stream().filter((s) -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);
		System.out.println();

		// sort
		fruits.stream().sorted().map(String::toUpperCase).forEach(System.out::println);
		System.out.println();

		// terminal operations
		// returns result instead of a stream

		// foreach
		fruits.forEach(System.out::println);

		// collect
		List<String> fruitsInUppercase = fruits.stream().sorted().map(String::toUpperCase).collect(Collectors.toList());
		System.out.print(fruitsInUppercase);
		System.out.println();

		// match
		boolean matchedResult = fruits.stream().anyMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);

		matchedResult = fruits.stream().allMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);

		matchedResult = fruits.stream().noneMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);

		// count
		long totalMatched = fruits.stream().filter((s) -> s.startsWith("A")).count();
		System.out.println(totalMatched);

		// reduce
		Optional<String> reduced = fruits.stream().reduce((s1, s2) -> s1 + ", " + s2);
		reduced.ifPresent(System.out::println);

		// short circuit operations
		// something like break on first match

		// anymatch returns bool
		boolean matched = fruits.stream().anyMatch((s) -> s.startsWith("A"));
		System.out.println(matched);

		// findfirst returns that element itself
		String firstMatchedName = fruits.stream().filter((s) -> s.startsWith("A")).findFirst().get();
		System.out.println(firstMatchedName);

		// parallel stream
		Stream<Integer> stream9 = list.parallelStream();
		Integer[] evenNumbersArr1 = stream9.filter(i -> i % 2 == 0).toArray(Integer[]::new);
		// System.out.print(evenNumbersArr1);
		for (Integer i : evenNumbersArr1) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
