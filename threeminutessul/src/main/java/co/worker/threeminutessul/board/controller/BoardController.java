package co.worker.threeminutessul.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.board.service.BoardServiceIF;
import co.worker.threeminutessul.likeyhate.service.LikeyHateServiceIF;
import co.worker.threeminutessul.util.FileBean;
import co.worker.threeminutessul.util.JavaUtil;
import co.worker.threeminutessul.util.NewPageAction;
import co.worker.threeminutessul.util.fileupload.FileUploadUtil;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServiceIF service;
	
	@Autowired
	private LikeyHateServiceIF likehateservice;
	
	@RequestMapping(value = "/boardList.tmssul", method = { RequestMethod.GET })
	public String boardList(HttpServletRequest req, HttpServletResponse resp, HttpSession session,Integer page) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		if(page==null) page = 1;
		String userSeq = (String)session.getAttribute("userSeq");
		list = service.getBoard(userSeq,page);
		JSONArray jsonArr = new JSONArray();
		for(BoardVO vo : list) {
			JSONObject json = new JSONObject();
			json.put("userid", vo.getUserid());
			json.put("profile", vo.getProfile());
			json.put("writer",vo.getNickname());
			json.put("regdate",vo.getRegdate());
			json.put("title",vo.getTitle());
			json.put("boardSeq",vo.getBoardSeq());
			jsonArr.add(json);
		}
		if(session.getAttribute("userid")==null) { // 그냥 글 제목만 둘러볼 사람들
			
			
		}else {
			//로그인 했으면 그 유저가 어떤글에 좋아요를 눌렀는지 표기해놔야함.
			
		}
		req.setAttribute("list",list);
		return "board/boardList";
	}
	
	@RequestMapping(value = "/ajaxboardList.tmssul", method = { RequestMethod.GET })
	@ResponseBody
	public JSONArray ajaxboardList(HttpServletRequest req, HttpServletResponse resp, HttpSession session,int page) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		String userSeq = (String)session.getAttribute("userSeq");
		list = service.getBoard(userSeq,page);
		JSONArray jsonArr = new JSONArray();
		for(BoardVO vo : list) {
			JSONObject json = new JSONObject();
			json.put("userid", vo.getUserid());
			json.put("profile", vo.getProfile());
			json.put("writer",vo.getNickname());
			json.put("regdate",vo.getRegdate());
			json.put("title",vo.getTitle());
			json.put("boardSeq",vo.getBoardSeq());
			jsonArr.add(json);
		}
		
		return jsonArr;
	}
	
	
	@RequestMapping(value = "/boardAdd.tmssul", method = { RequestMethod.GET })
	public String boardAdd(HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws IOException {
		/*if(session.getAttribute("userid")==null 
				|| session.getAttribute("userid").equals("")) {
			//로그인안했으면 튕겨내야함.
			String actionCode = "alert('로그인을 먼저 진행해주시기 바랍니다.'); history.back();";
			//String actionCode = "alert('로그인을 먼저 진행해주시기 바랍니다.'); history.back();";
			NewPageAction.action(resp, actionCode);
			return null
		};*/
		return "board/boardAdd";
		//로그인을 먼저 진행해주시기 바랍니다.
	}
	
	@RequestMapping(value = "/boardAddOk.tmssul", method = { RequestMethod.POST })
	public void boardAddOk(HttpServletRequest req, HttpServletResponse resp, HttpSession session, BoardVO vo) throws Exception {
		vo.setUserid((String)session.getAttribute("userid"));
		vo.setWriter(Integer.parseInt((String)session.getAttribute("userSeq")));
		vo.setIsanony(0);
		
		int result = service.insertBoard(vo);
		String actionCode = "";
		if(result==1) {//글 등록 성공
			actionCode="alert('글을 동록했습니다.'); location.href='/threeminutessul/boardList.tmssul'";
		}else {//글 등록 실패
			actionCode="alert('글을 등록하는데 에러가 발생'); history.back();";
		}
		NewPageAction.action(resp, actionCode);
	}
	
}
