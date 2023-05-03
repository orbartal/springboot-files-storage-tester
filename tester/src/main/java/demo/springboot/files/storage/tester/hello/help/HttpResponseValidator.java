package demo.springboot.files.storage.tester.hello.help;

import java.net.HttpURLConnection;

import io.restassured.response.Response;

public class HttpResponseValidator {

	public static void validateResponse(String contex, Response response) {
		if (response == null) {
			throw new RuntimeException(contex + " response is null");
		}
		if (HttpURLConnection.HTTP_OK != response.getStatusCode()) {
			throw new RuntimeException(contex + " response Http Status is: " + response.getStatusCode());
		}
		if (response.getBody() == null) {
			throw new RuntimeException(contex + " response.body is null");
		}
	}

}
