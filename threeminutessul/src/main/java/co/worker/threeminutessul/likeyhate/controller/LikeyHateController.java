package co.worker.threeminutessul.likeyhate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.worker.threeminutessul.likeyhate.model.HateVO;
import co.worker.threeminutessul.likeyhate.model.LikeyVO;
import co.worker.threeminutessul.likeyhate.service.LikeyHateServiceIF;

@Controller
public class LikeyHateController {
	@Autowired
	private LikeyHateServiceIF service;
	
	@RequestMapping(value = "/likeyhateAjax.tmssul", method = { RequestMethod.GET })
	public int likeyhateInsertAjax(HttpServletRequest req, HttpServletResponse resp,Object likeOrHate ,String type) {
		int result=0;
		type = type.toLowerCase();
		//초기 isdupl 은 0으로 고정.
		if(type.equals(String.valueOf("likey"))) {
			LikeyVO likeVo = (LikeyVO)likeOrHate;
			likeVo.setIsdupl(0);
			result = service.insertLikey(likeVo);
		}else if(type.equals(String.valueOf("hate"))) {
			HateVO hateVo = (HateVO)likeOrHate;
			hateVo.setIsdupl(0);
			result = service.insertHate(hateVo);
		}
		return result;
	}
	
}
