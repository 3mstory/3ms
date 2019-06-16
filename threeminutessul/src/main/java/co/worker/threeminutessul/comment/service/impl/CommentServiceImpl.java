package co.worker.threeminutessul.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.worker.threeminutessul.comment.dao.CommentDaoIF;
import co.worker.threeminutessul.comment.medel.CommentVO;
import co.worker.threeminutessul.comment.service.CommentServiceIF;

@Service
public class CommentServiceImpl implements CommentServiceIF {
	@Autowired
	private CommentDaoIF dao;

	@Override
	public List<CommentVO> getComment(int boardSeq) {
		return dao.getComment(boardSeq);
	}
}
