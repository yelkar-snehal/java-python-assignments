package mypackage;

import java.util.Scanner;

public class BubbleSort {

	public static void sort(int[] arr) {

		int l = arr.length;
		int temp = 0;

		for (int i = 0; i < l - 1; i++) {
			for (int j = 0; j < l - i - 1; j++) {
				// check if preceding num is greater
				if (arr[j] > arr[j + 1]) {
					// swap pos if num is greater
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr = ArrayInput.setArray(sc);

		System.out.println("Unsorted array: ");
		ArrayInput.getArray(arr);

		sort(arr);
		System.out.println("Sorted array: ");
		ArrayInput.getArray(arr);

	}
}
