package co.worker.threeminutessul.likeyhate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.worker.threeminutessul.likeyhate.dao.LikeyHateDaoIF;
import co.worker.threeminutessul.likeyhate.model.LikeHateVO;
import co.worker.threeminutessul.likeyhate.model.ResultLHVO;
import co.worker.threeminutessul.likeyhate.service.LikeyHateServiceIF;

@Service
public class LikeyHateServiceImpl implements LikeyHateServiceIF{
	@Autowired
	private LikeyHateDaoIF dao;

	@Override
	public LikeHateVO getLikeHateCount(LikeHateVO vo) {
		return dao.getLikeHateCount(vo);
	}

	@Override
	public int insertLikeHate(LikeHateVO vo) {
		if(vo.getType().equals("like")) { //1 좋아요, 2 싫어요.
			vo.setIsLike(1);
			vo.setIsHate(0);
		}else {
			vo.setIsLike(0);
			vo.setIsHate(1);
		}
		return dao.insertLikeHate(vo);
	}

	/* @Override
	public int updateLikeHate(LikeHateVO vo, String type) {
		if(type.equals("like")) { //1 좋아요, 2 싫어요.
			vo.setIsLike(1);
			vo.setIsHate(0);
		}else {
			vo.setIsLike(0);
			vo.setIsHate(1);
		}
		return dao.updateLikeHate(vo);
	}*/

	@Override
	public ResultLHVO getReturnlikehate(LikeHateVO vo) {
		return dao.getReturnlikehate(vo);
	}
}
