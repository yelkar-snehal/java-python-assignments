package mypackage;

import java.util.Scanner;

public class Palindrome {

	public static boolean CheckPalindromeStr(String str, boolean ignoreCase) {
		// if reversed and original strings are equal then
		// given string is a palindrome

		String reversedString = ReverseString.revString(str);

		if (!ignoreCase && str.equals(reversedString)) {
			// case sensitive check
			return true;
		} else if (ignoreCase && str.equalsIgnoreCase(reversedString)) {
			// case insensitive check
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		String str = "";

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		str = sc.nextLine();

		// demonstration of case insensitive check
		if (CheckPalindromeStr(str, true)) {
			System.out.printf("Entered string '%s' is a palindrome", str);
		} else {
			System.out.printf("Entered string '%s' is not a palindrome", str);
		}

		// close resources
		sc.close();

	}
}
