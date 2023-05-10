package demo.springboot.files.storage.tester.files.helper.writer;

import java.io.File;
import java.util.List;


public class FileTextWriter {

	public void writeWordsIntoFile(File file, long sizeInBytes, List<String> words) {
		long numberOfRows = (sizeInBytes / 80)+1;
		try (MyPrintWriter writer = PrintWriterProvider.create(file, words)) {
			for (long k = 0; k<numberOfRows; k++) {
				writer.writeRandomLine(10);
			}
		}
	}

}
