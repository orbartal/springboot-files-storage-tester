package demo.springboot.files.storage.tester.files.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.springboot.files.storage.tester.files.helper.config.SizeEnum;
import demo.springboot.files.storage.tester.files.test.SingleFileApiTest;
import demo.springboot.files.storage.tester.task.api.model.TaskCreateResponseDto;
import demo.springboot.files.storage.tester.task.app.TaskAppWriter;
import demo.springboot.files.storage.tester.task.model.RunnableTask;
import demo.springboot.files.storage.tester.test.runner.TestBeanRunner;
import demo.springboot.files.storage.tester.testtask.runnable.TestRunnableTask;
import demo.springboot.files.storage.tester.testtask.worker.TestTaskWorker;
import demo.springboot.files.storage.tester.testtask.worker.TestTaskWorkerFactory;

@Component
public class TestFilesApp {

	@Autowired
	private TaskAppWriter taskWriter;

	public TaskCreateResponseDto testApiWithSingleFile(SizeEnum unit, int amount) {
		SingleFileApiTest test = new SingleFileApiTest(unit, amount);
		TestBeanRunner runner = new TestBeanRunner(test);
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestBeanRunner(runner);
		RunnableTask task = new TestRunnableTask("SingleFileApiTest", worker);
		return taskWriter.runTask(task);
	}

}
