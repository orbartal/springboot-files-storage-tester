package demo.springboot.files.storage.tester.files.helper.writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempFileService {

	public File createTempDir(String dirName) {
		String osTmpDir = System.getProperty("java.io.tmpdir");
		try {
			Path temp = Files.createTempDirectory(Path.of(osTmpDir), dirName);
			return temp.toFile();
		} catch (IOException e) {
			throw new RuntimeException("Fail to create new temp dir: " + dirName + ", at dir = " + osTmpDir);
		}
	}

	public File createTempFile(File dir, String fileName, String suffix) {
		String osTmpDir = System.getProperty("java.io.tmpdir");
		try {
			Path temp = Files.createTempFile(dir.toPath(), fileName, suffix);
			return temp.toFile();
		} catch (IOException e) {
			throw new RuntimeException("Fail to create new temp file: " + fileName + ", at dir = " + osTmpDir);
		}
	}
}
