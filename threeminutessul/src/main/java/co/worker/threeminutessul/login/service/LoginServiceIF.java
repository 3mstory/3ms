package co.worker.threeminutessul.login.service;

import co.worker.threeminutessul.login.model.LoginVO;
import co.worker.threeminutessul.user.model.UserVO;

public interface LoginServiceIF {

	UserVO loginauth(LoginVO vo);

}
