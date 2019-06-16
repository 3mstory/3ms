package co.worker.threeminutessul.login.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.worker.threeminutessul.login.dao.LoginDaoIF;
import co.worker.threeminutessul.login.model.LoginVO;
import co.worker.threeminutessul.user.model.UserVO;

@Repository
public class LoginDaoImpl implements LoginDaoIF{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public UserVO loginauth(LoginVO vo) {
		return template.selectOne("login.loginauth", vo);
	}
}
