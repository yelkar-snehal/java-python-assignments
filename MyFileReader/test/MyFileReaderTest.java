import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class MyFileReaderTest {
	
	@TempDir
	static File dirPath;
	
	@Test
	void testCreateFile() {
		// System.out.println(dirPath.getAbsolutePath());
		File a = new File(dirPath, "demo.txt");
		try {
			assertTrue(a.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testCreateDir() {
		File b = new File(dirPath, "demoDir");
		assertTrue(b.mkdir());
	}
}
