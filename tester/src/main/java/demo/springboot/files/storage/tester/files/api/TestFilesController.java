package demo.springboot.files.storage.tester.files.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.files.storage.tester.task.api.model.TaskCreateResponseDto;

@RestController
@RequestMapping(path = "/api/v1/test/executer/file")
public class TestFilesController {

	@Autowired
	private TestFilesApp executer;

	@PostMapping(path = "/valid/single/1k", produces = "application/json")
	public TaskCreateResponseDto testApiWithSingle1KFile() {
		return executer.testApiWithSingle1KFile();
	}
	
	@PostMapping(path = "/valid/single/1m", produces = "application/json")
	public TaskCreateResponseDto testApiWithSingle1MFile() {
		return executer.testApiWithSingle1MFile();
	}

}
