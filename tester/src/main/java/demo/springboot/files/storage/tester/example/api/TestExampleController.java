package demo.springboot.files.storage.tester.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.files.storage.tester.example.application.ExampleTestApp;
import demo.springboot.files.storage.tester.task.api.model.TaskCreateResponseDto;

@RestController
@RequestMapping(path = "/api/v1/test/executer")
public class TestExampleController {

	@Autowired
	private ExampleTestApp executer;

	@PostMapping(path = "/example/test_4_results", produces = "application/json")
	public TaskCreateResponseDto test4Results() {
		return executer.test4Results();
	}
	
	@PostMapping(path = "/example/test_call_order", produces = "application/json")
	public TaskCreateResponseDto testCallOrder() {
		return executer.testCallOrder();
	}

	@PostMapping(path = "/example/test_service", produces = "application/json")
	public TaskCreateResponseDto testService() {
		return executer.testService();
	}

}
