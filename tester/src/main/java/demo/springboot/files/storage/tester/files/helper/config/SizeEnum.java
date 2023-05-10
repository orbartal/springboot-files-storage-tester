package demo.springboot.files.storage.tester.files.helper.config;

public enum SizeEnum {

	K1(1000);

	private final int  value;

	private SizeEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
