package co.worker.threeminutessul.comment.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.worker.threeminutessul.board.service.BoardServiceIF;
import co.worker.threeminutessul.comment.medel.CommentVO;
import co.worker.threeminutessul.comment.service.CommentServiceIF;
import co.worker.threeminutessul.likeyhate.model.LikeHateVO;
import co.worker.threeminutessul.likeyhate.service.LikeyHateServiceIF;

@Controller
public class CommentController {
	
	@Autowired
	private CommentServiceIF service;
	@Autowired
	private BoardServiceIF boardService;
	@Autowired
	private LikeyHateServiceIF likehateService;
	
	@RequestMapping(value = "/commentList.tmssul", method = { RequestMethod.GET })
	@ResponseBody
	public JSONObject commentList(HttpServletRequest req, HttpServletResponse resp, HttpSession session, int boardSeq) throws Exception {
		List<CommentVO> commentList = service.getComment(boardSeq);
		
		// board 컨텐츠 가져오기
		String boardContent = boardService.getBoardContent(boardSeq);
		
		LikeHateVO likehateVO = new LikeHateVO();
		likehateVO.setBoardSeq(boardSeq);
		likehateVO.setUserSeq(Integer.parseInt(
										(String)session.getAttribute("userSeq") == null ? 
										"0" : (String)session.getAttribute("userSeq")
		));
		
		//board에 달린 좋아요와 싫어요 갯수 가져오기
		HashMap<String,Integer> rtnMap = likehateService.getReturnlikehate(likehateVO);
		
		JSONArray jsonArr = new JSONArray();
		JSONObject result = new JSONObject();
		if(commentList.size()!=0) {
			for(CommentVO vo : commentList) {
				JSONObject json = new JSONObject();
				json.put("commentSeq",vo.getCommentSeq());
				json.put("userSeq",vo.getUserSeq());
				json.put("boardSeq",vo.getBoardSeq());
				json.put("parSeq",vo.getParSeq());
				json.put("content",vo.getContent());
				json.put("regdate",vo.getRegdate());
				json.put("updatedate",vo.getUpdatedate());
				json.put("isanony",vo.getIsanony());
				json.put("nickname", vo.getNickname());
				json.put("commentCnt",commentList.size());
				json.put("likecount",rtnMap.get("like"));
				json.put("hatecount",rtnMap.get("hate"));
				json.put("boardContent",boardContent);
				jsonArr.add(json);
			}
			result.put("result",jsonArr);
		}else {//댓글없을때
			JSONObject json = new JSONObject();
			json.put("boardContent",boardContent);
			json.put("commentCnt",commentList.size());
			json.put("likecount",rtnMap.get("like"));
			json.put("hatecount",rtnMap.get("hate"));
			jsonArr.add(json);
			result.put("result",jsonArr);
		}
		return result;
	}
	
	@RequestMapping(value = "/commentInsert.tmssul", method = { RequestMethod.POST })
	@ResponseBody
	public JSONObject commentInsert(HttpServletRequest req, HttpServletResponse resp, HttpSession session, CommentVO vo) {
		JSONObject json = new JSONObject();
		try { // 예외처리
			vo.setUserSeq(Integer.parseInt((String)session.getAttribute("userSeq")));
		} catch (NumberFormatException e) {
			return null;
		}
		int result = service.commentInsert(vo);
		int commentSize = service.getCommentSize(vo);
		if(result==1) {
			//성공
			json.put("content",vo.getContent());//댓글 넣은거.
			json.put("nickname",(String)session.getAttribute("userid"));
			json.put("commentSize",commentSize);
			//json.put("",);
			json.put("response", 1);
		}else {
			//실패
			//NewPageAction
			json.put("response", -1);	
		}
		return json;
	}
}
