package demo.springboot.files.storage.tester.testtask.model;

import demo.springboot.files.storage.tester.task.model.TaskReport;
import demo.springboot.files.storage.tester.test.report.MultiTestsReport;

public class TestTaskReport implements TaskReport {

	private final MultiTestsReport report;

	public TestTaskReport(MultiTestsReport report) {
		this.report = report;
	}

	public MultiTestsReport getReport() {
		return report;
	}

}
