package demo.springboot.files.storage.tester.files.helper.api;

import java.net.HttpURLConnection;
import java.util.Map;

import io.restassured.response.Response;

public class FileApiResponseValidator {

	public void validateUploadResponse(Response uploadResponse) {
		if (uploadResponse == null) {
			throw new RuntimeException("Upload response is null");
		}
		if (HttpURLConnection.HTTP_OK != uploadResponse.getStatusCode()) {
			throw new RuntimeException("Upload response Http Status is: " + uploadResponse.getStatusCode());
		}
		if (uploadResponse.getBody() == null) {
			throw new RuntimeException("Upload response.body is null");
		}
		@SuppressWarnings("rawtypes")
		Map uploadResultMap = uploadResponse.getBody().as(Map.class);
		if (uploadResultMap.get("uid") == null) {
			throw new RuntimeException("Upload response.body missing uid");
		}
	}

	public void validateDownloadResponse(Response downloadResponse) {
		if (downloadResponse == null) {
			throw new RuntimeException("Download response is null");
		}
		if (HttpURLConnection.HTTP_OK != downloadResponse.getStatusCode()) {
			throw new RuntimeException("Download response Http Status is: " + downloadResponse.getStatusCode());
		}
		if (downloadResponse.getBody() == null) {
			throw new RuntimeException("Download response.body is null");
		}
	}

}
