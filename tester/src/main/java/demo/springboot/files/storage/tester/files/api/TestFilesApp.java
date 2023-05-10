package demo.springboot.files.storage.tester.files.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.springboot.files.storage.tester.files.test.Single1KFileApiTest;
import demo.springboot.files.storage.tester.files.test.Single1MFileApiTest;
import demo.springboot.files.storage.tester.task.api.model.TaskCreateResponseDto;
import demo.springboot.files.storage.tester.task.app.TaskAppWriter;
import demo.springboot.files.storage.tester.task.model.RunnableTask;
import demo.springboot.files.storage.tester.testtask.runnable.TestRunnableTask;
import demo.springboot.files.storage.tester.testtask.worker.TestTaskWorker;
import demo.springboot.files.storage.tester.testtask.worker.TestTaskWorkerFactory;

@Component
public class TestFilesApp {

	@Autowired
	private TaskAppWriter taskWriter;

	public TaskCreateResponseDto testApiWithSingle1KFile() {
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestClassWithOrder(Single1KFileApiTest.class);
		RunnableTask task = new TestRunnableTask("Single1KFileApiTest", worker);
		return taskWriter.runTask(task);
	}

	public TaskCreateResponseDto testApiWithSingle1MFile() {
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestClassWithOrder(Single1MFileApiTest.class);
		RunnableTask task = new TestRunnableTask("Single1MFileApiTest", worker);
		return taskWriter.runTask(task);
	}

}
