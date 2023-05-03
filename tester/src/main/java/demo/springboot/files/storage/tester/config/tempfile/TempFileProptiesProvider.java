package demo.springboot.files.storage.tester.config.tempfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

//An ugly but working work around to set config properties.
@Component
public class TempFileProptiesProvider {

	private static final Logger logger = LoggerFactory.getLogger(TempFileProptiesProvider.class);

	private static TempFilePropties tempFilePropties;

	@Value("${test1.dir.s1}")
	private String s1Dir;

	@Value("${file.text.words}")
	private String textWords;

	@PostConstruct
	private void init() {
		tempFilePropties = new TempFilePropties(s1Dir, textWords);
		logger.info("TempFileProptiesProvider.tempFilePropties = " + tempFilePropties);
	}

	public static TempFilePropties getTempFilePropties() {
		return tempFilePropties;
	}

}
