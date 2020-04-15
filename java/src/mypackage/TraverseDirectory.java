package mypackage;

import java.io.File;
import java.util.Scanner;

public class TraverseDirectory {

	public static void traverseDir(File dirPath) {

		try {

			// get all files including directories
			File[] files = dirPath.listFiles();

			// iterate over files array
			// to display files recursively
			for (File file : files) {
				if (file.isDirectory()) {
					traverseDir(file);
				} else {
					System.out.println(file.getName());
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Invalid path given.\nThis exception occured" + e);
		}
	}

	public static void main(String[] args) {

		String dirPath = "";

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter path to a directory");
		dirPath = sc.nextLine();

		traverseDir(new File(dirPath));

		// close resources
		sc.close();

	}
}
