package co.worker.threeminutessul.user.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.worker.threeminutessul.user.dao.UserDaoIF;
import co.worker.threeminutessul.user.model.UserVO;

@Repository
public class UserDaoImpl implements UserDaoIF{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public int insertNewUser(UserVO vo) {
		return template.insert("user.insertuser",vo);
	}
	
}
