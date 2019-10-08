package co.worker.threeminutessul.likeyhate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.worker.threeminutessul.likeyhate.model.LikeHateVO;
import co.worker.threeminutessul.likeyhate.model.ResultLHVO;
import co.worker.threeminutessul.likeyhate.service.LikeyHateServiceIF;

@RestController
public class LikeyHateController {
	@Autowired
	private LikeyHateServiceIF service;
	
	@PostMapping(value = "/likeyhateAjax.tmssul", consumes="application/json", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  ResponseEntity<LikeHateVO> likeyhateInsertAjax(HttpServletRequest req, HttpServletResponse resp
										 , HttpSession session ,@RequestBody LikeHateVO inputVO ,String type) {
		ResultLHVO resultVO = new ResultLHVO();
		
		inputVO.setUserSeq(Integer.parseInt((String)session.getAttribute("userSeq")));
		LikeHateVO likehateVO = service.getLikeHateCount(inputVO); 
		
		int result=0;
		if(likehateVO == null) { //null이면 처음 누른것. 해당 글에 좋아요/싫어요 누른적 없음 -> insert
			result = service.insertLikeHate(inputVO); //insert
			if(result!=1){
				//json.put("result",-1);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			resultVO = service.getReturnlikehate(inputVO);
			resultVO.setResult(result);
			return new ResponseEntity<>(resultVO, HttpStatus.OK);
			
		} 
		//해당글에 좋아요 누른적 있음 -> 이미 눌렀다는 결과 반환.
		else {
			resultVO.setResult(-1);
			return new ResponseEntity<>(resultVO, HttpStatus.OK);
		}
		
	}
}
