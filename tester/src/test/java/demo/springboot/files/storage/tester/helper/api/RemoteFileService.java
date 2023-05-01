package demo.springboot.files.storage.tester.helper.api;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import io.restassured.response.Response;

public class RemoteFileService {

	private final FileClientApi fileClientApi;
	private final FileApiResponseValidator validator;

	public RemoteFileService() {
		fileClientApi = new FileClientApi();
		validator = new FileApiResponseValidator();
	}

	@SuppressWarnings("rawtypes")
	public UUID uploadFile(File input) {
		Response uploadResponse = fileClientApi.uploadFile(input);
		validator.validateUploadResponse(uploadResponse);
		Map uploadResultMap = uploadResponse.getBody().as(Map.class);
		String suid = uploadResultMap.get("uid").toString();
		return UUID.fromString(suid);
	}

	public String downloadFile(UUID uid) {
		Response downloadResponse = fileClientApi.downloadFile(uid.toString());
		validator.validateDownloadResponse(downloadResponse);
		byte[] downloadFileBytes = downloadResponse.getBody().asByteArray();
		return new String(downloadFileBytes);
	}

}
