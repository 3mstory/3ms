package co.worker.threeminutessul.likeyhate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.worker.threeminutessul.likeyhate.dao.LikeyHateDaoIF;
import co.worker.threeminutessul.likeyhate.model.HateVO;
import co.worker.threeminutessul.likeyhate.model.LikeyVO;
import co.worker.threeminutessul.likeyhate.service.LikeyHateServiceIF;

@Service
public class LikeyHateServiceImpl implements LikeyHateServiceIF{
	@Autowired
	private LikeyHateDaoIF dao;

	@Override
	public int insertLikey(LikeyVO likeVo) {
		int result = dao.insertLikey(likeVo);
		return 0;
	}

	@Override
	public int insertHate(HateVO hateVo) {
		int result = dao.insertHate(hateVo);
		return 0;
	}
}
