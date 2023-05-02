package demo.springboot.files.storage.tester.task.app;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.springboot.files.storage.tester.task.api.model.TaskCreateResponseDto;
import demo.springboot.files.storage.tester.task.app.mapper.TaskResponseFactory;
import demo.springboot.files.storage.tester.task.data.TaskDataWriter;
import demo.springboot.files.storage.tester.task.model.RunnableTask;


@Component
public class TaskAppWriter {

	@Autowired
	private TaskResponseFactory responseFactory;

	@Autowired
	private TaskDataWriter taskExecuter;

	public TaskCreateResponseDto runTask(RunnableTask task) {
		UUID uuid = taskExecuter.addNewTask(task);
		return responseFactory.create(uuid, task);
	}

}
