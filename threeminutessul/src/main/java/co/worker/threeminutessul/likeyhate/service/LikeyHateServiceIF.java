package co.worker.threeminutessul.likeyhate.service;

import co.worker.threeminutessul.likeyhate.model.LikeHateVO;
import co.worker.threeminutessul.likeyhate.model.ResultLHVO;

public interface LikeyHateServiceIF {

	LikeHateVO getLikeHateCount(LikeHateVO vo);

	int insertLikeHate(LikeHateVO vo);

	//int updateLikeHate(LikeHateVO vo,String type);

	ResultLHVO getReturnlikehate(LikeHateVO vo);

}
