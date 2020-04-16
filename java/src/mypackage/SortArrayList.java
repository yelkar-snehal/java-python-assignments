package mypackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SortArrayList {

	public static void sortReverse(ArrayList<Integer> arrayList) {

		// Collections.sort(arrayList);
		// descending
		Collections.sort(arrayList, Collections.reverseOrder());
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
		sortReverse(arrayList);
		obj.displayArrayListWithForEach();

		sc.close();

	}
}
