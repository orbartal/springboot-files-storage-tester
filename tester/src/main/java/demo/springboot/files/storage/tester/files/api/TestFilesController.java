package demo.springboot.files.storage.tester.files.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.files.storage.tester.task.api.model.TaskCreateResponseDto;

@RestController
@RequestMapping(path = "/api/v1/test/executer")
public class TestFilesController {

	@Autowired
	private TestFilesApp executer;

	@PostMapping(path = "/demo/crud/one/valid", produces = "application/json")
	public TaskCreateResponseDto testApiWithSingle1KFile() {
		return executer.testApiWithSingle1KFile();
	}

}
