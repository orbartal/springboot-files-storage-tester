package demo.springboot.files.storage.tester.files.helper.writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import demo.springboot.files.storage.tester.config.tempfile.TempFilePropties;
import demo.springboot.files.storage.tester.config.tempfile.TempFileProptiesProvider;

public class LocalFileService {

	private static final int KB1 = 1000;

	private final TempFilePropties tempFilePropties = TempFileProptiesProvider.getTempFilePropties();
	private final TempFileService tempFileService = new TempFileService();
	private final FileTextWriter textWriter = new FileTextWriter();
	private final File dirTemp;

	public LocalFileService() {
		dirTemp = tempFileService.createTempDir(tempFilePropties.getS1Dir());
	}

	public File writeNewSmallTextFile(String fileName) {
		String words1 = tempFilePropties.getTextWords();
		List<String> words2 = Arrays.asList(words1.split(",")).stream().collect(Collectors.toList());
		File out = tempFileService.createTempFile(dirTemp, fileName, ".txt");
		textWriter.writeWordsIntoFile(out, KB1, words2);
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
