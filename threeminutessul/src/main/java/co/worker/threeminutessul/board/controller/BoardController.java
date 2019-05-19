package co.worker.threeminutessul.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.board.service.BoardServiceIF;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServiceIF service;
	
	@RequestMapping(value = "/boardTest.tmssul", method = { RequestMethod.GET })
	public String boardTest(HttpServletRequest req, HttpServletResponse resp) {
		List<BoardVO> list = service.getBoard();
		/*JSONArray jsonArr = new JSONArray();
		for(BoardVO vo : list) {
			JSONObject json = new JSONObject();
			json.put("seq", vo.getBoardSeq());
			json.put("content",vo.getContent());
			jsonArr.add(json);
		}*/
		//req.setAttribute("jsonlist", jsonArr);
		req.setAttribute("list",list);
		return "board/boardList";
	}
	
}
