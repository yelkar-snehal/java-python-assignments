package mypackage;

import java.util.HashMap;
import java.util.Scanner;

public class CountWord {

	public static void displayWordCount(String str) {

		HashMap<String, Integer> mp = new HashMap<>();

		// remove leading trailing spaces by trim
		// split string by spaces
		String[] words = str.trim().split("\\s+");
		
		// System.out.println( words[0] + words.length );
		
		for (String word : words) {
			if (mp.containsKey(word)) {
				// check if word is already present
				// and increment it's value
				mp.put(word, mp.get(word) + 1);
			} else {
				// add the word if not already present
				mp.put(word, 1);
			}
		}

		// display words and their counts
		mp.forEach((key, value) -> System.out.printf("Word: %s, Count: %d\n", key, value));
		System.out.println("Total number of words: " + words.length);

	}

	public static void main(String[] args) {

		String str = "";

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		str = sc.nextLine();

		// System.out.print(str);
		displayWordCount(str);

		// close resources
		sc.close();
	}
}
