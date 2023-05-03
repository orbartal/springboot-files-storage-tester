
package demo.springboot.files.storage.tester.files.test;

import java.io.File;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import demo.springboot.files.storage.tester.files.helper.api.RemoteFileService;
import demo.springboot.files.storage.tester.files.helper.writer.LocalFileService;

public class SingleFileApiTest {

	private final LocalFileService localFileService;
	private final RemoteFileService remoteFileService;

	public SingleFileApiTest() {
		this.localFileService = new LocalFileService();
		this.remoteFileService = new RemoteFileService();
	}

	@Test
	public void testOneSmallFileUploadAndDownload() {
		File inputFile = localFileService.writeNewSmallTextFile("test");
		String uploadFileText = localFileService.readAllTextInFile(inputFile);
		UUID uid = remoteFileService.uploadFile(inputFile);
		String downloadFileText = remoteFileService.downloadFile(uid);
		Assertions.assertEquals(uploadFileText, downloadFileText);
	}

}