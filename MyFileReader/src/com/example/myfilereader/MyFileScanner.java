package com.example.myfilereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MyFileScanner extends MyFileReader {

	public MyFileScanner(File directoryPath) {
		super(directoryPath);
		super.mapFiles();
	}

	// get file's extension
	public String getFileExtension(String name) {
		String ext = "";

		// ignore .allFilesList and allFilesList not having '.'
		if (0 != name.lastIndexOf('.') && -1 != name.lastIndexOf('.')) {
			// get string starting after .
			ext = name.substring(name.lastIndexOf('.') + 1);
		}

		return ext;
	}

	// get mapped file data provided the file type
	public HashMap<String, Long> filterFiles(String ext) {
		HashMap<String, Long> filteredFiles = new HashMap<String, Long>();

		mappedFiles.forEach((file, s) -> {
			// splits path and filename
			String[] pathAndName = file.split(" ");

			// get file extensions of all mapped allFilesList
			// compare with provided extension
			if (ext.equals(getFileExtension(pathAndName[1]))) {
				// add to filtered op if extension matches
				filteredFiles.put(file, s);
			}
		});

		// sort in ascending order
		return getSortedFiles(filteredFiles);

	}

	// search allFilesList for a particular sequence
	// takes sequence and file type as input
	// returns file data along with the line numbers,
	// where the sequence occurs
	public HashMap<String, ArrayList<Integer>> scanFiles(String word, String ext) {
		HashMap<String, ArrayList<Integer>> scannedFiles = new HashMap<String, ArrayList<Integer>>();

		// get sorted map for provided extension
		HashMap<String, Long> filteredFiles = filterFiles(ext);

		filteredFiles.forEach((file, s) -> {
			// splits path and filename
			String[] pathAndName = file.split(" ");

			int count = 0;
			Scanner sc;
			try {
				sc = new Scanner(new File(pathAndName[0]));
				// generate new arraylist for each file
				ArrayList<Integer> lineNumbers = new ArrayList<Integer>();

				// iterate till last line in the file
				while (sc.hasNextLine()) {
					// increment line number
					count++;

					// case insensitive search for provided sequence
					if (sc.nextLine().toLowerCase().contains(word.toLowerCase())) {
						// add line numbers to arraylist
						lineNumbers.add(count);
						// add file
						scannedFiles.put(file + " " + s, lineNumbers);
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		return scannedFiles;
	}

	// print search results in ascending order of file size
	public void displayScanFiles(String word, String ext) {

		HashMap<String, ArrayList<Integer>> scannedFiles = scanFiles(word, ext);

		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.printf("The word '%s' occured in these allFilesList: \n", word);
		if (0 == scannedFiles.size()) {
			System.out.println("No Search Results!");
		} else {
			scannedFiles.forEach((file, lines) -> {
				// splits path and filename
				String[] nameAndPath = file.split(" ");

				System.out.println("\nFilename: " + nameAndPath[1] + "\nPath: " + nameAndPath[0] + "\nLines: " + lines
						+ "\nSize: " + nameAndPath[2] + " bytes or " + Long.parseLong(nameAndPath[2]) / 1024 + " kB");
			});
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------");

	}

}
