package com.example.myfilereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyFileReader {

	// class variables common to most methods

	// to store root directory path
	File dirPath;

	// to store all available files excluding directories
	ArrayList<File> files;

	// to store mapped filename, path and sizes
	HashMap<String, Long> mp;

	// constructor to initialize path to directory
	public MyFileReader(File dirPath) {
		this.dirPath = dirPath;
		files = new ArrayList<File>();
		mp = new HashMap<String, Long>();
	}

	// set the list of all files excluding directories
	public void setFiles(File path) {
		File[] arrFiles = path.listFiles();
		for (File file : arrFiles) {
			if (!files.contains(file) && !file.isDirectory()) {
				files.add(file);
			}
		}
	}

	// get the sorted list of all stored files
	public ArrayList<File> getFiles() {
		Collections.sort(files);
		return files;
	}

	// get file size
	// default bytes
	public long getFileSize(File file) {
		return file.length();
	}

	// get file sizes for all stored files
	// return sorted array list of sizes
	public ArrayList<Long> getFileSizes() {
		ArrayList<Long> fileSizes = new ArrayList<Long>();
		for (File file : files) {
			fileSizes.add(getFileSize(file));
		}
		Collections.sort(fileSizes);
		return fileSizes;
	}

	// store file name, path and size in a hashmap
	// invoked at 1st recursive call
	// take root directory's path as no input is provided
	public void mapFiles() {
		// 1st call
		setFiles(dirPath);
		// files = getFiles();
		File[] currentDir = dirPath.listFiles();

		// check if directory is empty
		if (0 == files.size()) {
			System.out.println("Empty directory!");
		}

		for (File file : currentDir) {
			if (file.isDirectory()) {
				// recursive traverse directory
				mapFiles(file);
			} else {
				// add to hashmap if file isn't of type dir
				mp.put(file.getAbsolutePath() + " " + file.getName(), getFileSize(file));
			}
		}
	}

	// overloaded method
	// invoked when a parameter of type File is passed
	// store file name, path and size in a hashmap
	public void mapFiles(File path) {
		// recursive call
		setFiles(path);
		File[] currentDir = path.listFiles();

		for (File file : currentDir) {
			if (file.isDirectory()) {
				// recursive traverse directory
				mapFiles(file);
			} else {
				// add to hashmap if file isn't of type dir
				mp.put(file.getAbsolutePath() + " " + file.getName(), getFileSize(file));
			}
		}
	}

	// get mapped file data
	public HashMap<String, Long> getMappedFiles() {
		return this.mp;
	}

	// print file data in any order
	public void displayFiles() {
		// System.out.println(mp.size());

		// iterate over map if the same isn't empty
		if (0 != files.size()) {
			mp.forEach((file, s) -> System.out.println(file + " " + s));
		}

	}

	// sort hashmap by values
	// sorts mapped data by file size
	public HashMap<String, Long> getSortedFiles(HashMap<String, Long> hm) {
		// get list from hashmap
		List<Map.Entry<String, Long>> list = new LinkedList<Map.Entry<String, Long>>(hm.entrySet());

		// sort list by values
		Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
			public int compare(Map.Entry<String, Long> obj1, Map.Entry<String, Long> obj2) {
				return (obj1.getValue()).compareTo(obj2.getValue());
			}
		});

		// copy list to another hashmap
		HashMap<String, Long> temp = new LinkedHashMap<String, Long>();
		for (Map.Entry<String, Long> map : list) {
			temp.put(map.getKey(), map.getValue());
		}
		return temp;
	}

	// print file data in ascending order of file size
	public void displayFiles(boolean ascending) {

		if (0 != files.size()) {

			HashMap<String, Long> sortedMap = getSortedFiles(this.mp);

			System.out.println(
					"---------------------------------------------------------------------------------------------");
			System.out.println("Displaying files in ascending order...");
			sortedMap.forEach((file, s) -> {
				// splits path and filename
				String[] nameAndPath = file.split(" ");

				System.out.println("\nFilename: " + nameAndPath[1] + "\nPath: " + nameAndPath[0] + "\nSize: " + s
						+ " bytes or " + s / 1024 + " kB");
			});
			System.out.println(
					"---------------------------------------------------------------------------------------------");

		}
	}

	// get file's extension
	public String getFileExtension(String name) {
		String ext = "";

		// ignore .files and files not having '.'
		if (0 != name.lastIndexOf('.') && -1 != name.lastIndexOf('.')) {
			// get string starting after .
			ext = name.substring(name.lastIndexOf('.') + 1);
		}

		return ext;
	}

	// get mapped file data provided the file type
	public HashMap<String, Long> filterFiles(String ext) {
		HashMap<String, Long> filteredFiles = new HashMap<String, Long>();

		mp.forEach((file, s) -> {
			// splits path and filename
			String[] pathAndName = file.split(" ");

			// get file extensions of all mapped files
			// compare with provided extension
			if (ext.equals(getFileExtension(pathAndName[1]))) {
				// add to filtered op if extension matches
				filteredFiles.put(file, s);
			}
		});

		// sort in ascending order
		return getSortedFiles(filteredFiles);

	}

	// search files for a particular sequence
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
		System.out.printf("The word '%s' occured in these files: \n", word);
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
