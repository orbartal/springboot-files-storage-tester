
package demo.springboot.files.storage.tester.hello.test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import demo.springboot.files.storage.tester.hello.help.RemoteHelloService;

public class HelloApiTest {

	private final RemoteHelloService helloService;

	public HelloApiTest() {
		this.helloService = new RemoteHelloService();
	}

	@Test
	public void testGetHello() {
		String actual = helloService.readHello();
		Assertions.assertEquals("hello", actual);
	}

}
