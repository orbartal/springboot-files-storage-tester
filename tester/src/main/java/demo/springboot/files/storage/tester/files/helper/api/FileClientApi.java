package demo.springboot.files.storage.tester.files.helper.api;

import java.io.File;

import demo.springboot.files.storage.tester.files.helper.config.ConfigProvider;
import demo.springboot.files.storage.tester.files.helper.config.TestConfig;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class FileClientApi {

	private static final TestConfig CONFIG = ConfigProvider.get();
	private static final String TARGET_BASE_URL = CONFIG.getServerBaseUrl();
	private static final String API_UPLOAD_PATH = CONFIG.getApiUploadFile();
	private static final String API_DOWNLOAD_PATH = CONFIG.getApiDownloadFile();

	private static final String MULTIPART_FORM_DATA_VALUE = "multipart/form-data";

	public FileClientApi() {
		RestAssured.baseURI = TARGET_BASE_URL;
	}

	public Response uploadFile(File file) {
		return RestAssured.given()
				.contentType(MULTIPART_FORM_DATA_VALUE)
				.multiPart("file", file)
				.request(Method.POST, API_UPLOAD_PATH);
	}

	public Response downloadFile(String uid) {
		String url = API_DOWNLOAD_PATH + "/" + uid;
		return RestAssured.given().when().get(url).andReturn();
	}

}
