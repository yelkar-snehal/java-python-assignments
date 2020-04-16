package mypackage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConvertArrayList {

	public static void convertToArray(ArrayList<Integer> arrayList) {

		Integer[] arr = new Integer[arrayList.size()];
		arr = arrayList.toArray(arr);

		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int n = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of elemnts in the array list");
		try {
			n = sc.nextInt();
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("That's not a number!\nThis execption occured\n" + e);
			System.exit(1);
		}

		MyArrayList obj = new MyArrayList(n);
		obj.setArrayList(sc);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList = obj.getArrayList();
		convertToArray(arrayList);

		sc.close();

	}

}
