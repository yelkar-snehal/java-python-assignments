package com.example.myfilereader;

import java.io.File;

public class DemoMyFileReader {

	public static void main(String[] args) throws Exception {

		// check whether file path is provided
		// exit the program if no argument is provided
		if (0 == args.length) {
			// System.out.println("No argument provided!");
			// System.exit(1);
			throw new Exception("No argument provided");
		}

		File file = new File(args[0]);

		// check if provided argument is a directory
		if (!file.isDirectory()) {
			// System.out.println("Provided argument isn't a valid directory!");
			// System.exit(1);
			throw new NullPointerException("Provided argument isn't a valid directory!");
		}

		// create an object of MyFileReader class
		MyFileReader obj = new MyFileReader(file);

		// mapping is necessary as the resulted
		// hashmap is used for all operations
		obj.mapFiles();

		// obj.displayFiles();

		// display files in ascending order
		obj.displayFiles(true);

		// create an object of MyFileReader class
		MyFileScanner obj1 = new MyFileScanner(file);

		// check if given sequence is present in any file
		try {
			obj1.displayScanFiles(args[1], args[2]);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Please provide the word to be scanned and file extension!");
		}

	}
}
