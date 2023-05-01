package demo.springboot.files.storage.tester.helper.writer;

import java.io.File;
import java.util.List;


public class FileTextWriter {

	public void writeWordsIntoFile(File file, int sizeInBytes, List<String> words) {
		int numberOfRows = (sizeInBytes / 80)+1;
		try (MyPrintWriter writer = PrintWriterProvider.create(file, words)) {
			for (int k = 0; k<numberOfRows; k++) {
				writer.writeRandomLine(10);
			}
		}
	}

}
