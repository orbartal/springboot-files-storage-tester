package demo.springboot.files.storage.tester.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.springboot.files.storage.tester.example.test.CallOrderTest;
import demo.springboot.files.storage.tester.example.test.Test4Results;
import demo.springboot.files.storage.tester.example.test.TestExampleService;
import demo.springboot.files.storage.tester.task.api.model.TaskCreateResponseDto;
import demo.springboot.files.storage.tester.task.app.TaskAppWriter;
import demo.springboot.files.storage.tester.task.model.RunnableTask;
import demo.springboot.files.storage.tester.test.runner.TestBeanRunner;
import demo.springboot.files.storage.tester.testtask.runnable.TestRunnableTask;
import demo.springboot.files.storage.tester.testtask.worker.TestTaskWorker;
import demo.springboot.files.storage.tester.testtask.worker.TestTaskWorkerFactory;

@Component
public class ExampleTestApp {

	@Autowired
	private TaskAppWriter taskWriter;

	public TaskCreateResponseDto test4Results() {
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestClass(Test4Results.class);
		RunnableTask task = new TestRunnableTask("test4Results", worker);
		return taskWriter.runTask(task);
	}

	public TaskCreateResponseDto testCallOrder() {
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestClass(CallOrderTest.class);
		RunnableTask task = new TestRunnableTask("testCallOrder", worker);
		return taskWriter.runTask(task);
	}

	public TaskCreateResponseDto testService() {
		TestExampleService service = new TestExampleService();
		TestBeanRunner runner = new TestBeanRunner(service);
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestBeanRunner(runner);
		RunnableTask task = new TestRunnableTask("testExampleService", worker);
		return taskWriter.runTask(task);
	}

}
