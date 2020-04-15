package mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapWithTemp {

	public static int[] swapNumbers(int no1, int no2) {
		// declare a temp variable'
		int temp = 0;
		// swapping logic
		temp = no1;
		no1 = no2;
		no2 = temp;

		// return new values
		// as func is call by value
		int[] ret = { no1, no2 };
		return ret;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		int no1, no2;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter two numbers");
		no1 = Integer.parseInt(br.readLine());
		no2 = Integer.parseInt(br.readLine());

		System.out.printf("The two numbers you entered are %d and %d\n", no1, no2);

		int[] ret = swapNumbers(no1, no2);
		no1 = ret[0];
		no2 = ret[1];

		System.out.printf("The two numbers after swapping are %d and %d", no1, no2);
	}
}
