package co.worker.threeminutessul.likeyhate.service;

import java.util.HashMap;
import java.util.List;

import co.worker.threeminutessul.likeyhate.model.LikeHateVO;

public interface LikeyHateServiceIF {

	List<LikeHateVO> getLikeHateCount(LikeHateVO vo);

	int insertLikeHate(LikeHateVO vo,String type);

	int updateLikeHate(LikeHateVO vo,String type);

	HashMap<String, Integer> getReturnlikehate(LikeHateVO vo);

}
