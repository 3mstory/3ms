package co.worker.threeminutessul.likeyhate.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.worker.threeminutessul.likeyhate.model.LikeHateVO;
import co.worker.threeminutessul.likeyhate.service.LikeyHateServiceIF;

@Controller
public class LikeyHateController {
	@Autowired
	private LikeyHateServiceIF service;
	
	@RequestMapping(value = "/likeyhateAjax.tmssul", method = { RequestMethod.GET })
	@ResponseBody
	public  JSONObject likeyhateInsertAjax(HttpServletRequest req, HttpServletResponse resp, HttpSession session ,LikeHateVO vo ,String type) {
		vo.setUserSeq(Integer.parseInt((String)session.getAttribute("userSeq")));
		List<LikeHateVO> list = service.getLikeHateCount(vo); //여기서 가져온 값과 파라미터 들어온 값 비교로 update 안하도록
		
		int result=0;
		if(list.size() == 0) { //해당 글에 좋아요 누른적 없음 -> insert
			result = service.insertLikeHate(vo,type);
		}else { //해당글에 좋아요 누른적 있음 -> update
			result = service.updateLikeHate(vo,type);
		}
		HashMap<String,Integer> likehatecount = service.getReturnlikehate(vo);
		JSONObject json = new JSONObject();
		json.put("like",likehatecount.get("like"));
		json.put("hate",likehatecount.get("hate"));
		json.put("isLikeHate",likehatecount.get("isLikeHate"));
		json.put("isMyClicked",likehatecount.get("isMyClicked"));
		json.put("content", likehatecount.get("content"));
		json.put("result",result); //업데이트,인서트 결과 개수.(1개여야지 정상)
		//
		return json;
	}
}
