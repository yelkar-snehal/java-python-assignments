import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.example.myfilereader.MyFileReader;

class MyFileReaderTest {

	@TempDir
	static File dirPath;

	static MyFileReader fileReaderObj;
	static File[] files;

	
	MyFileReaderTest() {
		fileReaderObj = new MyFileReader(dirPath);
		files = new File[2];
		
		File a = new File(dirPath, "demo.txt");
		try {
			if (a.createNewFile())
				files[0] = a;
		} catch (IOException e) {
			e.printStackTrace();
		}
		File b = new File(dirPath, "demoDir");
		if (b.mkdir()) {
			File c = new File(dirPath+File.separator+"demoDir", "demo2.txt");
			File d = new File(dirPath+File.separator+"demoDir", "demo3.csv");
			try {
				if (c.createNewFile() && d.createNewFile())
					files[1] = b;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	@Test
	void testGetFiles() {
		fileReaderObj.setFiles(dirPath);
		assertArrayEquals(files, fileReaderObj.getFiles());
	}

}
