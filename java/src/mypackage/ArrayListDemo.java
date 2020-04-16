package mypackage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

class MyArrayList {
	int n;
	ArrayList<Integer> arrayList;

	public MyArrayList(int n) {
		this.n = n;
		arrayList = new ArrayList<Integer>();
	}

	public void setArrayList(Scanner sc) {

		for (int i = 0; i < n; i++) {
			System.out.printf("Enter element %d: \n", i + 1);
			try {
				arrayList.add(sc.nextInt());
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("That's not a number!\nThis execption occured\n" + e);
				System.exit(1);
			}
		}
	}

	public ArrayList<Integer> getArrayList() {
		return this.arrayList;
	}

	public void displayArrayListWithFor() {

		int n = arrayList.size();
		for (int i = 0; i < n; i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		System.out.println();

	}

	public void displayArrayListWithForEach() {

		for (Integer i : arrayList) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	public void displayArrayListWithWhile() {

		Iterator<Integer> iter = arrayList.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();

	}

}

public class ArrayListDemo {
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
		System.out.println("Display ArrayList with for loop");
		obj.displayArrayListWithFor();
		System.out.println("Display ArrayList with foreach loop");
		obj.displayArrayListWithForEach();
		System.out.println("Display ArrayList with while loop");
		obj.displayArrayListWithWhile();

		sc.close();

	}
}
