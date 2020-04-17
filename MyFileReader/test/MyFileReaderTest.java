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
		File[] allFiles = { new File("/home/synerzip/Documents/demo/demo.txt"),
				new File("/home/synerzip/Documents/demo/block.c"), new File("/home/synerzip/Documents/demo/mexe"),
				new File("/home/synerzip/Documents/demo/csv/TestTakers.csv"),
				new File("/home/synerzip/Documents/demo/csv/MarksScored.csv"),
				new File("/home/synerzip/Documents/demo/csv/Analysis.csv") };

		Collections.addAll(files, allFiles);
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
		Long[] arrfileSizes = { (long) 14, (long) 97, (long) 6708, (long) 8304, (long) 14206, (long) 64517 };
		ArrayList<Long> fileSizes = new ArrayList<Long>();
		Collections.addAll(fileSizes, arrfileSizes);
		assertEquals(fileSizes, fileReaderObj.getFileSizes());
	}

	@Test
	public void testGetSortedFiles() {
		HashMap<String, Long> map = new HashMap<String, Long>();
		map.put("/home/synerzip/Documents/demo/demo.txt demo.txt", (long) 14);
		map.put("/home/synerzip/Documents/demo/block.c block.c", (long) 97);
		map.put("/home/synerzip/Documents/demo/csv/MarksScored.csv MarksScored.csv", (long) 6708);
		map.put("/home/synerzip/Documents/demo/mexe mexe", (long) 8304);
		map.put("/home/synerzip/Documents/demo/csv/TestTakers.csv TestTakers.csv", (long) 14206);
		map.put("/home/synerzip/Documents/demo/csv/Analysis.csv Analysis.csv", (long) 64517);

		assertEquals(map, fileReaderObj.getSortedFiles(fileReaderObj.getMappedFiles()));

	}

}
