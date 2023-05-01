package demo.springboot.files.storage.tester.helper.config;

import java.io.File;
import java.nio.file.FileSystems;

public class ConfigurationPath {

	private static final String PATH_TO_FILES = getPathToTestFiles();

	private static String getPathToTestFiles() {
		String path = "src/test/resources";
		File file = new File(path);
		return file.getAbsolutePath();
	}

	public static String getFilePath(String filename) {
		return PATH_TO_FILES + FileSystems.getDefault().getSeparator() + filename;
	}

}
