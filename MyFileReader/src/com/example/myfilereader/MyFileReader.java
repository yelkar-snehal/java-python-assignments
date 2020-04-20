package com.example.myfilereader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyFileReader {

	// class variables common to most methods

	// to store root directory path
	File directoryPath;

	// to store all available allFilesList excluding directories
	ArrayList<File> allFilesList;

	// to store mapped filename, path and sizes
	HashMap<String, Long> mappedFiles;

	// constructor to initialize path to directory
	public MyFileReader(File directoryPath) {
		this.directoryPath = directoryPath;
		allFilesList = new ArrayList<File>();
		mappedFiles = new HashMap<String, Long>();
	}

	// set the list of all allFilesList excluding directories
	public void setFiles(File path) {
		File[] arrFiles = path.listFiles();
		for (File file : arrFiles) {
			if (!allFilesList.contains(file) && !file.isDirectory()) {
				allFilesList.add(file);
			}
		}
	}

	// get the sorted list of all stored allFilesList
	public ArrayList<File> getFiles() {
		Collections.sort(allFilesList);
		return allFilesList;
	}

	// get file size
	// default bytes
	public long getFileSize(File file) {
		return file.length();
	}

	// get file sizes for all stored allFilesList
	// return sorted array list of sizes
	public ArrayList<Long> getFileSizes() {
		ArrayList<Long> fileSizes = new ArrayList<Long>();
		for (File file : allFilesList) {
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
		setFiles(directoryPath);
		// allFilesList = getFiles();
		File[] currentDir = directoryPath.listFiles();

		// check if directory is empty
		if (0 == allFilesList.size()) {
			System.out.println("Empty directory!");
		}

		for (File file : currentDir) {
			if (file.isDirectory()) {
				// recursive traverse directory
				mapFiles(file);
			} else {
				// add to hashmap if file isn't of type dir
				mappedFiles.put(file.getAbsolutePath() + " " + file.getName(), getFileSize(file));
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
				mappedFiles.put(file.getAbsolutePath() + " " + file.getName(), getFileSize(file));
			}
		}
	}

	// get mapped file data
	public HashMap<String, Long> getMappedFiles() {
		return this.mappedFiles;
	}

	// print file data in any order
	public void displayFiles() {
		// System.out.println(mappedFiles.size());

		// iterate over map if the same isn't empty
		if (0 != allFilesList.size()) {
			mappedFiles.forEach((file, s) -> System.out.println(file + " " + s));
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

		if (0 != allFilesList.size()) {

			HashMap<String, Long> sortedMap = getSortedFiles(this.mappedFiles);

			System.out.println(
					"---------------------------------------------------------------------------------------------");
			System.out.println("Displaying allFilesList in ascending order...");
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

}
