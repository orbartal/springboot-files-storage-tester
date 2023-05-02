package demo.springboot.files.storage.tester.helper.config;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class TestConfig {

	private final Properties properties;

	public TestConfig(Properties properties2) {
		this.properties = properties2;
	}

	public String getServerBaseUrl() {
		return properties.get("target.base.url").toString();
	}

	public String getApiUploadFile() {
		return properties.get("target.api.upload").toString();
	}

	public String getApiDownloadFile() {
		return properties.get("target.api.download").toString();
	}

	public String getSmallTempFileDir() {
		return properties.get("test1.dir.s1").toString();
	}

	public List<String> getFileTextWords() {
		String text = properties.get("file.text.words").toString();
		return Arrays.asList(text.split(",")).stream().collect(Collectors.toList());
	}

}
