package co.worker.threeminutessul.user.dao;

import co.worker.threeminutessul.user.model.UserVO;

public interface UserDaoIF {

	int insertNewUser(UserVO vo);

	int duplicateIdCheck(String inputId);

}
