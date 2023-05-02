package demo.springboot.files.storage.tester.files.helper.config;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

	public static Properties loadProperties(String pathToConfig) {
		ClassLoader classLoader = ConfigProvider.class.getClassLoader();
		try (InputStream input = classLoader.getResourceAsStream(pathToConfig)) {
			if (input == null) {
				throw new RuntimeException("Error, unable to find config.properties");
			}
			Properties properties = new Properties();
			properties.load(input);
			return properties;
		} catch (Exception ex) {
			throw new RuntimeException("Error, unable to load config.properties");
		}
	}

}
