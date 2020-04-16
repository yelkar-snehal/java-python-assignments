package com.example.myfilereader;

import java.io.File;

public class DemoMyFileReader {
	public static void main(String[] args) {

		if (0 == args.length) {
			System.out.println("No argument provided!");
			System.exit(1);
		}

		File file = new File(args[0]);

		// check if provided arg is dir
		if (!file.isDirectory()) {
			System.out.println("Provided argument isn't a valid directory!");
			System.exit(1);
		}

		MyFileReader obj = new MyFileReader(file);
		obj.mapFiles();
		obj.displayFiles();
		obj.displayFiles(true);
	}
}
