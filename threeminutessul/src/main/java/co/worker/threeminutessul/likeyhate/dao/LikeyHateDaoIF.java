package co.worker.threeminutessul.likeyhate.dao;

import co.worker.threeminutessul.likeyhate.model.HateVO;
import co.worker.threeminutessul.likeyhate.model.LikeyVO;

public interface LikeyHateDaoIF {

	int insertLikey(LikeyVO likeVo);

	int insertHate(HateVO hateVo);

}
