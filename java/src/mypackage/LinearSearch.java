package mypackage;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;

public class LinearSearch {

	public static int Search(int[] arr, int no) {

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

	public static void main(String[] args) throws NumberFormatException, IOException {

		// user input
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.out.println("Enter number of elemnts in the array");
		// int n = Integer.parseInt(br.readLine());

		// int[] arr = new int[n];

		int[] arr = { 12, 2, 4, 6, 8, 5 };
		int result = Search(arr, 0);
		if (-1 != result) {
			System.out.println("Element found at index " + result);
		} else {
			System.out.println("Element not found!");
		}

	}
}
