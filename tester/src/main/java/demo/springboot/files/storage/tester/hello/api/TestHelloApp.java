package demo.springboot.files.storage.tester.hello.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.springboot.files.storage.tester.hello.test.HelloApiTest;
import demo.springboot.files.storage.tester.task.api.model.TaskCreateResponseDto;
import demo.springboot.files.storage.tester.task.app.TaskAppWriter;
import demo.springboot.files.storage.tester.task.model.RunnableTask;
import demo.springboot.files.storage.tester.testtask.runnable.TestRunnableTask;
import demo.springboot.files.storage.tester.testtask.worker.TestTaskWorker;
import demo.springboot.files.storage.tester.testtask.worker.TestTaskWorkerFactory;

@Component
public class TestHelloApp {

	@Autowired
	private TaskAppWriter taskWriter;

	public TaskCreateResponseDto testGetHello() {
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestClassWithOrder(HelloApiTest.class);
		RunnableTask task = new TestRunnableTask("testGetHello", worker);
		return taskWriter.runTask(task);
	}

}
