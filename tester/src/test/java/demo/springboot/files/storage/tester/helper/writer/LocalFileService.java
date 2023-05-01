package demo.springboot.files.storage.tester.helper.writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import demo.springboot.files.storage.tester.helper.config.ConfigProvider;

public class LocalFileService {

	private static final int KB1 = 1000;
	private static final String PATH_TO_SMALL_FILE = ConfigProvider.get().getPathToSmallFile();
	private static final List<String> WEEK_DAYS = ConfigProvider.get().getFileTextWords();

	private final TempFileService tempFileService = new TempFileService();
	private final FileTextWriter textWriter = new FileTextWriter();

	public File writeNewSmallTextFile() {
		File out = tempFileService.createFileIfNotExists(PATH_TO_SMALL_FILE);
		textWriter.writeWordsIntoFile(out, KB1, WEEK_DAYS);
		return out;
	}

	public String readAllTextInFile(File input) {
		try {
			byte[] uploadFileBytes = Files.readAllBytes(input.toPath());
			return new String(uploadFileBytes);
		} catch (IOException e) {
			throw new RuntimeException("Fail to read text from file: " + input);
		}
	}

}
