package mypackage;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

class MyHashSet {
	int n;
	HashSet<Integer> set;

	public MyHashSet(int n) {
		this.n = n;
		set = new HashSet<Integer>();
	}

	public void setHashSet(Scanner sc) {
		for (int i = 0; i < n; i++) {
			System.out.printf("Enter element %d: \n", i + 1);
			try {
				set.add(sc.nextInt());
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("That's not a number!\nThis execption occured\n" + e);
				System.exit(1);
			}
		}
	}

	public HashSet<Integer> getHashSet() {
		return this.set;
	}

	public TreeSet<Integer> converToTreeSet() {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		treeSet.addAll(set);
		return treeSet;
	}

}

public class ConvertHashSet {

	public static void main(String[] args) {
		int n = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter max no of elements, repeated numbers will be omitted!");
		try {
			n = sc.nextInt();
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("That's not a number!\nThis execption occured\n" + e);
			System.exit(1);
		}

		MyHashSet setobj = new MyHashSet(n);
		setobj.setHashSet(sc);

		HashSet<Integer> set = new HashSet<Integer>();
		set = setobj.getHashSet();
		System.out.println("Hashset: ");
		for (Integer s : set) {
			System.out.print(s + " ");
		}
		System.out.println();

		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		treeSet = setobj.converToTreeSet();

		System.out.println("TreeSet: ");
		for (Integer ts : treeSet) {
			System.out.print(ts + " ");
		}

		sc.close();
	}
}
