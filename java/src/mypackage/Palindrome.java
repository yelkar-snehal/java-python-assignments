package mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

	public static boolean CheckPalindromeStr(String str, boolean ignoreCase) {
		// if reversed and original strings are equal then
		// given string is a palindrome

		String reversedString = ReverseString.RevString(str);

		if (!ignoreCase && str.equals(reversedString)) {
			// case sensitive check
			return true;
		}
		else if (ignoreCase && str.equalsIgnoreCase(reversedString)) {
			// case insensitive check
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {

		String str = "";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string");
		str = br.readLine();

		// demonstration  of case insensitive check
		if (CheckPalindromeStr(str, true)) {
			System.out.printf("Entered string '%s' is a palindrome", str);
		} else {
			System.out.printf("Entered string '%s' is not a palindrome", str);
		}

	}
}
