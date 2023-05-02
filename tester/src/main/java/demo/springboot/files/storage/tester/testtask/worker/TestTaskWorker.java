package demo.springboot.files.storage.tester.testtask.worker;

import demo.springboot.files.storage.tester.test.runner.TestListener;
import demo.springboot.files.storage.tester.testtask.model.TestTaskReport;

public class TestTaskWorker implements TaskWorker<TestTaskReport> {

	private final JunitRunner runner;

	public TestTaskWorker(JunitRunner runner) {
		this.runner = runner;
	}

	@Override
	public TestTaskReport work() {
		TestListener listener = new TestListener();
		runner.run(listener);
		return new TestTaskReport(listener.getReport());
	}

}
