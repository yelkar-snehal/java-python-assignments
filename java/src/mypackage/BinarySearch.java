package mypackage;

import java.util.Arrays;

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
		int[] arr = { 12, 2, 4, 6, 8, 5 };

		// sort array in an ascending order to apply binary search
		Arrays.sort(arr);

		int result = Search(arr, 12);
		if (-1 != result) {
			System.out.println("Element found!");
		} else {
			System.out.println("Element not found!");
		}

	}

}
