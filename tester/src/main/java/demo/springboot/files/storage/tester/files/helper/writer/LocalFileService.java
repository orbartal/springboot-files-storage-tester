package demo.springboot.files.storage.tester.files.helper.writer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import demo.springboot.files.storage.tester.config.tempfile.TempFilePropties;
import demo.springboot.files.storage.tester.config.tempfile.TempFileProptiesProvider;

public class LocalFileService {

	private final TempFilePropties tempFilePropties = TempFileProptiesProvider.getTempFilePropties();
	private final TempFileService tempFileService = new TempFileService();
	private final FileTextWriter textWriter = new FileTextWriter();
	private final File dirTemp;

	public LocalFileService() {
		dirTemp = tempFileService.createTempDir(tempFilePropties.getS1Dir());
	}

	public File writeNewTextFile(int fileSize, String fileName) {
		String words1 = tempFilePropties.getTextWords();
		List<String> words2 = Arrays.asList(words1.split(",")).stream().collect(Collectors.toList());
		File out = tempFileService.createTempFile(dirTemp, fileName, ".txt");
		textWriter.writeWordsIntoFile(out, fileSize, words2);
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

	public File createTempFile(String fileName) {
		return tempFileService.createTempFile(dirTemp, fileName, ".tmp");
	}

	public void writeInputStreamToFile(File output, InputStream inputStream) {
		try {
			Files.copy(inputStream, output.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException("Fail to copy input stream into file: " + output, e);
		}
	}

	public long compareTwoTextFiles(File file1, File file2) {
		try {
			return Files.mismatch(file1.toPath(), file2.toPath());
		} catch (IOException e) {
			throw new RuntimeException("Fail to compare two text files. file1 = " + file1 + ", file2 = " + file2, e);
		}
	}

}
