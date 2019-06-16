package co.worker.threeminutessul.likeyhate.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.worker.threeminutessul.likeyhate.dao.LikeyHateDaoIF;
import co.worker.threeminutessul.likeyhate.model.HateVO;
import co.worker.threeminutessul.likeyhate.model.LikeyVO;

@Repository
public class LikeyHateDaoImpl implements LikeyHateDaoIF{
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public int insertLikey(LikeyVO likeVo) {
		
		return template.insert("likeyhate.insertLikey",likeVo);
	}

	@Override
	public int insertHate(HateVO hateVo) {
		return template.insert("likeyhate.insertHate",hateVo);
	}
	
}
