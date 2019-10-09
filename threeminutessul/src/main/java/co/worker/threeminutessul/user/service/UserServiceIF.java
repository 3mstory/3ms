package co.worker.threeminutessul.user.service;

import org.springframework.web.multipart.MultipartFile;

import co.worker.threeminutessul.user.model.UserVO;

public interface UserServiceIF {

	int insertNewUser(UserVO vo,MultipartFile profile);

	int duplicateIdCheck(String inputId);

}
