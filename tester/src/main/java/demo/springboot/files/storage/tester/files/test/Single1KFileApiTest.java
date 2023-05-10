
package demo.springboot.files.storage.tester.files.test;

import java.io.File;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import demo.springboot.files.storage.tester.files.helper.api.RemoteFileService;
import demo.springboot.files.storage.tester.files.helper.config.SizeEnum;
import demo.springboot.files.storage.tester.files.helper.writer.LocalFileService;

public class Single1KFileApiTest {

	private final LocalFileService localFileService;
	private final RemoteFileService remoteFileService;

	public Single1KFileApiTest() {
		this.localFileService = new LocalFileService();
		this.remoteFileService = new RemoteFileService();
	}

	@Test
	public void test() {
		File inputFile = localFileService.writeNewTextFile(SizeEnum.K1, "test");
		String uploadFileText = localFileService.readAllTextInFile(inputFile);
		UUID uid = remoteFileService.uploadFile(inputFile);
		File outputFile = remoteFileService.downloadFile(uid);
		String downloadFileText = localFileService.readAllTextInFile(outputFile);
		Assertions.assertEquals(uploadFileText, downloadFileText);
	}

}
