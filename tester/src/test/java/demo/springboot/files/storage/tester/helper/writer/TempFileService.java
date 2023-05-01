package demo.springboot.files.storage.tester.helper.writer;

import java.io.File;
import java.io.IOException;

public class TempFileService {
	
	public File createFileIfNotExists(String path) {
		File file = new File(path);
		if (!file.exists()) {
			try {file.createNewFile();} catch (IOException e) {}
		}
		return file;
	}


}
