package mypackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {

	public static int getFibonacci(int no) {
		if (1 >= no) {
			return no;
		}

		return getFibonacci(no - 1) + getFibonacci(no - 2);
	}

	public static void displayFibonacci(int no) {
		for (int i = 0; i < no; i++) {
			System.out.print(getFibonacci(i) + " ");
		}
	}

	public static void main(String[] args) {

		int no = 0;
		Scanner sc;

		while (true) {
			try {
				sc = new Scanner(System.in);
				System.out.println("Enter a number");
				no = sc.nextInt();
				break;
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("That's not a number!\nThis execption occured\n" + e);
			}
		}

		displayFibonacci(no);

		sc.close();
	}
}
