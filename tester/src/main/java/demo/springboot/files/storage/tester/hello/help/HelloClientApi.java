package demo.springboot.files.storage.tester.hello.help;

import demo.springboot.files.storage.tester.config.target.TargetPropties;
import demo.springboot.files.storage.tester.config.target.TargetProptiesProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HelloClientApi {

	private final TargetPropties target = TargetProptiesProvider.getTargetPropties();

	public HelloClientApi() {
		RestAssured.baseURI = target.getTargetBseUrl();
	}

	public Response getHello() {
		String url = target.getTargetApiHello();
		return RestAssured.given().when().get(url).andReturn();
	}

}
