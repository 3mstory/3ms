package co.worker.threeminutessul.comment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.worker.threeminutessul.comment.medel.CommentVO;
import co.worker.threeminutessul.comment.service.CommentServiceIF;

@Controller
public class CommentController {
	
	@Autowired
	private CommentServiceIF service;
	
	@RequestMapping(value = "/commentList.tmssul", method = { RequestMethod.GET })
	public void commentList(HttpServletRequest req, HttpServletResponse resp, int boardSeq) {
		List<CommentVO> commentList = service.getComment(boardSeq);
		System.out.println(commentList);
	}
}
