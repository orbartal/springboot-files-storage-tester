package demo.springboot.files.storage.tester.files.helper.config;

import java.util.Properties;

public class ConfigProvider {

	private static final String CONFIG_FILE = "application.properties";
	private static final Properties properties = PropertiesLoader.loadProperties(CONFIG_FILE);
	private static final TestConfig instance = new TestConfig(properties);

	public static TestConfig get() {
		return instance;
	}

}
