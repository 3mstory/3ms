package co.worker.threeminutessul.comment.controller;

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

import co.worker.threeminutessul.comment.medel.CommentVO;
import co.worker.threeminutessul.comment.service.CommentServiceIF;

@Controller
public class CommentController {
	
	@Autowired
	private CommentServiceIF service;
	
	@RequestMapping(value = "/commentList.tmssul", method = { RequestMethod.GET })
	@ResponseBody
	public JSONObject commentList(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String boardSeq) {
		
		List<CommentVO> commentList = service.getComment(Integer.parseInt(boardSeq));
		JSONArray jsonArr = new JSONArray();
		JSONObject result = new JSONObject();
		if(commentList !=null) {
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
				jsonArr.add(json);
			}
			result.put("result",jsonArr);
		}
		return result;
	}
	
	@RequestMapping(value = "/commentInsert.tmssul", method = { RequestMethod.GET })
	public CommentVO commentInsert(HttpServletRequest req, HttpServletResponse resp, HttpSession session, CommentVO vo) {
		vo.setUserSeq((Integer)session.getAttribute("userSeq"));
		int result = service.commentInsert(vo);
		if(result==1) {
			//성공
			return vo;
		}else {
			//실패
			//NewPageAction
			return null;
		}
	}
}
