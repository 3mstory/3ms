package co.worker.threeminutessul.comment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.worker.threeminutessul.board.service.BoardServiceIF;
import co.worker.threeminutessul.comment.medel.CommentVO;
import co.worker.threeminutessul.comment.service.CommentServiceIF;
import co.worker.threeminutessul.likeyhate.service.LikeyHateServiceIF;

@RestController
public class CommentController {
	
	@Autowired
	private CommentServiceIF service;
	@Autowired
	private BoardServiceIF boardService;
	@Autowired
	private LikeyHateServiceIF likehateService;
	
	@GetMapping(value = "/commentList.tmssul", 
			produces= {MediaType.APPLICATION_XML_VALUE,
					   MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<CommentVO>> commentList(HttpServletRequest req, HttpServletResponse resp, HttpSession session, int boardSeq) throws Exception {
		List<CommentVO> commentList = new ArrayList<CommentVO>();
		
		//세션검사.
		if(session.getAttribute("userid") == null) {
			return new ResponseEntity<>(commentList, HttpStatus.OK);
		}
		commentList = service.getComment(boardSeq); 
		return new ResponseEntity<>(commentList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/commentInsert.tmssul"
			, consumes ="application/json"
			, produces= {MediaType.APPLICATION_JSON_VALUE})
	
	public ResponseEntity<CommentVO> commentInsert(HttpServletRequest req, HttpServletResponse resp, HttpSession session
			, @RequestBody CommentVO vo) {
		
		//JSONObject json = new JSONObject();
		try { // 예외처리
			vo.setUserSeq(Integer.parseInt((String)session.getAttribute("userSeq"))); // 로그인한 유저의 seq 번호 넣기.
		} catch (NumberFormatException e) {
			return null;
		}
		
		int result = service.commentInsert(vo); //등록 성공여부. 1/0
		int commentCnt = service.getCommentSize(vo);
		CommentVO resultVO = new CommentVO();
		if(result == 1) {
			resultVO.setResult(result);//등록성공여부
			resultVO.setCommentCnt(commentCnt); // 댓글 개수
			resultVO.setNickname((String)session.getAttribute("nickname"));
			resultVO.setContent(vo.getContent());
		}
		
		return result == 1
				? new ResponseEntity<>(resultVO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
