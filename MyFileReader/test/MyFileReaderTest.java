import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.example.myfilereader.MyFileReader;

class MyFileReaderTest {

	@TempDir
	public File dirPath;

	public MyFileReader fileReaderObj;
	public File[] files;

	@BeforeEach
	public void setUp() {
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
			File c = new File(dirPath + File.separator + "demoDir", "demo2.txt");
			File d = new File(dirPath + File.separator + "demoDir", "demo3.csv");
			try {
				if (c.createNewFile() && d.createNewFile())
					files[1] = b;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	@Test
	public void testGetFiles() {
		fileReaderObj.setFiles(dirPath);
		assertArrayEquals(files, fileReaderObj.getFiles());
	}

	// @ParameterizedTest
	// @ValueSource(longs = {files[0].length(), files[1].length()})
	@Test
	public void testGetFileLengths() {
		for (File file : files) {
			// System.out.println(file);
			assertEquals((file.length() / 1024), fileReaderObj.getFileSize(file));
		}
	}

}
