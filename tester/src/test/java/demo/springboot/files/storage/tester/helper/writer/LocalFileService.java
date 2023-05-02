package demo.springboot.files.storage.tester.helper.writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import demo.springboot.files.storage.tester.helper.config.ConfigProvider;

public class LocalFileService {

	private static final int KB1 = 1000;
	private static final String SMALL_FILE_DIR = ConfigProvider.get().getSmallTempFileDir();
	private static final List<String> WEEK_DAYS = ConfigProvider.get().getFileTextWords();

	private final TempFileService tempFileService = new TempFileService();
	private final FileTextWriter textWriter = new FileTextWriter();

	private File dirTemp;

	public LocalFileService() {
		dirTemp = tempFileService.createTempDir(SMALL_FILE_DIR);
	}

	public File writeNewSmallTextFile() {
		File out = tempFileService.createTempFile(dirTemp, "test");
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
