package co.worker.threeminutessul.board.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.board.service.BoardServiceIF;
import co.worker.threeminutessul.likeyhate.service.LikeyHateServiceIF;
import co.worker.threeminutessul.util.NewPageAction;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServiceIF service;
	
	@Autowired
	private LikeyHateServiceIF likehateservice;
	
	/**
	 * 게시판 list 그리는 메소드. 여기추가하면 ajaxboardlist 메소드도 추가해야하는지 판단할것.
	 * @param req
	 * @param resp
	 * @param session
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/boardList.tmssul", method = { RequestMethod.GET })
	public String boardList(HttpServletRequest req, HttpServletResponse resp, HttpSession session,Integer page) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		if(page==null) page = 1;
		String userSeq = (String)session.getAttribute("userSeq");
		list = service.getBoard(userSeq,page);
		JSONArray jsonArr = new JSONArray();
		for(BoardVO vo : list) {
			JSONObject json = new JSONObject();
			json.put("loginUserSeq", session.getAttribute("userSeq"));
			json.put("userid", vo.getUserid());
			json.put("profile", vo.getProfile());
			json.put("writer",vo.getNickname());
			json.put("userSeq", vo.getWriter());
			json.put("regdate",vo.getTimechange() == null ? vo.getRegdate() : vo.getTimechange());
			json.put("title",vo.getTitle());
			json.put("boardSeq",vo.getBoardSeq());
			jsonArr.add(json);
		}
		
		req.setAttribute("list",jsonArr);
		return "board/boardList";
	}
	
	/**
	 * ajax로 보드 페이징 처리하는 메소드. 내용 추가시 boardlist 메소드도 추가해야하는지 판단할 것.
	 * @param req
	 * @param resp
	 * @param session
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/ajaxboardList.tmssul", method = { RequestMethod.GET })
	@ResponseBody
	public JSONArray ajaxboardList(HttpServletRequest req, HttpServletResponse resp, HttpSession session,int page) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		String userSeq = (String)session.getAttribute("userSeq");
		list = service.getBoard(userSeq,page);
		JSONArray jsonArr = new JSONArray();
		for(BoardVO vo : list) {
			JSONObject json = new JSONObject();
			json.put("userSeq", session.getAttribute("userSeq"));
			json.put("userid", vo.getUserid());
			json.put("profile", vo.getProfile());
			json.put("writer",vo.getNickname());
			json.put("userSeq", vo.getWriter());
			json.put("regdate",vo.getTimechange() == null ? vo.getRegdate() : vo.getTimechange());
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
	

	@RequestMapping(value = "/boardUpdate.tmssul", method = { RequestMethod.GET })
	public String boardUpdate(HttpServletRequest req, HttpServletResponse resp,HttpSession session, Integer boardSeq) throws Exception {
		if(boardSeq != null) {
			BoardVO board = service.getBoard(boardSeq);
			req.setAttribute("board",board);
		}else {
			throw new Exception("[Error] : update boardSeq null");
		}
		return "board/boardUpdate";
	}
	
	@PostMapping("/boardUpdateOk")
	public String boardUpdateOk(HttpServletRequest req, HttpServletResponse resp,HttpSession session, BoardVO board) throws Exception {
		int result = 0;
		//업데이트 처리
		if(board!=null) {
			result = service.updateBoard(board);
			req.setAttribute("result",result);
		}else {
			throw new Exception("[Error] : boardUpdateOk boardVO null");
		}
		return "redirect:/boardList.tmssul"; 
	}
}
