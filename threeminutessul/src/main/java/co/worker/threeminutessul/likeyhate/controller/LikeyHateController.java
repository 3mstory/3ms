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
	public  JSONObject likeyhateInsertAjax(HttpServletRequest req, HttpServletResponse resp
										 , HttpSession session ,LikeHateVO vo ,String type) {
		vo.setUserSeq(Integer.parseInt((String)session.getAttribute("userSeq")));
		List<LikeHateVO> list = service.getLikeHateCount(vo); 
		
		int result=0;
		JSONObject json = new JSONObject();
		if(list.size()==0) { //해당 글에 좋아요 누른적 없음 -> insert
			result = service.insertLikeHate(vo,type);
			if(result!=1){
				json.put("result",-1);
				return json;
			}
			HashMap<String,Integer> likehatecount = service.getReturnlikehate(vo);
			json.put("likecount",likehatecount.get("like"));
			json.put("hatecount",likehatecount.get("hate"));
			json.put("isLikeHate",likehatecount.get("isLikeHate"));
			json.put("isMyClicked",likehatecount.get("isMyClicked"));
			json.put("content", likehatecount.get("content"));
			json.put("result",result); //업데이트,인서트 결과 개수.(1개여야지 정상)
			//
			return json;
		} 
		//해당글에 좋아요 누른적 있음 -> 이미 눌렀다는 결과 반환.
		else {
			json.put("result",-1);
			return json;
		}
	}
}
