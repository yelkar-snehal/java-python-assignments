package mypackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	public static String displayFileContents(File file) {
		String fileContents = "";
		Scanner sc;

		// create scanner obj of file
		try {
			sc = new Scanner(file);
			// iterate over scanner object to
			// append file contents
			while (sc.hasNextLine()) {
				fileContents += sc.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}

		return fileContents;
	}

	public static void main(String[] args) {

		String filePath = "";

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter path to a file");
		filePath = sc.nextLine();

		System.out.println("File Contents: \n" + displayFileContents(new File(filePath)));

		// close resources
		sc.close();

	}
}
