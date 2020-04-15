package mypackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LinearSearch {

	public static int search(int[] arr, int no) {

		int len = arr.length;
		for (int i = 0; i < len; i++) {
			// check for matching element
			// exit func if such element is found
			if (no == arr[i]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int ele = 0;

		Scanner sc = new Scanner(System.in);

		int[] arr = ArrayInput.setArray(sc);

		// scan element to be searched
		System.out.println("Enter element to be searched");
		try {
			ele = sc.nextInt();
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("That's not a number!\nThis execption occured\n" + e);
			System.exit(1);
		}

		int result = search(arr, ele);
		if (-1 != result) {
			System.out.println("Element found at index " + result);
		} else {
			System.out.println("Element not found!");
		}

		// close resources
		sc.close();

	}
}
