package demo.springboot.files.storage.tester.hello.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.files.storage.tester.task.api.model.TaskCreateResponseDto;

@RestController
@RequestMapping(path = "/api/v1/test/executer/hello")
public class TestHelloController {

	@Autowired
	private TestHelloApp executer;

	@PostMapping(path = "", produces = "application/json")
	public TaskCreateResponseDto testGetHello() {
		return executer.testGetHello();
	}

}
