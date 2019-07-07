package co.worker.threeminutessul.likeyhate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.worker.threeminutessul.likeyhate.dao.LikeyHateDaoIF;
import co.worker.threeminutessul.likeyhate.model.HateVO;
import co.worker.threeminutessul.likeyhate.model.LikeHateVO;
import co.worker.threeminutessul.likeyhate.model.LikeyVO;
import co.worker.threeminutessul.likeyhate.service.LikeyHateServiceIF;

@Service
public class LikeyHateServiceImpl implements LikeyHateServiceIF{
	@Autowired
	private LikeyHateDaoIF dao;

	@Override
	public List<LikeHateVO> getLikeHateCount(LikeHateVO vo) {
		return dao.getLikeHateCount(vo);
	}

	@Override
	public int insertLikeHate(LikeHateVO vo,String type) {
		if(type.equals("1")) { //1 좋아요, 2 싫어요.
			vo.setIsLike(1);
			vo.setIsHate(0);
		}else {
			vo.setIsLike(0);
			vo.setIsHate(1);
		}
		return dao.insertLikeHate(vo);
	}

	@Override
	public int updateLikeHate(LikeHateVO vo, String type) {
		if(type.equals("1")) { //1 좋아요, 2 싫어요.
			vo.setIsLike(1);
			vo.setIsHate(0);
		}else {
			vo.setIsLike(0);
			vo.setIsHate(1);
		}
		return dao.updateLikeHate(vo);
	}
}
