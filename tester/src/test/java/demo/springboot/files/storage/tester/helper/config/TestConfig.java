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

	public String getPathToSmallFile() {
		return getPath("test1.words.s1");
	}

	public List<String> getFileTextWords() {
		String text = properties.get("file.text.words").toString();
		return Arrays.asList(text.split(",")).stream().collect(Collectors.toList());
	}

	private String getPath(String key) {
		String filename = properties.get(key).toString();
		return ConfigurationPath.getFilePath(filename);
	}

	

}
