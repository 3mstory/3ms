package co.worker.threeminutessul.util.fileupload;

import java.io.File;

public class FileUploadUtil {
		// 파일 경로와 파일명 넣으면.
		// 파일명이 겹치면 안되니까 이렇게 해주는거같다.
		public static String getFileName(String path, String filename) {

			// a.zip -> a_1.zip
			int index = filename.lastIndexOf(".");
			String tempName = filename.substring(0, index);// a 뽑아낸거
			String tempExt = filename.substring(index);// .zip뽑아낸거
			int n = 1;
			// 중복검사
			while (true) {
				File file = new File(path + "\\" + filename);
				if (file.exists()) {
					// 이름 고치기
					filename = tempName + "_" + n + tempExt; // a_1.zip
					n++;
				} else {
					return file.getName();
				}
			}
		}
}
