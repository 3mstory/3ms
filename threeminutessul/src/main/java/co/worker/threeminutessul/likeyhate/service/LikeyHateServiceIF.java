package co.worker.threeminutessul.likeyhate.service;

import co.worker.threeminutessul.likeyhate.model.HateVO;
import co.worker.threeminutessul.likeyhate.model.LikeyVO;

public interface LikeyHateServiceIF {

	int insertLikey(LikeyVO likeVo);

	int insertHate(HateVO hateVo);

}
