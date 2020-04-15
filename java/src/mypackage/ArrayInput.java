package mypackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayInput {
	
	public static int[] setArray(Scanner sc) {
		
		int n = 0;
		
		// user input
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
				
				// close resources
				// sc.close();
				
				return arr;
	}
}
