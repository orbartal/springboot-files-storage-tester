package demo.springboot.files.storage.tester.config;

public class TargetPropties {

	private final String targetBseUrl;
	private final String targetApiUpload;
	private final String targetApiDownload;

	public TargetPropties(String targetBseUrl, String targetApiUpload, String targetApiDownload) {
		this.targetBseUrl = targetBseUrl;
		this.targetApiUpload = targetApiUpload;
		this.targetApiDownload = targetApiDownload;
	}

	public String getTargetBseUrl() {
		return targetBseUrl;
	}

	public String getTargetApiUpload() {
		return targetApiUpload;
	}

	public String getTargetApiDownload() {
		return targetApiDownload;
	}

	@Override
	public String toString() {
		return "TargetPropties [targetBseUrl=" + targetBseUrl + ", targetApiUpload=" + targetApiUpload
				+ ", targetApiDownload=" + targetApiDownload + "]";
	}

}
