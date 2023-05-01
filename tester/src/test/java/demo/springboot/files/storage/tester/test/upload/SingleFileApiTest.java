
package demo.springboot.files.storage.tester.test.upload;

import java.io.File;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import demo.springboot.files.storage.tester.helper.api.RemoteFileService;
import demo.springboot.files.storage.tester.helper.writer.LocalFileService;

public class SingleFileApiTest {

	private final LocalFileService localFileService;
	private final RemoteFileService remoteFileService;

	public SingleFileApiTest() {
		this.localFileService = new LocalFileService();
		this.remoteFileService = new RemoteFileService();
	}

	@Test
	public void testOneSmallFileUploadAndDownload() {
		File inputFile = localFileService.writeNewSmallTextFile();
		String uploadFileText = localFileService.readAllTextInFile(inputFile);
		UUID uid = remoteFileService.uploadFile(inputFile);
		String downloadFileText = remoteFileService.downloadFile(uid);
		Assertions.assertEquals(uploadFileText, downloadFileText);
	}

}
