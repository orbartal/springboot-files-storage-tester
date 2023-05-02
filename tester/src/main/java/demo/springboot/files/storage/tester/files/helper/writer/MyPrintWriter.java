package demo.springboot.files.storage.tester.files.helper.writer;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class MyPrintWriter extends PrintWriter implements AutoCloseable {

	private static final String UTF_8 = "UTF-8";

	private List<String> words;

	public MyPrintWriter(File file, List<String> words) throws Exception {
			super(file, UTF_8);
			this.words = words;
	}

	public void writeRandomLine(int wordsInLine) {
		for (int i = 0; i<wordsInLine; i++) {
			writeRandomWord();
		}
		this.println();
	}

	private void writeRandomWord() {
		int wordsMaxIndex = words.size()-1;
		int index = (int)(Math.random() * wordsMaxIndex);
		String w = words.get(index);
		this.print(w + " ");
	}

}