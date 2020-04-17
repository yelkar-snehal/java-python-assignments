package com.example.myfilereader;

import java.io.File;

public class DemoMyFileReader {

	public static void main(String[] args) {

		// check whether file path is provided
		// exit the program if no argument is provided
		if (0 == args.length) {
			System.out.println("No argument provided!");
			System.exit(1);
		}

		File file = new File(args[0]);

		// check if provided argument is a directory
		if (!file.isDirectory()) {
			System.out.println("Provided argument isn't a valid directory!");
			System.exit(1);
		}

		// create an object of MyFileReader class
		MyFileReader obj = new MyFileReader(file);

		// mapping is necessary as the resulted
		// hashmap is used for all operations
		obj.mapFiles();

		// obj.displayFiles();

		// display files in ascending order
		obj.displayFiles(true);

		// check if given sequence is present in any file
		obj.displayScanFiles("hello", "txt");

	}
}
