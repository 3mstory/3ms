package co.worker.threeminutessul.likeyhate.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.worker.threeminutessul.likeyhate.dao.LikeyHateDaoIF;
import co.worker.threeminutessul.likeyhate.model.LikeHateVO;
import co.worker.threeminutessul.likeyhate.model.ResultLHVO;

@Repository
public class LikeyHateDaoImpl implements LikeyHateDaoIF{
	@Autowired
	private SqlSessionTemplate template;
	@Override
	public LikeHateVO getLikeHateCount(LikeHateVO vo) {
		return template.selectOne("likeyhate.getLikeHateCount",vo);
	}

	@Override
	public int insertLikeHate(LikeHateVO vo) {
		return template.insert("likeyhate.insertLikeHate",vo);
	}

	@Override
	public int updateLikeHate(LikeHateVO vo) {
		return template.update("likeyhate.updateLikeHate",vo);
	}

	@Override
	public ResultLHVO getReturnlikehate(LikeHateVO vo) {
		return template.selectOne("likeyhate.getReturnlikehate",vo);
	}
	
}
