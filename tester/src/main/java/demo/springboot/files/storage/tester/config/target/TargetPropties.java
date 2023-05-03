package demo.springboot.files.storage.tester.config.target;

public class TargetPropties {

	private final String targetBseUrl;
	private final String targetApiHello;
	private final String targetApiUpload;
	private final String targetApiDownload;

	public TargetPropties(String targetBseUrl, String targetApiHello, String targetApiUpload, String targetApiDownload) {
		this.targetBseUrl = targetBseUrl;
		this.targetApiHello = targetApiHello;
		this.targetApiUpload = targetApiUpload;
		this.targetApiDownload = targetApiDownload;
	}

	public String getTargetBseUrl() {
		return targetBseUrl;
	}

	public String getTargetApiHello() {
		return targetApiHello;
	}

	public String getTargetApiUpload() {
		return targetApiUpload;
	}

	public String getTargetApiDownload() {
		return targetApiDownload;
	}

	@Override
	public String toString() {
		return "TargetPropties [targetBseUrl=" + targetBseUrl + 
				", targetApiHello=" + targetApiHello +
				", targetApiUpload=" + targetApiUpload +
				", targetApiDownload=" + targetApiDownload + "]";
	}

}
