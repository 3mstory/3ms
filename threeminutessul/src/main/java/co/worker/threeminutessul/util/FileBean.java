package co.worker.threeminutessul.util;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileBean {
	private CommonsMultipartFile upload;

	public CommonsMultipartFile getUpload() {
		return upload;
	}

	public void setUpload(CommonsMultipartFile upload) {
		this.upload = upload;
	}

	
}
