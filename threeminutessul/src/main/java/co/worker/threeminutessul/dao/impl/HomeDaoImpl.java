package co.worker.threeminutessul.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.worker.threeminutessul.dao.HomeDaoIF;
import co.worker.threeminutessul.model.UserInfoVO;

@Repository
public class HomeDaoImpl implements HomeDaoIF{
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public String auth(String id, String pw) {
		UserInfoVO vo = new UserInfoVO();
		vo.setUserid(id);
		vo.setUserpw(pw);
		return template.selectOne("auth",vo);
	}
}
