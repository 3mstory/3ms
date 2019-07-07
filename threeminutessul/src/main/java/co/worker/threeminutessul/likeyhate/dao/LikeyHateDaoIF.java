package co.worker.threeminutessul.likeyhate.dao;

import java.util.List;

import co.worker.threeminutessul.likeyhate.model.HateVO;
import co.worker.threeminutessul.likeyhate.model.LikeHateVO;
import co.worker.threeminutessul.likeyhate.model.LikeyVO;

public interface LikeyHateDaoIF {

	List<LikeHateVO> getLikeHateCount(LikeHateVO vo);

	int insertLikeHate(LikeHateVO vo);

	int updateLikeHate(LikeHateVO vo);

}
