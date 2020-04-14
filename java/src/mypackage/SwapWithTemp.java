package mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapWithTemp {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int no1, no2;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter two numbers");
		no1 = Integer.parseInt(br.readLine());
		no2 = Integer.parseInt(br.readLine());

		System.out.printf("The two numbers you entered are %d and %d\n", no1, no2);

		// declare a temp variable'
		int temp = 0;
		// swapping logic
		temp = no1;
		no1 = no2;
		no2 = temp;

		System.out.printf("The two numbers after swapping are %d and %d", no1, no2);
	}
}
