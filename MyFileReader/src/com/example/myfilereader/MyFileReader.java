package com.example.myfilereader;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class MyFileReader {
	// class variables common to most methods
	File dirPath;
	File[] files;
	HashMap<Long, String> mp;

	// constructor to initialize path to directory
	public MyFileReader(File dirPath) {
		this.dirPath = dirPath;
		mp = new HashMap<Long, String>();
	}

	// sets the list of files including directories
	public void setFiles(File path) {
		files = path.listFiles();
	}

	public File[] getFiles() {
		Arrays.sort(files);
		return files;
	}

	// get file size default bytes
	public long getFileSize(File file) {
		return (file.length() / (1024));
	}

	public void mapFiles() {

		// 1st call
		setFiles(dirPath);
		// files = getFiles();

		// check if directory is empty
		if (0 == files.length) {
			System.out.println("Empty directory!");
		}

		for (File file : files) {
			if (file.isDirectory()) {
				// recursive traverse directory
				mapFiles(file);
			} else {
				mp.put(getFileSize(file), file.getAbsolutePath() + " " + file.getName());
			}
		}
	}

	public void mapFiles(File path) {

		// recursive call
		setFiles(path);
		files = getFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				// recursive traverse directory
				mapFiles(file);
			} else {
				mp.put(getFileSize(file), file.getAbsolutePath() + " " + file.getName());
			}
		}

		// return mp;

	}

	public void displayFiles() {
		System.out.println(mp.size());
		if (0 != files.length) {
			mp.forEach((s, file) -> System.out.println(file + " " + s));
		}

	}

	public TreeMap<Long, String> getSortedFiles(boolean ascending) {
		TreeMap<Long, String> treeMap = null;
		if (0 != files.length) {
			if (ascending) {
				treeMap = new TreeMap<Long, String>(mp);
			} else {
				treeMap = new TreeMap<Long, String>(Collections.reverseOrder());
				treeMap.putAll(mp);
			}
		}

		return treeMap;
	}

	public void displayFiles(boolean ascending) {

		if (0 != files.length) {

			TreeMap<Long, String> treeMap = getSortedFiles(ascending);

			if (ascending) {
				System.out.println("Displaying files in ascending order...");
				treeMap.forEach((s, file) -> System.out.println(file + " " + s));
			} else {
				// prints in reverse order of file size
				System.out.println("Displaying files in descending order...");
				treeMap.forEach((s, file) -> System.out.println(file + " " + s));
			}
		}
	}

}
