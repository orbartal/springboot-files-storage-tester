package demo.springboot.files.storage.tester.files.helper.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;

import demo.springboot.files.storage.tester.files.helper.writer.LocalFileService;
import io.restassured.response.Response;

public class RemoteFileService {

	private final FileClientApi fileClientApi;
	private final FileApiResponseValidator validator;
	private final LocalFileService localFileService;

	public RemoteFileService() {
		fileClientApi = new FileClientApi();
		validator = new FileApiResponseValidator();
		localFileService = new LocalFileService();
	}

	@SuppressWarnings("rawtypes")
	public UUID uploadFile(File input) {
		Response uploadResponse = fileClientApi.uploadFile(input);
		validator.validateUploadResponse(uploadResponse);
		Map uploadResultMap = uploadResponse.getBody().as(Map.class);
		String suid = uploadResultMap.get("uid").toString();
		return UUID.fromString(suid);
	}

	public File downloadFile(UUID uid) {
		Response downloadResponse = fileClientApi.downloadFile(uid.toString());
		validator.validateDownloadResponse(downloadResponse);
		InputStream inputStream = downloadResponse.getBody().asInputStream();
		File output = localFileService.createTempFile(uid.toString());
		localFileService.writeInputStreamToFile(output, inputStream);
	    return output;
	}

}
