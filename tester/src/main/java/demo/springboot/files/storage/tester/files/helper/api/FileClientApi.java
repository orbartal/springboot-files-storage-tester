package demo.springboot.files.storage.tester.files.helper.api;

import java.io.File;

import demo.springboot.files.storage.tester.config.target.TargetPropties;
import demo.springboot.files.storage.tester.config.target.TargetProptiesProvider;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class FileClientApi {

	private final TargetPropties target = TargetProptiesProvider.getTargetPropties();

	private static final String MULTIPART_FORM_DATA_VALUE = "multipart/form-data";

	public FileClientApi() {
		RestAssured.baseURI = target.getTargetBseUrl();
	}

	public Response uploadFile(File file) {
		return RestAssured.given()
				.contentType(MULTIPART_FORM_DATA_VALUE)
				.multiPart("file", file)
				.request(Method.POST, target.getTargetApiUpload());
	}

	public Response downloadFile(String uid) {
		String url = target.getTargetApiDownload() + "/" + uid;
		return RestAssured.given().when().get(url).andReturn();
	}

}
