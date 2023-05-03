package demo.springboot.files.storage.tester.config.tempfile;

public class TempFilePropties {

	private final String s1Dir;
	private final String textWords;

	public TempFilePropties(String s1Dir, String textWords) {
		this.s1Dir = s1Dir;
		this.textWords = textWords;
	}

	public String getS1Dir() {
		return s1Dir;
	}

	public String getTextWords() {
		return textWords;
	}

}
