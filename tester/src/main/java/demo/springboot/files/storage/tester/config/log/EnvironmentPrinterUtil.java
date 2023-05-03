package demo.springboot.files.storage.tester.config.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

public class EnvironmentPrinterUtil {

	private static final Logger logger = LoggerFactory.getLogger(EnvironmentPropertiesPrinter.class);

	public static void logEnvironment(Environment env, String title) {
		logger.info("************************* Start " + title + " ******************************");
		logProperty(env, "server.port");
		logProperty(env, "target.base.url");
		logProperty(env, "target.api.hello");
		logProperty(env, "target.api.upload");
		logProperty(env, "target.api.download");
		logProperty(env, "test1.dir.s1");
		logProperty(env, "file.text.words");
		logger.info("************************* end " + title + " ******************************");
	}

	private static void logProperty(Environment env, String property) {
		logger.info("{}={}", property, env.getProperty(property));
	}

	public static void logConfigurableEnvironment(ConfigurableEnvironment env, String title) {
		logger.info("************************* Start " + title + " ******************************");
		env.getPropertySources().forEach(i -> logger.info("" + i));
		logger.info("************************* end " + title + " ******************************");
	}
	
	public static void logCommandLineRunner(String title) {
		logger.info("************************* Start " + title + " ******************************");
		logger.info("************************* end " + title + " ******************************");
	}
	
	public static void logApplicationRunner (String title) {
		logger.info("************************* Start " + title + " ******************************");
		logger.info("************************* end " + title + " ******************************");
	}

}
