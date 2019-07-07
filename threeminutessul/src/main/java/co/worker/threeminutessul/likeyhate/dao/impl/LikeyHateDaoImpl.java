package co.worker.threeminutessul.likeyhate.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.worker.threeminutessul.likeyhate.dao.LikeyHateDaoIF;
import co.worker.threeminutessul.likeyhate.model.HateVO;
import co.worker.threeminutessul.likeyhate.model.LikeHateVO;
import co.worker.threeminutessul.likeyhate.model.LikeyVO;

@Repository
public class LikeyHateDaoImpl implements LikeyHateDaoIF{
	@Autowired
	private SqlSessionTemplate template;
	@Override
	public List<LikeHateVO> getLikeHateCount(LikeHateVO vo) {
		return template.selectList("likeyhate.getLikeHateCount",vo);
	}

	@Override
	public int insertLikeHate(LikeHateVO vo) {
		return template.insert("likeyhate.insertLikeHate",vo);
	}

	@Override
	public int updateLikeHate(LikeHateVO vo) {
		return template.update("likeyhate.updateLikeHate",vo);
	}
	
}
