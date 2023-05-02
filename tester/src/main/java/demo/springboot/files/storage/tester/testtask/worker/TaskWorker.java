package demo.springboot.files.storage.tester.testtask.worker;

import demo.springboot.files.storage.tester.task.model.TaskReport;

public interface TaskWorker <R extends TaskReport> {

	public R work();

}
