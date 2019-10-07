package co.worker.threeminutessul.likeyhate.dao;

import co.worker.threeminutessul.likeyhate.model.LikeHateVO;
import co.worker.threeminutessul.likeyhate.model.ResultLHVO;

public interface LikeyHateDaoIF {

	LikeHateVO getLikeHateCount(LikeHateVO vo);

	int insertLikeHate(LikeHateVO vo);

	int updateLikeHate(LikeHateVO vo);

	ResultLHVO getReturnlikehate(LikeHateVO vo);

}
