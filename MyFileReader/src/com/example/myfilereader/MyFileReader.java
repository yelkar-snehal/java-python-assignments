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
	File dirPath;
	ArrayList<File> files;
	HashMap<String, Long> mp;

	// constructor to initialize path to directory
	public MyFileReader(File dirPath) {
		this.dirPath = dirPath;
		files = new ArrayList<File>();
		mp = new HashMap<String, Long>();
	}

	// sets the list of files including directories
	public void setFiles(File path) {
		File[] arrFiles = path.listFiles();
		for (File file : arrFiles) {
			if (!files.contains(file) && !file.isDirectory()) {
				files.add(file);
			}
		}
	}

	public ArrayList<File> getFiles() {
		Collections.sort(files);
		return files;
	}

	// get file size default bytes
	public long getFileSize(File file) {
		return file.length();
	}

	public ArrayList<Long> getFileSizes() {
		ArrayList<Long> fileSizes = new ArrayList<Long>();
		for (File file : files) {
			fileSizes.add(getFileSize(file));
		}
		Collections.sort(fileSizes);
		return fileSizes;
	}

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
				mp.put(file.getAbsolutePath() + " " + file.getName(), getFileSize(file));
			}
		}
	}

	public void mapFiles(File path) {

		// recursive call
		setFiles(path);
		File[] currentDir = path.listFiles();

		for (File file : currentDir) {
			if (file.isDirectory()) {
				// recursive traverse directory
				mapFiles(file);
			} else {
				mp.put(file.getAbsolutePath() + " " + file.getName(), getFileSize(file));
			}
		}

		// return mp;

	}

	public HashMap<String, Long> getMappedFiles() {
		return this.mp;
	}

	public void displayFiles() {
		// System.out.println(mp.size());
		if (0 != files.size()) {
			mp.forEach((file, s) -> System.out.println(file + " " + s));
		}

	}

	public HashMap<String, Long> getSortedFiles(HashMap<String, Long> hm) {
		List<Map.Entry<String, Long>> list = new LinkedList<Map.Entry<String, Long>>(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
			public int compare(Map.Entry<String, Long> obj1, Map.Entry<String, Long> obj2) {
				return (obj1.getValue()).compareTo(obj2.getValue());
			}
		});

		HashMap<String, Long> temp = new LinkedHashMap<String, Long>();
		for (Map.Entry<String, Long> map : list) {
			temp.put(map.getKey(), map.getValue());
		}
		return temp;
	}

	public void displayFiles(boolean ascending) {

		if (0 != files.size()) {

			HashMap<String, Long> sortedMap = getSortedFiles(this.mp);

			System.out.println("Displaying files in ascending order...");
			sortedMap.forEach((file, s) -> System.out.println(file + " " + s));

		}
	}

}
