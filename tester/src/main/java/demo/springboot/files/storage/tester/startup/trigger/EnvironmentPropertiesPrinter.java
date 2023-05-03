package demo.springboot.files.storage.tester.startup.trigger;


import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import demo.springboot.files.storage.tester.startup.util.EnvironmentPrinterUtil;
import jakarta.annotation.PostConstruct;

@Component
public class EnvironmentPropertiesPrinter {
	private final Environment env;

	public EnvironmentPropertiesPrinter(Environment env) {
		this.env = env;
	}

	@PostConstruct
	public void logApplicationProperties() {
		EnvironmentPrinterUtil.logEnvironment(env, "EnvironmentPropertiesPrinter.logApplicationProperties");
	}
}