package demo.springboot.files.storage.tester.config.target;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

//An ugly but working work around to set config properties.
@Component
public class TargetProptiesProvider {

	private static final Logger logger = LoggerFactory.getLogger(TargetProptiesProvider.class);

	private static TargetPropties targetPropties;

	@Value("${target.base.url}")
	private String targetBseUrl;

	@Value("${target.api.hello}")
	private String targetApiHello;

	@Value("${target.api.upload}")
	private String targetApiUpload;

	@Value("${target.api.download}")
	private String targetApiDownload;

	@PostConstruct
	private void init() {
		targetPropties = new TargetPropties(targetBseUrl, targetApiHello, targetApiUpload, targetApiDownload);
		logger.info("TargetProptiesProvider.targetPropties = " + targetPropties);
	}

	public static TargetPropties getTargetPropties() {
		return targetPropties;
	}

}
