
package demo.springboot.files.storage.tester.files.test;

import java.io.File;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import demo.springboot.files.storage.tester.files.helper.api.RemoteFileService;
import demo.springboot.files.storage.tester.files.helper.config.SizeEnum;
import demo.springboot.files.storage.tester.files.helper.writer.LocalFileService;
import demo.springboot.files.storage.tester.test.runner.TestFunction;

public class SingleFileApiTest implements TestFunction {

	private final LocalFileService localFileService;
	private final RemoteFileService remoteFileService;
	private final int fileSize;

	public SingleFileApiTest(SizeEnum size) {
		this.localFileService = new LocalFileService();
		this.remoteFileService = new RemoteFileService();
		this.fileSize = size.getValue();
	}

	@Test
	public void test() {
		File inputFile = localFileService.writeNewTextFile(fileSize, "test");
		UUID uid = remoteFileService.uploadFile(inputFile);
		File outputFile = remoteFileService.downloadFile(uid);
		long result = localFileService.compareTwoTextFiles(inputFile, outputFile);
		//Result is the index of first different bit. If non found should be -1.
		Assertions.assertEquals(-1L, result); 
	}

}
