package demo.springboot.files.storage.tester.files.helper.config;

public enum SizeEnum {

	G(1000 * 1000 * 1000),
	M(1000 * 1000),
	K(1000);

	private final int  value;

	private SizeEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
