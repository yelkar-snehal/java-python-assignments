package com.example.myfilereader;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

class MyFileReader {
	// class  variables common to most methods
	File dirPath;
	File[] files;
	HashMap<String, Long> mp;
	
	// constructor to initialize path to directory
	public MyFileReader(File dirPath) {
		this.dirPath = dirPath;
		mp = new HashMap<String, Long>();
	}
	
	// sets the list of files including directories
	public void setFiles(File path) {
		files = path.listFiles();
	}
	
	public File[] getFiles() {
		return files;
	}
	
	// get file size  default bytes
	public long getFileSize(File file) {
		return (file.length() / (1024));
	}
	
	public void mapFiles() {
		
		//1st ca;;
		setFiles(dirPath);
		// files = getFiles();
		
		for(File file: files) {
			if(file.isDirectory()) {
				//recursive traverse directory
				mapFiles(file);
			}
			else {
				mp.put(file.getAbsolutePath() + " " + file.getName(), getFileSize(file));
			}
		}
	}

	private void mapFiles(File path) {
		
		//recursive call
		setFiles(path);
		files = getFiles();
		
		for(File file: files) {
			if(file.isDirectory()) {
				//recursive traverse directory
				mapFiles(file);
			}
			else {
				mp.put(file.getAbsolutePath() + " " + file.getName(), getFileSize(file));
			}
		}
	}
	
	public void displayFiles() {
		mp.forEach((file, s) -> System.out.println(file + " " + s));
	}
	
	public void displayFiles(boolean ascending) {
		
		TreeMap<String, Long> treeMap;
		if(ascending) {
			treeMap = new TreeMap<String, Long>(mp);
			System.out.println("Displaying files in ascending order...");
			treeMap.forEach((file, s) -> System.out.println(file + " " + s));
		}
		else {
			// prints in reverse order of file size
			treeMap = new TreeMap<String, Long>(Collections.reverseOrder());
			treeMap.putAll(mp);
			System.out.println("Displaying files in descending order...");
			treeMap.forEach((file, s) -> System.out.println(file + " " + s));
		}
	}
	
}

public class MyFileReaderDemo {
	
	public static void main(String[] args) {
		
		MyFileReader obj = new MyFileReader(new File(args[0]));
		obj.mapFiles();
		obj.displayFiles();
		obj.displayFiles(true);
	}

}
