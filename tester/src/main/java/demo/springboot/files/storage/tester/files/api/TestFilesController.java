package demo.springboot.files.storage.tester.files.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.files.storage.tester.task.api.model.TaskCreateResponseDto;

@RestController
@RequestMapping(path = "/api/v1/test/executer/file")
public class TestFilesController {

	@Autowired
	private TestFilesApp executer;

	@PostMapping(path = "/valid/single/size/{size}/k", produces = "application/json")
	public TaskCreateResponseDto testApiWithSingle1KFile(@PathVariable int size) {
		return executer.testApiWithSingle1KFile(size);
	}

	@PostMapping(path = "/valid/single/size/{size}/m", produces = "application/json")
	public TaskCreateResponseDto testApiWithSingle1MFile(@PathVariable int size) {
		return executer.testApiWithSingle1MFile(size);
	}

	@PostMapping(path = "/valid/single/size/{size}/g", produces = "application/json")
	public TaskCreateResponseDto testApiWithSingle1GFile(@PathVariable int size) {
		return executer.testApiWithSingle1GMFile(size);
	}

}
