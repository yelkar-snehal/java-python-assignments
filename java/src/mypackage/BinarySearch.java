package mypackage;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BinarySearch {

	public static int Search(int[] arr, int no) {

		// get start end and mid element to divide search
		int len = arr.length;
		int start = 0;
		int end = len - 1;
		int middle = (start + end) / 2;

		// iterate till start and end don't cross
		while (start <= end) {
			if (arr[middle] > no) {
				// search for number in first half
				end = middle - 1;
			} else if (arr[middle] == no) {
				// element found
				// exit function
				return middle;
			} else {
				// search for number in the latter half
				start = middle + 1;
			}

			middle = (start + end) / 2;
		}

		// crossed
		return -1;
	}

	public static void main(String[] args) {
		int n = 0, ele = 0;

		// user input
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of elemnts in the array");
		try {
			n = sc.nextInt();
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("That's not a number!\nThis execption occured\n" + e);
			System.exit(1);
		}

		int[] arr = new int[n];
		// array init
		for (int i = 0; i < n; i++) {
			System.out.printf("Enter element %d: \n", i + 1);
			try {
				arr[i] = sc.nextInt();
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("That's not a number!\nThis execption occured\n" + e);
				System.exit(1);
			}
		}

		// scan element to be searched
		System.out.println("Enter element to be searched");
		try {
			ele = sc.nextInt();
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("That's not a number!\nThis execption occured\n" + e);
			System.exit(1);
		}

		// sort array in an ascending order to apply binary search
		Arrays.sort(arr);

		int result = Search(arr, ele);
		if (-1 != result) {
			System.out.println("Element found!");
		} else {
			System.out.println("Element not found!");
		}

		// close resources
		sc.close();

	}

}
