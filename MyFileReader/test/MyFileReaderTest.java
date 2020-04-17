import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.myfilereader.MyFileReader;

class MyFileReaderTest {

	public File dirPath;

	public MyFileReader fileReaderObj;
	public ArrayList<File> files;

	@BeforeEach
	public void setUp() {

		files = new ArrayList<File>();
		dirPath = new File("/home/synerzip/Documents/demo");
		// array all of files in dirPath includes nested
		File[] allFiles = { new File("/home/synerzip/Documents/demo/demo.txt"),
				new File("/home/synerzip/Documents/demo/block.c"), new File("/home/synerzip/Documents/demo/mexe"),
				new File("/home/synerzip/Documents/demo/csv/TestTakers.csv"),
				new File("/home/synerzip/Documents/demo/csv/MarksScored.csv"),
				new File("/home/synerzip/Documents/demo/csv/Analysis.csv"),
				new File("/home/synerzip/Documents/demo/csv/hello.txt") };

		Collections.addAll(files, allFiles);

		// get sorted files to compare
		Collections.sort(files);
		fileReaderObj = new MyFileReader(dirPath);
		fileReaderObj.mapFiles();
	}

	@Test
	public void testGetFiles() {
		fileReaderObj.setFiles(dirPath);
		assertEquals(files, fileReaderObj.getFiles());
	}

	// @ParameterizedTest
	// @ValueSource(longs = {files[0].length(), files[1].length()})
	@Test
	public void testGetFileSizes() {
		Long[] arrfileSizes = { (long) 54, (long) 71, (long) 97, (long) 6708, (long) 8304, (long) 14206, (long) 64517 };
		ArrayList<Long> fileSizes = new ArrayList<Long>();
		Collections.addAll(fileSizes, arrfileSizes);
		assertEquals(fileSizes, fileReaderObj.getFileSizes());
	}

	@Test
	public void testGetSortedFiles() {
		// hashmap of sorted files by size
		HashMap<String, Long> map = new HashMap<String, Long>();
		map.put("/home/synerzip/Documents/demo/csv/hello.txt hello.txt", (long) 54);
		map.put("/home/synerzip/Documents/demo/demo.txt demo.txt", (long) 71);
		map.put("/home/synerzip/Documents/demo/block.c block.c", (long) 97);
		map.put("/home/synerzip/Documents/demo/csv/MarksScored.csv MarksScored.csv", (long) 6708);
		map.put("/home/synerzip/Documents/demo/mexe mexe", (long) 8304);
		map.put("/home/synerzip/Documents/demo/csv/TestTakers.csv TestTakers.csv", (long) 14206);
		map.put("/home/synerzip/Documents/demo/csv/Analysis.csv Analysis.csv", (long) 64517);

		assertEquals(map, fileReaderObj.getSortedFiles(fileReaderObj.getMappedFiles()));

	}

	@Test
	public void testFilterFiles() {
		// hashmap of filtered files by provided extension
		HashMap<String, Long> map = new HashMap<String, Long>();
		map.put("/home/synerzip/Documents/demo/csv/hello.txt hello.txt", (long) 54);
		map.put("/home/synerzip/Documents/demo/demo.txt demo.txt", (long) 71);

		assertEquals(map, fileReaderObj.filterFiles("txt"));
	}

	@Test
	public void testScanFiles() {
		// hashmaps of scanned files for given extension and sequence
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		ArrayList<Integer> lineNumbers1 = new ArrayList<Integer>();
		lineNumbers1.add(2);
		lineNumbers1.add(4);
		lineNumbers1.add(5);
		lineNumbers1.add(6);
		ArrayList<Integer> lineNumbers2 = new ArrayList<Integer>();
		lineNumbers2.add(1);
		lineNumbers2.add(2);
		lineNumbers2.add(4);
		lineNumbers2.add(5);
		lineNumbers2.add(6);
		map.put("/home/synerzip/Documents/demo/csv/hello.txt hello.txt 54", lineNumbers2);
		map.put("/home/synerzip/Documents/demo/demo.txt demo.txt 71", lineNumbers1);

		assertEquals(map, fileReaderObj.scanFiles("hello", "txt"));
	}

}
