package demo.springboot.files.storage.tester.example.test;

import org.junit.Assert;
import org.junit.Test;

import demo.springboot.files.storage.tester.test.runner.TestFunction;

public class TestExampleService implements TestFunction {

	@Test
	@Override
	public void test() {
		Assert.assertEquals(1, 1);
	}

}
