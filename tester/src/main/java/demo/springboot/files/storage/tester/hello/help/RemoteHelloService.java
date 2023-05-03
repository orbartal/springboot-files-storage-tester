package demo.springboot.files.storage.tester.hello.help;

import io.restassured.response.Response;

public class RemoteHelloService {

	private final HelloClientApi helloClientApi;

	public RemoteHelloService() {
		this.helloClientApi = new HelloClientApi();
	}

	public String readHello() {
		Response response = helloClientApi.getHello();
		HttpResponseValidator.validateResponse("getHello", response);
		byte[] responseBytes = response.getBody().asByteArray();
		return new String(responseBytes);
	}

}
