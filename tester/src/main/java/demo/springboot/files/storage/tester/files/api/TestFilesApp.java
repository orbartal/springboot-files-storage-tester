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

	public TaskCreateResponseDto testApiWithSingle1KFile() {
		SingleFileApiTest test = new SingleFileApiTest(SizeEnum.K1, 1);
		TestBeanRunner runner = new TestBeanRunner(test);
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestBeanRunner(runner);
		RunnableTask task = new TestRunnableTask("Single1KFileApiTest", worker);
		return taskWriter.runTask(task);
	}

	public TaskCreateResponseDto testApiWithSingle1MFile() {
		SingleFileApiTest test = new SingleFileApiTest(SizeEnum.M1, 1);
		TestBeanRunner runner = new TestBeanRunner(test);
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestBeanRunner(runner);
		RunnableTask task = new TestRunnableTask("Single1MFileApiTest", worker);
		return taskWriter.runTask(task);
	}

	public TaskCreateResponseDto testApiWithSingle100MFile() {
		SingleFileApiTest test = new SingleFileApiTest(SizeEnum.M1, 100);
		TestBeanRunner runner = new TestBeanRunner(test);
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestBeanRunner(runner);
		RunnableTask task = new TestRunnableTask("Single100MFileApiTest", worker);
		return taskWriter.runTask(task);
	}

	public TaskCreateResponseDto testApiWithSingle1GMFile() {
		SingleFileApiTest test = new SingleFileApiTest(SizeEnum.G1, 1);
		TestBeanRunner runner = new TestBeanRunner(test);
		TestTaskWorker worker = TestTaskWorkerFactory.fromTestBeanRunner(runner);
		RunnableTask task = new TestRunnableTask("Single1GFileApiTest", worker);
		return taskWriter.runTask(task);
	}

}
