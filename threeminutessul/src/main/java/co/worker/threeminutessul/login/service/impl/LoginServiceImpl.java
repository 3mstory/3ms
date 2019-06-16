package co.worker.threeminutessul.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.worker.threeminutessul.login.dao.LoginDaoIF;
import co.worker.threeminutessul.login.model.LoginVO;
import co.worker.threeminutessul.login.service.LoginServiceIF;
import co.worker.threeminutessul.user.model.UserVO;
import co.worker.threeminutessul.util.loginsecure.SHA256Util;

@Service
public class LoginServiceImpl implements LoginServiceIF{
	
	@Autowired
	private LoginDaoIF dao;

	@Override
	public UserVO loginauth(LoginVO vo) {
		String pw = vo.getUserpw();
		if(!pw.equals("admin")) {
			vo.setUserpw(SHA256Util.encrptSHA256(vo.getUserpw()));
		}
		return dao.loginauth(vo);
	}
	
}
