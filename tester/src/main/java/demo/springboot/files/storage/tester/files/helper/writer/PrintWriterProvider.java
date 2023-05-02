package demo.springboot.files.storage.tester.files.helper.writer;

import java.io.File;
import java.util.List;

public class PrintWriterProvider {

	public static MyPrintWriter create(File file, List<String> words){
		try {
			return new MyPrintWriter(file, words);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
