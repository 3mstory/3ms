package co.worker.threeminutessul.login.dao;

import co.worker.threeminutessul.login.model.LoginVO;
import co.worker.threeminutessul.user.model.UserVO;

public interface LoginDaoIF {

	UserVO loginauth(LoginVO vo);

}
