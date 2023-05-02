package demo.springboot.files.storage.tester.helper.writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class TempFileService {

	public File createTempFile(String fileName) {
		String osTmpDir = System.getProperty("java.io.tmpdir");
		try {
			String fileName2 = fileName + "." + UUID.randomUUID().toString();
			Path temp = Files.createTempFile(fileName2, ".txt");
			return temp.toFile();
		} catch (IOException e) {
			throw new RuntimeException("Fail to create new temp file: " + fileName + ", at dir = " + osTmpDir);
		}
	}
}
