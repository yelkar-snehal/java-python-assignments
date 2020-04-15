package mypackage;

import java.util.InputMismatchException;
import java.util.Scanner;

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

	public static void main(String[] args) {

		int no1 = 0, no2 = 0;

		Scanner sc;

		// take input until a right one is entered
		while (true) {
			try {
				sc = new Scanner(System.in);
				System.out.println("Enter two numbers");
				no1 = sc.nextInt();
				no2 = sc.nextInt();
				// exit loop once both ip are of right data-type
				break;

			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("That's not a number!\nThis execption occured\n" + e);

			}
		}

		System.out.printf("The two numbers you entered are %d and %d\n", no1, no2);

		int[] ret = swapNumbers(no1, no2);
		no1 = ret[0];
		no2 = ret[1];

		System.out.printf("The two numbers after swapping are %d and %d", no1, no2);

		// close resources
		sc.close();
	}
}
