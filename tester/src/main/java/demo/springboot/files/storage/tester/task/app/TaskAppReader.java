package demo.springboot.files.storage.tester.task.app;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.springboot.files.storage.tester.task.api.model.TaskStatusResponseDto;
import demo.springboot.files.storage.tester.task.app.mapper.TaskResponseFactory;
import demo.springboot.files.storage.tester.task.data.TaskDataReader;
import demo.springboot.files.storage.tester.task.model.TaskReport;
import demo.springboot.files.storage.tester.task.model.TaskStatusEnum;

@Component
public class TaskAppReader {

	@Autowired
	private TaskDataReader taskReader;

	@Autowired
	private TaskResponseFactory responseFactory;

	public TaskStatusResponseDto readTaskStatusById(String id) {
		UUID uid = UUID.fromString(id);
		Optional<TaskStatusEnum> status = taskReader.getStatus(uid);
		if (status.isPresent()) {
			return responseFactory.status(id, status);
		}
		throw new RuntimeException("Not found task for uid");
	}

	public TaskReport readTaskReportById(String id) {
		UUID uid = UUID.fromString(id);
		Optional<TaskReport> r = taskReader.getReport(uid);
		if (r.isPresent()) {
			return r.get();
		}
		throw new RuntimeException("Not found task report for uid");
	}

}
